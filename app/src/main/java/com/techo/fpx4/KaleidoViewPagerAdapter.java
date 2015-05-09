package com.techo.fpx4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class KaleidoViewPagerAdapter extends FragmentStatePagerAdapter {

    private final int PAGES = 2;


    public KaleidoViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new KaleidoFrag1();
            case 1:
                return new KaleidoFrag2();
            //case 2:
            //return new TabFragment3();
            //case 3:
            //	return new TabFragment4();

            default:
                throw new IllegalArgumentException("The item position should be less or equal to:" + PAGES);
        }
    }

    @Override
    public int getCount() {
        return PAGES;
    }
}