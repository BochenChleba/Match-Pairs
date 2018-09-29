package com.bochenchleba.match.workers;

import android.app.Activity;
import android.os.Handler;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;

import com.bochenchleba.match.Constants;
import com.bochenchleba.match.MatchView;
import com.bochenchleba.match.R;

import java.lang.ref.WeakReference;

public class Clicker {

    private MatchView prevClickedBtn;

    private Clicker.MyRunnable delayer;

    private Activity activity;

    private int imgSetId;

    public Clicker(Activity activity, int imgSetId){

        this.activity = activity;

        delayer = new Clicker.MyRunnable();

        this.imgSetId = imgSetId;
    }

    public void firstClick (final MatchView view){

        view.animate()
                .scaleXBy(-1f)
                .setInterpolator(new AccelerateInterpolator(0.75f))
                .setDuration(Constants.ANIM_BUTTON_SCALE_DURATION)
                .withEndAction(new Runnable() {

            @Override
            public void run() {

                view.setBgrd(imgSetId, Integer.parseInt(view.getTag().toString()));

                view.animate()
                        .scaleXBy(1f)
                        .setInterpolator(new DecelerateInterpolator(0.75f))
                        .setDuration(Constants.ANIM_BUTTON_SCALE_DURATION);
            }
        });

        view.setClickable(false);

        prevClickedBtn = view;
    }

    public Boolean secondClick (final MatchView view){

        view.animate()
                .scaleXBy(-1f)
                .setInterpolator(new AccelerateInterpolator(0.75f))
                .setDuration(Constants.ANIM_BUTTON_SCALE_DURATION)
                .withEndAction(new Runnable() {

            @Override
            public void run() {

                view.setBgrd(imgSetId, Integer.parseInt(view.getTag().toString()));

                view.animate()
                        .scaleXBy(1f)
                        .setInterpolator(new DecelerateInterpolator(0.75f))
                        .setDuration(Constants.ANIM_BUTTON_SCALE_DURATION);

                if (view.getTag() == prevClickedBtn.getTag()){      //MATCH

                    view.animate()
                            .rotation(Constants.ANIM_BUTTON_ROTATE_FACTOR)
                            .setDuration(Constants.ANIM_BUTTON_ROTATE_DURATION);

                    prevClickedBtn.animate()
                            .rotation(Constants.ANIM_BUTTON_ROTATE_FACTOR)
                            .setDuration(Constants.ANIM_BUTTON_ROTATE_DURATION);
                }
            }
        });


        if (view.getTag() == prevClickedBtn.getTag()){        //MATCH

            view.setClickable(false);
            prevClickedBtn.setClickable(false);

            return true;
        }

        else {                          // NOT MATCH

            delayer.setViews(activity, prevClickedBtn, view);

            mHandler.postDelayed(delayer, Constants.INT_DELAY_OF_FIELD_HIDE);

            prevClickedBtn.setClickable(true);

            return false;
        }
    }

    private static class MyHandler extends Handler {}
    private final Clicker.MyHandler mHandler = new Clicker.MyHandler();

    public static class MyRunnable implements Runnable {

        private WeakReference<Activity> mActivity;
        private ImageButton view1;
        private ImageButton view2;

        public void setViews(Activity activity, ImageButton view1, ImageButton view2){

            mActivity = new WeakReference<>(activity);

            this.view1 = view1;

            this.view2 = view2;
        }

        @Override
        public void run() {

            Activity activity = mActivity.get();

            if (activity != null) {
                view1.setImageResource(R.drawable.background_card);
                view2.setImageResource(R.drawable.background_card);
            }
        }
    }
}
