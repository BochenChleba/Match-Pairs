package com.bochenchleba.match.fragments;

import android.app.Activity;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bochenchleba.match.Constants;
import com.bochenchleba.match.MatchView;
import com.bochenchleba.match.R;
import com.bochenchleba.match.workers.Switcher;
import com.bochenchleba.match.workers.Clicker;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameFragment extends Fragment implements SoundPool.OnLoadCompleteListener {

    private int fieldCount = 30;

    private int remainingFields;

    private Boolean clicked = false;

    private int attempts, matches = 0;

    private long prevClickTime = 0;

    private ArrayList<Integer> idList = new ArrayList<>();

    private LinearLayout mainLinearLayout;

    private int drawablesRange = 6;
    int number = 0;

    Clicker clicker;

    private ActionBar actionBar;
    private LinearLayout actionBarLinearLayout;
    private TextView tvToolbarTime;
    private TextView tvToolbarMatches;

    private SoundPool soundPool;
    private int musicBackgroundId;
    private boolean musicBackgroundLoaded = false;
    private int soundBtnClickId;
    private boolean soundBtnClickLoaded = false;
    private int soundWinId;
    private boolean soundWinLoaded = false;
    private int musicBackgroundStreamId = 0;
    private boolean soundOn = true;

    private View mainView;

    private long elapsedTime = 0;
    private long previousTime;
    private boolean isRunning = true;

    public GameFragment(){
    }

    public static GameFragment newInstance(int imgsSetId, int fieldCount, boolean soundOn) {

        GameFragment frag = new GameFragment();
        Bundle args = new Bundle();

        args.putInt(Constants.PREFS_IMAGES_SET, imgsSetId);
        args.putInt(Constants.PREFS_FIELD_COUNT, fieldCount);
        args.putBoolean(Constants.PREFS_FIELD_SOUND, soundOn);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        init(inflater, container);

        if (mainLinearLayout != null)
            startGame();

        return mainView;
    }

    public void onPause(){
        super.onPause();

        isRunning = false;

        if (actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBarLinearLayout.setVisibility(View.GONE);
        }

        timerHandler.removeCallbacks(timerRunnable);

        soundPool.release();
        soundPool = null;
    }

    public void onResume(){
        super.onResume();

        isRunning = true;

        setSoundPool();

        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBarLinearLayout.setVisibility(View.VISIBLE);
        }

        timerRunnable.run();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_game, menu);
        super.onCreateOptionsMenu(menu, inflater);

        if (!soundOn){
            menu.findItem(R.id.action_sound).setIcon(R.drawable.ic_volume_off);
        }
    }


    private void init(LayoutInflater inflater, ViewGroup container){

        getScreenHeight();

        int imgSetId = getArguments().getInt(Constants.PREFS_IMAGES_SET);
        fieldCount = getArguments().getInt(Constants.PREFS_FIELD_COUNT);
        soundOn = getArguments().getBoolean(Constants.PREFS_FIELD_SOUND);

        drawablesRange = Switcher.getDrawablesRange(imgSetId);

        clicker = new Clicker(getActivity(), imgSetId);

        mainView = Switcher.inflateMainView(fieldCount, inflater, container);

        findViews();

        setHasOptionsMenu(true);
    }

    private void findViews(){

        Activity activity = getActivity();
        actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBarLinearLayout = activity.findViewById(R.id.toolbar_linear_layout);
        mainLinearLayout = mainView.findViewById(R.id.main_linear_layout);
        tvToolbarTime = activity.findViewById(R.id.tv_toolbar_time);
        tvToolbarMatches = activity.findViewById(R.id.tv_toolbar_matches);

        if (mainLinearLayout == null){

            try{
                Button btn = mainView.findViewById(R.id.layout0_btn_back);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getActivity().getSupportFragmentManager().beginTransaction().
                                remove(GameFragment.this).commit();
                    }
                });
            }

            catch (Exception e){
                Toast.makeText(getContext(), R.string.error_inflating_layout + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    public void startGame(){

        remainingFields = fieldCount;
        attempts = 0;

        previousTime = System.currentTimeMillis();
        elapsedTime = 0;

        clicked = false;
        matches = 0;

        tvToolbarTime.setText(getString(R.string.toolbar_tv_time, 0.0f));
        tvToolbarMatches.setText(getString(R.string.toolbar_tv_matches,matches));

        createRandomList();
        setBtns();

        timerHandler.postDelayed(timerRunnable, 0);

        if (musicBackgroundLoaded){
            soundPool.stop(musicBackgroundStreamId);
            musicBackgroundStreamId = soundPool.play(musicBackgroundId, 0.15f,0.15f, 2, -1, 1);
        }

        if ((!soundOn)&& (soundPool!=null))
            soundPool.autoPause();
    }

    private void createRandomList(){

        Random random = new Random();

        for (int i=0; i<fieldCount/2; i++){
            addNumberToArray(random);
        }

        Collections.shuffle(idList);
    }

    private void setBtns(){

        for (int i=0; i<mainLinearLayout.getChildCount(); i++){
            LinearLayout line = (LinearLayout) mainLinearLayout.getChildAt(i);

            for (int j=0; j<line.getChildCount(); j++){

                MatchView btn = (MatchView) line.getChildAt(j);

                btn.setImageResource(R.drawable.background_card);
                btn.setTag(idList.get(0));

                idList.remove(0);

                btn.setOnClickListener(clickListener);
            }
        }
    }

    public void showWinDialog(){

        FragmentManager fm = getChildFragmentManager();

        timerHandler.removeCallbacks(timerRunnable);

        WinDialog dialog = WinDialog.newInstance(elapsedTime,attempts,fieldCount, getId());

        dialog.show(fm, "");

    }

    private void addNumberToArray(Random random){

        number = random.nextInt(drawablesRange);

        if (!idList.contains(number)){
            idList.add(number);
            idList.add(number);
        }

        else
            addNumberToArray(random);
    }



    private void getScreenHeight(){
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
    }

    private void setSoundPool(){

        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);

        soundPool.setOnLoadCompleteListener(this);

        musicBackgroundId = soundPool.load(getContext(), R.raw.music_background, 2);
        soundBtnClickId = soundPool.load(getContext(), R.raw.sound_btn_click, 1);
        soundWinId = soundPool.load(getContext(), R.raw.sound_win, 1);
    }

    public boolean setSound (boolean on){

        if (on){
            if (soundPool!=null){
                soundOn = true;
                soundPool.autoResume();
                return true;
            }

            else
                return false;
        }

        else{
            if (soundPool!=null){
                soundOn = false;
                soundPool.autoPause();
                return true;
            }

            else
                return false;
        }
    }


    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {

            if (!clicked){

                long deltaTime = System.currentTimeMillis() - prevClickTime;

                if (deltaTime > Constants.INT_DELAY_OF_FIELD_HIDE){

                    clicker.firstClick((MatchView)view);

                    clicked = true;

                    attempts++;

                    if ((soundBtnClickLoaded) && (soundOn))
                        soundPool.play(soundBtnClickId, 0.9f, 0.9f, 1, 0, 1.5f);
                }
            }

            else {

                Boolean match = clicker.secondClick((MatchView) view);

                clicked = false;

                attempts++;

                if (match){

                    tvToolbarMatches.setText(getString(R.string.toolbar_tv_matches,++matches));

                    remainingFields -= 2;

                    if (remainingFields==0){
                        if (musicBackgroundLoaded)
                            soundPool.stop(musicBackgroundStreamId);

                        if ((soundWinLoaded) && (soundOn))
                            soundPool.play(soundWinId, 0.175f, 0.175f, 2, 0, 1.65f);

                        showWinDialog();
                    }
                }

                prevClickTime = System.currentTimeMillis();

                if ((soundBtnClickLoaded) && (soundOn))
                    soundPool.play(soundBtnClickId, 0.9f, 0.9f, 1, 0, 1.5f);
            }
        }

    };

    Handler timerHandler = new Handler();

    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {

            long currentTime = System.currentTimeMillis();

            if (isRunning){

                elapsedTime += currentTime - previousTime;

                double elapsedTimeFloat = Float.parseFloat(String.valueOf(elapsedTime)) / 1000;

                if (isAdded())
                    tvToolbarTime.setText(getString(R.string.toolbar_tv_time, elapsedTimeFloat));
            }

            previousTime = currentTime;

            timerHandler.postDelayed(this, 20);
        }

    };


    @Override
    public void onLoadComplete(SoundPool soundPool, int id, int status) {

        if (status==0){

            switch (id){

                case 1:
                    musicBackgroundLoaded = true;

                    musicBackgroundStreamId = soundPool.play(musicBackgroundId, 0.15f,0.15f, 2, -1, 1);

                    if (!soundOn)
                        soundPool.autoPause();
                    break;

                case 2:
                    soundBtnClickLoaded = true;
                    break;

                case 3:
                    soundWinLoaded = true;
                    break;
            }
        }
    }
}
