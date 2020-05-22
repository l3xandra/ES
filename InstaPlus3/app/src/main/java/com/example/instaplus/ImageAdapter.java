package com.example.instaplus;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.instaplus.R;

public class ImageAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private int[] mItems;
    View currentItem;
    Context c;
    int currentRes;

    public ImageAdapter(Context context) {
        c = context;
        mInflater = LayoutInflater.from(context);
        mItems = new int[]{

                R.drawable.rabbit,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.g,
                R.drawable.h,
                R.drawable.i,
                R.drawable.j,
                R.drawable.l,
                R.drawable.m,
                R.drawable.n,
                R.drawable.p,
                R.drawable.q,
                R.drawable.r,
                R.drawable.s,
                R.drawable.t,
                R.drawable.x,
                R.drawable.z,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit,
                R.drawable.rabbit
        };
    }

    @Override
    public int getCount() {
        return mItems.length;
    }

    @Override
    public Object getItem(int position) {
        return mItems[position];
    }

    @Override
    public long getItemId(int i) {
        return mItems[i];
    }


    public Object getItemAtPosition(int position) {
        return mItems[position];
    }

    @Override
    public View getView(int i, View view, final ViewGroup viewGroup) {
        View v = view;
        final ImageView picture;
        final int index = i;

        if (v == null) {
            v = mInflater.inflate(R.layout.galeria_image, viewGroup, false);
            v.setTag(R.id.galeriaImage, v.findViewById(R.id.galeriaImage));
        }


        picture = (ImageView) v.getTag(R.id.galeriaImage);

        final int item = (int)getItemId(i);



        //picture.setId(item);

        picture.setImageResource(item);

        picture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ((PostPublicationActivity)c).showImage(item);

            }
        });

        return v;
    }
}