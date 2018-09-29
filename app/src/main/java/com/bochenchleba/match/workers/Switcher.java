package com.bochenchleba.match.workers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bochenchleba.match.Constants;
import com.bochenchleba.match.R;

import java.util.ArrayList;

public class Switcher {

    private static ArrayList<String> stringArray = new ArrayList<>();

    public static ArrayAdapter<String> getAdapter (Context context, int id){

        switch (id) {

            case Constants.IMG_SET_ID_ANIMALS:

                stringArray.clear();

                stringArray.add("12");
                stringArray.add("20");
                stringArray.add("32");
                stringArray.add("44");
                break;

            case Constants.IMG_SET_ID_NATURE:

                stringArray.clear();

                stringArray.add("12");
                stringArray.add("20");
                stringArray.add("32");
                break;

            case Constants.IMG_SET_ID_LETTERS:

                stringArray.clear();

                stringArray.add("12");
                stringArray.add("20");
                stringArray.add("32");
                stringArray.add("44");
                break;

            case Constants.IMG_SET_ID_WEATHER:

                stringArray.clear();

                stringArray.add("12");
                stringArray.add("20");
                stringArray.add("32");
                stringArray.add("44");
                break;

            default:

                stringArray.clear();

                stringArray.add("12");
                break;
        }

        String[] strings = new String[stringArray.size()];

        strings = stringArray.toArray(strings);

        ArrayAdapter<String> fieldCountAdapter = new ArrayAdapter<>(context,
                R.layout.spinner_field_count_element, strings);

        fieldCountAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        return fieldCountAdapter;
    }

    public static void setImgInSpinnerItem (int id, ImageView iv){

        switch (id){

            case Constants.IMG_SET_ID_ANIMALS:
                iv.setImageResource(R.drawable.animal_17);
                break;

            case Constants.IMG_SET_ID_NATURE:
                iv.setImageResource(R.drawable.nature_6);
                break;

            case Constants.IMG_SET_ID_LETTERS:
                iv.setImageResource(R.drawable.lettera);
                break;

            case Constants.IMG_SET_ID_WEATHER:
                iv.setImageResource(R.drawable.weather_29);
                break;

            default:
                iv.setImageResource(R.drawable.background_card);
                break;
        }
    }

    public static int getDrawablesRange (int id){

        switch (id){

            case Constants.IMG_SET_ID_ANIMALS:
                return 83;

            case Constants.IMG_SET_ID_NATURE:
                return 20;

            case Constants.IMG_SET_ID_LETTERS:
                return 26;

            case Constants.IMG_SET_ID_WEATHER:
                return 44;

            default:
                return 6;
        }
    }

    public static View inflateMainView (int id, LayoutInflater inflater, ViewGroup container){

        switch (id){

            case 12:
                return inflater.inflate(R.layout.fragment_game_12, container, false);

            case 20:
                return inflater.inflate(R.layout.fragment_game_20, container, false);

            case 32:
                return inflater.inflate(R.layout.fragment_game_32, container, false);

            case 44:
                return inflater.inflate(R.layout.fragment_game_44, container, false);

            default:
                return inflater.inflate(R.layout.fragment_game_0, container, false);
        }
    }
}
