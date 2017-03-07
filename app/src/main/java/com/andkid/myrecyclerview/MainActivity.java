package com.andkid.myrecyclerview;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.andkid.myrecyclerview.adapter.MyViewPagerAdapter;
import com.andkid.myrecyclerview.view.MyViewPager;

public class MainActivity extends FragmentActivity {
    // When requested, this adapter returns a GirlsFragment,
    // representing an object in the collection.
    MyViewPagerAdapter mDemoCollectionPagerAdapter;
    MyViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
        mDemoCollectionPagerAdapter =
                new MyViewPagerAdapter(
                        getSupportFragmentManager());
        mViewPager = (MyViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mDemoCollectionPagerAdapter);
    }
}

