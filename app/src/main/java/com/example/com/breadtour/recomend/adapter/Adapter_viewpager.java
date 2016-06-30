package com.example.com.breadtour.recomend.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class Adapter_viewpager extends PagerAdapter {

    private ArrayList<ImageView> viewlist;
    private Context context;

    public Adapter_viewpager(ArrayList<ImageView> viewlist, Context context) {
        this.viewlist = viewlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position %= viewlist.size();
        ImageView view = viewlist.get(position);
        view.setTag(position);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "5555" + v.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
        if (position < 0) {
            position = viewlist.size() + position;
        }
        ViewParent vp = view.getParent();
        if (vp != null) {
            ViewGroup parent = (ViewGroup) vp;
            parent.removeView(view);
        }
        container.addView(view);
        //add listeners here if necessary
        return view;
    }
}
