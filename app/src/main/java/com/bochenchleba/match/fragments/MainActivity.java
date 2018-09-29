package com.bochenchleba.match.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.bochenchleba.match.Consts;
import com.bochenchleba.match.R;


public class MainActivity extends AppCompatActivity implements MainMenuFragment.MainMenuListener {

    private GameFragment gameFragment;

    private SharedPreferences preferences;
    private static FragmentManager fm;

    Toolbar myToolbar;
    ActionBar actionBar;

    private boolean soundOn = true;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        actionBar = getSupportActionBar();

        fm = getSupportFragmentManager();

        returnToMenu();

        preferences = this.getSharedPreferences(Consts.PREFS_NAME, Context.MODE_PRIVATE);

        commitFragmentTransaction(MainMenuFragment.newInstance(
                preferences.getInt(Consts.PREFS_IMAGES_SET,0),
                preferences.getInt(Consts.PREFS_FIELD_COUNT,12),
                preferences.getInt(Consts.PREFS_FIELD_COUNT_POS,0)
                ),
                false);
    }


    private void commitFragmentTransaction (Fragment fragment, boolean addToBackstack){

        FragmentTransaction ft = fm
                .beginTransaction()
                .add(R.id.fullscreen_frame_layout, fragment);

        if (addToBackstack)
            ft.addToBackStack(null);

        ft.commit();
    }

    private void showResetDialog(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setPositiveButton(R.string.reset_dialog_positive,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (gameFragment!=null)
                            gameFragment.startGame();
                    }
                });

        alertDialogBuilder.setNegativeButton(R.string.reset_dialog_negative,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

        alertDialogBuilder.setIcon(R.drawable.ic_reset);
        alertDialogBuilder.setMessage(R.string.reset_dialog_message);
        alertDialogBuilder.setTitle(R.string.reset_dialog_title);

        alertDialogBuilder.create().show();
    }

    private void showCreditsDialog(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setNegativeButton(R.string.info_dialog_negative,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

        alertDialogBuilder.setIcon(R.drawable.ic_info);
        alertDialogBuilder.setTitle(R.string.toolbar_info);

        tv = new TextView(this);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        tv.setText(R.string.info_dialog_message);
        tv.setTextSize(20);
        tv.setPadding(30,24,30,20);

        tv.setLinksClickable(true);

        alertDialogBuilder.setView(tv);

        alertDialogBuilder.create().show();
    }


    @Override
    public void onNewGamePressed() {

        gameFragment = null;

        gameFragment = GameFragment.newInstance(
                preferences.getInt(Consts.PREFS_IMAGES_SET, Consts.IMGS_SET_ID_ANIMALS),
                preferences.getInt(Consts.PREFS_FIELD_COUNT,12),
                soundOn);

        commitFragmentTransaction(gameFragment, true);
    }

    @Override
    public void onImagesSetSelected(int pos) {
        preferences.edit().putInt(Consts.PREFS_IMAGES_SET, pos).apply();
    }

    @Override
    public void onFieldCountSelected(int fieldCount, int pos) {
        preferences.edit().putInt(Consts.PREFS_FIELD_COUNT, fieldCount).apply();
        preferences.edit().putInt(Consts.PREFS_FIELD_COUNT_POS, pos).apply();
    }

    public static void returnToMenu(){
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_main, menu);

        if (!soundOn){
            menu.findItem(R.id.action_sound).setIcon(R.drawable.ic_volume_off);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                fm.popBackStack();
                return true;

            case R.id.action_reset:
                showResetDialog();
                return true;

            case R.id.action_sound:

                if (soundOn){
                    if (gameFragment!=null)
                        gameFragment.setSound(false);
                    item.setIcon(R.drawable.ic_volume_off);
                    soundOn = false;
                }

                else {
                    if (gameFragment!=null)
                        gameFragment.setSound(true);
                    item.setIcon(R.drawable.ic_volume_on);
                    soundOn = true;
                }

                return true;

            case R.id.action_info:
                showCreditsDialog();
                return true;

            default:
                break;
        }

        return false;
    }
}
