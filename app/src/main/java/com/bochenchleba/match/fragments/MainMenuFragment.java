package com.bochenchleba.match.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.bochenchleba.match.Constants;
import com.bochenchleba.match.ImagesSetSpinnerAdapter;
import com.bochenchleba.match.workers.Switcher;
import com.bochenchleba.match.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by bochenchleba on 10/3/17.
 */

public class MainMenuFragment extends Fragment {

    View mainView;
    Button newGameBtn;
    Spinner imagesSetSpinner;
    Spinner fieldCountSpinner;
    String[] imagesSetArray;
    ArrayAdapter<String> imagesSetAdapter;
    LinearLayout linearLayout;

    MainMenuListener listener;

    public static MainMenuFragment newInstance(int imgsSetId, int fieldCount, int fieldCountPos) {

        MainMenuFragment frag = new MainMenuFragment();

        Bundle args = new Bundle();
        args.putInt(Constants.PREFS_IMAGES_SET, imgsSetId);
        args.putInt(Constants.PREFS_FIELD_COUNT, fieldCount);
        args.putInt(Constants.PREFS_FIELD_COUNT_POS, fieldCountPos);

        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        init(inflater,container);

        setHasOptionsMenu(true);

        MobileAds.initialize(getContext(), getString(R.string.admob_id));
        AdView adView = mainView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        adView.loadAd(adRequest);

        return mainView;
    }


    private void init(LayoutInflater inflater, ViewGroup container){

        mainView = inflater.inflate(R.layout.fragment_main_menu, container, false);

        linearLayout = mainView.findViewById(R.id.linear_lay_menu);

        newGameBtn = mainView.findViewById(R.id.btn_menu_start);
        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                linearLayout.animate().translationXBy(-1 * Constants.ANIM_MENU_ELEMENT_TRANSITION_DISTANCE)
                        .setDuration(Constants.ANIM_MENU_ELEMENT_TRANSITION_DURATION);

                view.animate().translationXBy(Constants.ANIM_MENU_ELEMENT_TRANSITION_DISTANCE)
                        .setDuration(Constants.ANIM_MENU_ELEMENT_TRANSITION_DURATION)
                        .withEndAction(new Runnable() {
                    @Override
                    public void run() {

                        view.animate().translationXBy(-1 * Constants.ANIM_MENU_ELEMENT_TRANSITION_DISTANCE);
                        linearLayout.animate().translationXBy(Constants.ANIM_MENU_ELEMENT_TRANSITION_DISTANCE);
                        listener.onNewGamePressed();
                    }
                });


            }
        });

        imagesSetArray = getResources().getStringArray(R.array.images_set);
        imagesSetAdapter = new ImagesSetSpinnerAdapter(getContext(), imagesSetArray);
        imagesSetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        imagesSetSpinner = mainView.findViewById(R.id.spinner_images_set);
        imagesSetSpinner.setAdapter(imagesSetAdapter);
        imagesSetSpinner.setOnItemSelectedListener(imagesSetItemSelectedListener);
        imagesSetSpinner.setSelection(getArguments().getInt(Constants.PREFS_IMAGES_SET));

        fieldCountSpinner = mainView.findViewById(R.id.spinner_field_count);
        fieldCountSpinner.setOnItemSelectedListener(fieldCountItemSelectedListener);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        listener = (MainMenuListener) context;
    }

    @Override
    public void onDetach(){
        super.onDetach();
        listener = null;
    }




    AdapterView.OnItemSelectedListener imagesSetItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {

            listener.onImagesSetSelected(pos);

            fieldCountSpinner.setAdapter(
                    Switcher.getAdapter(
                            getContext(), pos));
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    };

    AdapterView.OnItemSelectedListener fieldCountItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {

            listener.onFieldCountSelected(Integer.parseInt(adapterView.getSelectedItem().toString()),
                    pos);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    };

    public interface MainMenuListener{
        void onNewGamePressed();
        void onImagesSetSelected(int pos);
        void onFieldCountSelected(int fieldCount, int pos);
    }
}
