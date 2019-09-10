package com.willyranz.prambanan_virtual_guide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by Acer V5-132 on 6/6/2016.
 */
public class PlayVideo3 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.animator.slide_in, R.animator.slide_out);
        setContentView(R.layout.play_video1);

        LinearLayout ticker_area = (LinearLayout) findViewById(R.id.ticker_area1);
        setticker(ticker_area, "App demontration video", this);

        getWindow().setFormat(PixelFormat.UNKNOWN);

        final VideoView mVideoView3 = (VideoView)findViewById(R.id.videoView1);

        String uriPath3 = "android.resource://com.willyranz.prambanan_virtual_guide/"+R.raw.demoapp;
        Uri uri3 = Uri.parse(uriPath3);
        mVideoView3.setVideoURI(uri3);
        mVideoView3.requestFocus();

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(mVideoView3);
        mVideoView3.setMediaController(mediaController);

        mVideoView3.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i("com.willyranz.prambanan_virtual_guide", "Duration = " + mVideoView3.getDuration());
            }
        });
        mVideoView3.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory(Intent.CATEGORY_HOME);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        }
        else
        {
            Intent i = new Intent(getApplicationContext(),VideoActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public  void setticker(LinearLayout parent_layout, String text, Context contx) {
        if (text != "") {
            TextView view = new TextView(contx);
            view.setText(text);
            view.setTextColor(Color.BLUE);
            view.setTextSize(27.0F);
            Context context = view.getContext();
            // gets the context of the view
            // measures the unconstrained size of the view
            // before it is drawn in the layout
            view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);

            // takes the unconstrained width of the view
            float width = view.getMeasuredWidth();

            float height = view.getMeasuredHeight();

            // gets the screen width
            float screenWidth = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth();

            view.setLayoutParams(new LinearLayout.LayoutParams((int) width, (int) height, 1f));
            System.out.println("width and screenwidth are" + width + "/" + screenWidth + "///" + view.getMeasuredWidth());
            // performs the calculation
            float toXDelta = width - (screenWidth - 0);

            // sets toXDelta to -300 if the text width is smaller that the
            // screen size
            if (toXDelta < 0) {
                toXDelta = 0 - screenWidth;// -300;
            } else {
                toXDelta = 0 - screenWidth - toXDelta;// -300 - toXDelta;
            }
            // Animation parameters
            Animation mAnimation = new TranslateAnimation(screenWidth, toXDelta, 0, 0);
            mAnimation.setDuration(15000);
            mAnimation.setRepeatMode(Animation.RESTART);
            mAnimation.setRepeatCount(Animation.INFINITE);
            view.setAnimation(mAnimation);
            parent_layout.addView(view);
        }
    }
}
