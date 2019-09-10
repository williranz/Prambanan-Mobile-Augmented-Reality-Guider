package com.willyranz.prambanan_virtual_guide;

import android.os.Bundle;

/**
 * Created by Acer V5-132 on 4/5/2016.
 */
public class SampleCamContentFromNativeActivity extends SampleCamActivityGeo {

    @Override
    protected void onPostCreate( final Bundle savedInstanceState ) {
        super.onPostCreate( savedInstanceState );
        this.injectData();
    }
}
