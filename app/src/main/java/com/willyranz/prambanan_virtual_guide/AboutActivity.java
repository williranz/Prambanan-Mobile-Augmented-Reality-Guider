package com.willyranz.prambanan_virtual_guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Acer V5-132 on 3/9/2016.
 */
public class AboutActivity extends AppCompatActivity {
    TextView textViewone;
    TextView textViewtwo;
    TextView textViewthree;
    TextView textViewfour;
    TextView textViewfive;
    TextView textViewsix;
    TextView textViewseven;
    TextView textVieweight;
    TextView textViewnine;
    TextView textViewten;
    TextView textVieweleven;
    TextView textViewtwelve;
    TextView textViewthirdteen;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.animator.slide_up, R.animator.slide_down);
        setContentView(R.layout.layout_about);

        textViewone = (TextView) findViewById(R.id.textView1);
        textViewone.setText("Prambanan Mobile Guider is an handy solution apps for tourist visitting Prambanan. This app combines geolocation and Augmented Reality Technology for the best user experience. Explore Prambanan and learn it on your mobile phones. The application packs up many information and features exclusively for Prambanan Temple, The World's heritage site of Indonesia.");

        textViewtwo = (TextView) findViewById(R.id.textView2);
        textViewtwo.setText("While visitting Prambanan this Application has the following features to guide you from your mobile phone:");

        textViewthree = (TextView) findViewById(R.id.textView3);
        textViewthree.setText("1.Geolocation feature for accessing google maps to get your device location and route to Prambanan online.");

        textViewfour = (TextView) findViewById(R.id.textView4);
        textViewfour.setText("2.Show the Sketch of Prambanan temple, its compound, entrance way, and temples in the area.");

        textViewfive = (TextView) findViewById(R.id.textView5);
        textViewfive.setText("3.Geo Augmented Reality feature to show several point of interests around Prambanan. Only for device with Compass Sensor.");

        textViewsix = (TextView) findViewById(R.id.textView6);
        textViewsix.setText("4.Augmented reality camera scan feature for scanning several reliefs and objects in the Prambanan temple. Only for device minimum with hdpi <~240dpi> resolution camera.");

        textViewseven = (TextView) findViewById(R.id.textView7);
        textViewseven.setText("5.Additional menu for study about Prambanan, image gallery that shows all images which available for scanning via camera, some videos about Prambanan, and panorama 360 of Prambanan.");

        textVieweight = (TextView) findViewById(R.id.textView8);
        textVieweight.setText("Developer Info:");

        textViewnine = (TextView) findViewById(R.id.textView9);
        textViewnine.setText("WILLIAM CAHYADI");

        textViewten = (TextView) findViewById(R.id.textView10);
        textViewten.setText("Ask me anything at:");

        textVieweleven = (TextView) findViewById(R.id.textView11);
        textVieweleven.setText("williamcahyadi90@gmail.com");

        textViewtwelve = (TextView) findViewById(R.id.textView12);
        textViewtwelve.setText("Version:");

        textViewthirdteen = (TextView) findViewById(R.id.textView13);
        textViewthirdteen.setText("BETA 1.0");

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
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed()
    {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }

}

