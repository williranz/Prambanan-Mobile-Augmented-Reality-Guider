package com.willyranz.prambanan_virtual_guide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


/**
 * Created by Acer V5-132 on 3/13/2016.
 */
public class Pager_adapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public Pager_adapter(FragmentManager fm, List<Fragment> fragments)
    {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public int getCount()
    {
        return this.fragments.size();
    }

    @Override
    public Fragment getItem(int position)

    {
        return this.fragments.get(position);
    }

}

