package com.example.cvapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private List<Integer> mThumbIds;
    private Context mContext;

    public ImageAdapter(List<Integer> mThumbIds, Context mContext) {
        this.mThumbIds = mThumbIds;
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return mThumbIds.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = (ImageView) convertView;

        if(imageView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(250,250));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        imageView.setImageResource(mThumbIds.get(position));

        return imageView;
    }

        //This code has private variable which holds the context and a private list which stores the list of all the images IDs and a parameterize constructor and four methods.
        //
        //getCount() -  returns the number that how many time the adapter executes.
        //
        //getItemId() - returns the id of the item which is click on the gridview.
        //
        //getView() - here the actual view is specified i.e. in each grid item what is and how it to be shown, in this case a simple imageview is created.
}
