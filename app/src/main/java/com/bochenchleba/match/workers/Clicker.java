package com.bochenchleba.match.workers;

import android.app.Activity;
import android.os.Handler;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;

import com.bochenchleba.match.Consts;
import com.bochenchleba.match.MatchView;
import com.bochenchleba.match.R;

import java.lang.ref.WeakReference;

/**
 * Created by bochenchleba on 15/10/17.
 */


public class Clicker {

    private MatchView prevClickedBtn;

    private Clicker.MyRunnable delayer;

    private Activity activity;

    private int imgsSetId;

    public Clicker(Activity activity, int imgsSetId){
        this.activity = activity;
        delayer = new Clicker.MyRunnable();
        this.imgsSetId = imgsSetId;
    }

    public void firstClick (final MatchView view){

        view.animate()
                .scaleXBy(-1f)
                .setInterpolator(new AccelerateInterpolator(0.75f))
                .setDuration(Consts.ANIM_BUTTON_SCALE_DURATION)
                .withEndAction(new Runnable() {

            @Override
            public void run() {

                view.setBgrd(imgsSetId, Integer.parseInt(view.getTag().toString()));

                view.animate()
                        .scaleXBy(1f)
                        .setInterpolator(new DecelerateInterpolator(0.75f))
                        .setDuration(Consts.ANIM_BUTTON_SCALE_DURATION);
            }
        });

        view.setClickable(false);

        prevClickedBtn = view;
    }

    public Boolean secondClick (final MatchView view){

        view.animate()
                .scaleXBy(-1f)
                .setInterpolator(new AccelerateInterpolator(0.75f))
                .setDuration(Consts.ANIM_BUTTON_SCALE_DURATION)
                .withEndAction(new Runnable() {

            @Override
            public void run() {

                view.setBgrd(imgsSetId, Integer.parseInt(view.getTag().toString()));

                view.animate()
                        .scaleXBy(1f)
                        .setInterpolator(new DecelerateInterpolator(0.75f))
                        .setDuration(Consts.ANIM_BUTTON_SCALE_DURATION);

                if (view.getTag() == prevClickedBtn.getTag()){      //PARA

                    view.animate()
                            .rotation(Consts.ANIM_BUTTON_ROTATE_FACTOR)
                            .setDuration(Consts.ANIM_BUTTON_ROTATE_DURATION);

                    prevClickedBtn.animate()
                            .rotation(Consts.ANIM_BUTTON_ROTATE_FACTOR)
                            .setDuration(Consts.ANIM_BUTTON_ROTATE_DURATION);
                }
            }
        });


        if (view.getTag() == prevClickedBtn.getTag()){        // PARA

            view.setClickable(false);
            prevClickedBtn.setClickable(false);

            return true;
        }

        else {                          // NIEPARA

            delayer.setViews(activity, prevClickedBtn, view);

            mHandler.postDelayed(delayer, Consts.INT_DELAY_OF_HIDINGS_FIELDS);

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
