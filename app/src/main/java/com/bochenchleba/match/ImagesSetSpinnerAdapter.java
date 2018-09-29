package com.bochenchleba.match;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bochenchleba.match.workers.Switcher;

/**
 * Created by bochenchleba on 16/10/17.
 */

public class ImagesSetSpinnerAdapter extends ArrayAdapter<String> {

    private Context ctx;
    private String[] contentArray;

    public ImagesSetSpinnerAdapter(Context context, String[] objects) {
        super(context,  R.layout.spinner_images_set_element, R.id.spinner_tv, objects);
        this.ctx = context;
        this.contentArray = objects;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_images_set_element, parent, false);

        TextView textView = row.findViewById(R.id.spinner_tv);
        textView.setText(contentArray[position]);

        ImageView imageView = row.findViewById(R.id.spinner_iv);
        Switcher.setImgInSpinnerItem(position, imageView);

        return row;
    }

}