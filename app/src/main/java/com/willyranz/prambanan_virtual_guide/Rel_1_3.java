package com.willyranz.prambanan_virtual_guide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Acer V5-132 on 3/12/2016.
 */
public class Rel_1_3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if(container==null)
        {
            return null;
        }
        return inflater.inflate(R.layout.rel_1_3, container, false);

    }

}