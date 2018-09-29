package com.bochenchleba.match;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;

import com.bochenchleba.match.workers.BitmapResizer;


public class MatchView extends android.support.v7.widget.AppCompatImageButton {

    public MatchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setAlpha(0f);
        this.animate()
                .alpha(1.0f)
                .setDuration(Constants.ANIM_BUTTON_ALPHA_DURATION);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();

        setMeasuredDimension(width, width);
    }


    public void setBgrd (int imgSetId, int randomNumber){

        switch (imgSetId) {

            case Constants.IMG_SET_ID_ANIMALS:

                Bitmap resizedBitmap;

                switch (randomNumber) {

                    case 0:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_0);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 1:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_1);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 2:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_2);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 3:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_3);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 4:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_4);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 5:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_5);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 6:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_6);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 7:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_7);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 8:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_8);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 9:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_9);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 10:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_10);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 11:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_11);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 12:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_12);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 13:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_13);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 14:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_14);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 15:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_15);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 16:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_16);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 17:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_17);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 18:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_18);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 19:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_19);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 20:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_20);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 21:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_21);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 22:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_22);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 23:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_23);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 24:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_24);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 25:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_25);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 26:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_26);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 27:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_27);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 28:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_28);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 29:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_29);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 30:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_30);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 31:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_31);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 32:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_32);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 33:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_33);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 34:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_34);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 35:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_35);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 36:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_36);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 37:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_37);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 38:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_38);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 39:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_39);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 40:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_40);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 41:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_41);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 42:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_42);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 43:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_43);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 44:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_44);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 45:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_45);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 46:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_46);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 47:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_47);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 48:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_48);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 49:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_49);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 50:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_50);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 51:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_51);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 52:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_52);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 53:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_53);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 54:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_54);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 55:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_55);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 56:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_56);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 57:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_57);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 58:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_58);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 59:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_59);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 60:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_60);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 61:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_61);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 62:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_62);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 63:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_63);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 64:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_64);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 65:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_65);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 66:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_66);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 67:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_67);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 68:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_68);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 69:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_69);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 70:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_70);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 71:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_71);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 72:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_72);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 73:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_73);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 74:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_74);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 75:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_75);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 76:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_76);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 77:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_77);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 78:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_78);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 79:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_79);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 80:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_80);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 81:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_81);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 82:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.animal_82);
                        setImageBitmap(resizedBitmap);
                        break;
                }
                break;

            case Constants.IMG_SET_ID_NATURE:

                switch (randomNumber) {

                    case 0:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_0);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 1:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_1);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 2:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_2);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 3:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_3);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 4:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_4);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 5:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_5);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 6:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_6);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 7:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_7);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 8:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_8);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 9:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_9);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 10:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_10);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 11:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_11);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 12:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_12);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 13:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_13);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 14:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_14);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 15:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_15);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 16:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_16);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 17:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_17);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 18:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_18);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 19:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.nature_19);
                        setImageBitmap(resizedBitmap);
                        break;
                }
                break;

            case Constants.IMG_SET_ID_WEATHER:

                switch (randomNumber) {

                    case 0:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_0);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 1:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_1);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 2:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_2);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 3:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_3);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 4:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_4);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 5:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_5);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 6:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_6);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 7:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_7);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 8:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_8);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 9:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_9);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 10:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_10);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 11:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_11);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 12:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_12);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 13:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_13);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 14:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_14);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 15:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_15);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 16:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_16);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 17:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_17);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 18:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_18);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 19:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_19);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 20:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_20);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 21:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_21);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 22:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_22);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 23:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_23);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 24:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_24);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 25:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_25);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 26:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_26);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 27:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_27);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 28:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_28);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 29:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_29);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 30:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_30);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 31:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_31);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 32:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_32);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 33:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_33);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 34:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_34);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 35:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_35);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 36:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_36);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 37:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_37);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 38:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_38);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 39:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_39);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 40:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_40);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 41:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_41);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 42:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_42);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 43:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.weather_43);
                        setImageBitmap(resizedBitmap);
                        break;
                }
                break;

            case Constants.IMG_SET_ID_LETTERS:

                switch (randomNumber) {

                    case 0:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.lettera);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 1:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterb);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 2:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterc);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 3:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterd);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 4:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.lettere);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 5:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterf);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 6:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterg);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 7:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterh);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 8:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letteri);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 9:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterj);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 10:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterk);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 11:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterl);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 12:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterm);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 13:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.lettern);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 14:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.lettero);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 15:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterp);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 16:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterq);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 17:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterr);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 18:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letters);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 19:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.lettert);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 20:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letteru);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 21:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterv);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 22:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterw);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 23:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterx);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 24:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.lettery);
                        setImageBitmap(resizedBitmap);
                        break;

                    case 25:
                        resizedBitmap = BitmapResizer.decodeSampledBitmapFromResource(
                                getResources(), R.drawable.letterz);
                        setImageBitmap(resizedBitmap);
                        break;
                }
                break;
        }
    }
}
