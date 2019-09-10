package com.willyranz.prambanan_virtual_guide;

import android.content.Intent;
import android.media.MediaPlayer;

import com.wikitude.architect.StartupConfiguration;

import java.io.File;

/**
 * Created by Acer V5-132 on 4/5/2016.
 */
public class SampleCamActivity extends AbstractArchitectCamActivity
{
    @Override
    public String getARchitectWorldPath()
    {
        final MediaPlayer prev = MediaPlayer.create(this, R.raw.enterscan);
        prev.start();
        return "samples" + File.separator + "object_scan" + File.separator + "index.html";
    }

    @Override
    public String getActivityTitle()
    {
        return "Scan Temple Objects";
    }

    @Override
    public int getContentViewId()
    {
        return R.layout.sample_cam;
    }

    @Override
    public int getArchitectViewId()
    {
        return R.id.architectView;
    }


    @Override
    public String getWikitudeSDKLicenseKey() {
        return WikitudeSDKConstants.WIKITUDE_SDK_KEY;
    }

    @Override
    protected StartupConfiguration.CameraPosition getCameraPosition()
    {
        return StartupConfiguration.CameraPosition.DEFAULT;
    }

    public void onBackPressed()
    {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onStop()
    {
        super.onStop();
    }
}
