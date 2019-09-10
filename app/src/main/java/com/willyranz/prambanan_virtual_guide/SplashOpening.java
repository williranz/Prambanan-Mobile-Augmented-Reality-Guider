package com.willyranz.prambanan_virtual_guide;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;


/**
 * Created by Acer V5-132 on 3/4/2016.
 */
public class SplashOpening extends Activity
{
    MediaPlayer mediaPlayer;
    protected boolean _active = true;
    protected int _splashTime = 6;
    private Thread splashTread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.animator.fadein, R.animator.fadeout);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_start);
        mediaPlayer = MediaPlayer.create(this, R.raw.opening1);
        StartService();
    }

    private void StartService()
    {
        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    mediaPlayer.start();
                    int waited = 0;
                    while (_active && (waited < _splashTime)) {
                        sleep(1000);
                        if (_active) {
                            waited += 1;
                        }
                    }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    finish();
                    Intent I = new Intent(SplashOpening.this,MainActivity.class);
                    startActivity(I);
                    finish();
                }
            }
        };
        splashTread.start();

    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            if (keyCode == KeyEvent.KEYCODE_HOME) {
                try
                {
                    splashTread.stop();
                }
                catch (Exception ed)
                {
                }
            }
        }
        if (keyCode == KeyEvent.KEYCODE_SEARCH)
        {
        }
        return false;
    }
}
