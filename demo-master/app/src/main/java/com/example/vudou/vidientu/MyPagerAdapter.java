package com.example.vudou.vidientu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by vudou on 7/26/2017.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> listFragment;

    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> listFragment) {
        super(fm);
        this.listFragment = listFragment;
    }

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }
}
