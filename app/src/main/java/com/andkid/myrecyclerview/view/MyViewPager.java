package com.andkid.myrecyclerview.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by AndKid on 2017/3/1 0001.
 */

public class MyViewPager extends ViewPager {
    public MyViewPager(Context context) {
        super(context);
        init();
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    void init() {
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("cyg", "MyViewPager onTouch: " + event.getAction());
                return false;
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("cyg", "MyViewPager dispatchTouchEvent: " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        Log.d("cyg", "MyViewPager onTouchEvent: " + e.getAction());
        return super.onTouchEvent(e);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        Log.d("cyg", "MyViewPager onInterceptTouchEvent: " + e.getAction());
        return super.onInterceptTouchEvent(e);
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        boolean canScroll = super.canScroll(v, checkV, dx, x, y);
        if (v instanceof MyRecyclerView) {
            Log.d("cyg", "MyViewPager-MyRecyclerView canScroll: " + canScroll);
        }
        return canScroll;
    }
}
