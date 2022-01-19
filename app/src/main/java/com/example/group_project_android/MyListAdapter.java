package com.example.group_project_android;


import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> maintitle;
    private final ArrayList<String> imageName;
    private final ArrayList<Float> price;

    public MyListAdapter(Activity context, ArrayList<String> maintitle,ArrayList<String> imageName, ArrayList<Float> price) {
        super(context, R.layout.mylist, maintitle);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.maintitle=maintitle;
        this.imageName=imageName;
        this.price=price;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);

        titleText.setText(maintitle.get(position));
        //imageView.setBackgroundResource(R.color.white);
        Glide.with(context).load(imageName.get(position)).centerCrop().into(imageView);
        subtitleText.setText("$"+price.get(position).toString()+"/ person");

        return rowView;

    }
}
