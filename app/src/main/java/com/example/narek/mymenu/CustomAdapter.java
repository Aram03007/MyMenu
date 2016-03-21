package com.example.narek.mymenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Narek on 3/21/16.
 */
public class CustomAdapter extends ArrayAdapter<Data>  {
    private Activity context;
    private List<Data> datas;
    public CustomAdapter(Activity context, List<Data> datas) {
        super(context, R.layout.list_single, R.id.text, datas);
        this.context = context;
        this.datas = datas;
    }


    @Override
    public View getView(final int position, View view, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.text);
        CardView cardView = (CardView) rowView.findViewById(R.id.card_view);
        txtTitle.setTextColor(Color.BLACK);

        if (datas.get(position).isHidden()) {
            cardView.setVisibility(View.GONE);
        }
        if (datas.get(position).isColor()) {
            txtTitle.setTextColor(Color.GRAY);


        }


        CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.checkbox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (datas.get(position).isCheked()) {
                    datas.get(position).setCheked(false);

                } else {
                    datas.get(position).setCheked(true);

                }
            }
        });
            checkBox.setChecked(datas.get(position).isCheked());

            txtTitle.setText(datas.get(position).getTitle());





        return rowView;





    }





}
