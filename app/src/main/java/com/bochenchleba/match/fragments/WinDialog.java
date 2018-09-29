package com.bochenchleba.match.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bochenchleba.match.Consts;
import com.bochenchleba.match.R;

public class WinDialog extends DialogFragment {

    private GameFragment gameFragment = null;

    private static final String PREFS = "prefs";
    private static final String PREFS_HIGHSCORE = "highscore";

    SharedPreferences prefs;

    public WinDialog(){
    }

    public static WinDialog newInstance(long time, int attempts, int fields, int id) {

        WinDialog frag = new WinDialog();

        Bundle args = new Bundle();
        args.putLong(Consts.BUNDLE_ARGS_TIME, time);
        args.putInt(Consts.BUNDLE_ARGS_ATTEMPTS, attempts);
        args.putInt(Consts.BUNDLE_ARGS_FIELDS, fields);
        args.putInt(Consts.PREFS_IMAGES_SET, id);

        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        gameFragment = (GameFragment) this.getParentFragment();
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        return inflater.inflate(R.layout.dialog_win, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        long elapsedTime = getArguments().getLong(Consts.BUNDLE_ARGS_TIME, 1);
        int attempts = getArguments().getInt(Consts.BUNDLE_ARGS_ATTEMPTS, 1);
        int fields = getArguments().getInt(Consts.BUNDLE_ARGS_FIELDS, 12);

        TextView tvTime = (TextView) view.findViewById(R.id.tvTime_winDialog);
        TextView tvAttempts = (TextView) view.findViewById(R.id.tvClicks_winDialog);
        TextView tvFields = (TextView) view.findViewById(R.id.tvFields_winDialog);
        TextView tvScore = (TextView) view.findViewById(R.id.tvScore_winDialog);
        TextView tvHighScore = (TextView) view.findViewById(R.id.tvHighScore_winDialog);
        ImageView ivExclamation = (ImageView) view.findViewById(R.id.ivExclamation_winDialog);

        Button btnReset = (Button) view.findViewById(R.id.btnReset_winDialog);
        Button btnReturn = (Button) view.findViewById(R.id.btnReturn_winDialog);

        prefs = getActivity().getSharedPreferences(PREFS, Context.MODE_PRIVATE);

        double elapsedTimeFloat = Float.parseFloat(String.valueOf(elapsedTime)) / 1000;
        int score = (int) ( (Math.pow(fields, Math.E)) / ( Math.sqrt(elapsedTimeFloat*attempts) ) *10);
        int highscore = prefs.getInt(PREFS_HIGHSCORE, 0);

        if (score>highscore){

            highscore = score;

            prefs.edit().putInt(PREFS_HIGHSCORE, highscore).apply();

            ivExclamation.setVisibility(View.VISIBLE);
            tvScore.setTextColor(ContextCompat.getColor(getContext(), R.color.green_text));
        }

        else{
            ivExclamation.setVisibility(View.INVISIBLE);
            tvScore.setTextColor(ContextCompat.getColor(getContext(), android.R.color.white));
        }

        tvTime.setText(getString(R.string.win_dialog_time, elapsedTimeFloat));
        tvAttempts.setText(getString(R.string.win_dialog_attempts, attempts));
        tvFields.setText(getString(R.string.win_dialog_fields, fields));
        tvScore.setText(getString(R.string.win_dialog_score, score));
        tvHighScore.setText(getString(R.string.win_dialog_highscore, highscore));

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gameFragment!=null)
                    gameFragment.startGame();
                dismiss();
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.returnToMenu();
            }
        });
    }
}
