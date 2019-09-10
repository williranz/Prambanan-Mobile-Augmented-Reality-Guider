package com.willyranz.prambanan_virtual_guide;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.wikitude.architect.ArchitectView;
import com.wikitude.architect.StartupConfiguration;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    ListView Listmenu;
    private SliderLayout mDemoSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.animator.antislide_in, R.animator.antislide_out);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setListenerListView();

        Lobject weather_data[] = new Lobject[]
        {
            new Lobject(R.drawable.a1_1, "Route to Prambanan"),
            new Lobject(R.drawable.a1_2, "Sketch of Prambanan"),
            new Lobject(R.drawable.a1_3, "Explore Prambanan Area"),
            new Lobject(R.drawable.a1_4, "Scan Temple Object"),
            new Lobject(R.drawable.a1_5, "Scanable Objects Gallery"),
            new Lobject(R.drawable.a1_6, "Prambanan Videos"),
            new Lobject(R.drawable.a1_8, "Panoramic 360"),
            new Lobject(R.drawable.a1_7, "About Application")
        };

        LobjectAdapter adapter = new LobjectAdapter(this,
                R.layout.listview_item_row, weather_data);

        Listmenu.setAdapter(adapter);

        mDemoSlider = (SliderLayout) findViewById(R.id.slider);

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("The aerial view of Prambanan", R.drawable.aerial_prambanan);
        file_maps.put("The entance view of Prambanan", R.drawable.candi_all);
        file_maps.put("Brahma Temple", R.drawable.candi_brahma);
        file_maps.put("Wisnu Temple", R.drawable.candi_wisnu);
        file_maps.put("Shiva Temple", R.drawable.candi_siwa);
        file_maps.put("The relief of Kalpataru", R.drawable.relief_kalpataru);
        file_maps.put("The relief of Rama", R.drawable.relief_brahma);
        file_maps.put("The relief of Ravana", R.drawable.relief_siwa);
        file_maps.put("The relief of Devata and Apsaras", R.drawable.devata_relief);
        file_maps.put("The relief of Sitted Deities", R.drawable.deities_prambanan);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.CubeIn);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Left_Bottom);
        mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
        mDemoSlider.setCustomAnimation(new ChildAnimationExample());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here
                mDemoSlider.stopAutoCycle();
                Intent i = new Intent(v.getContext(), MainMenu.class);
                startActivity(i);
            }
        });
    }

    private void setListenerListView()
    {
        final MediaPlayer soundwarning = MediaPlayer.create(this, R.raw.warning);

        Listmenu = (ListView) findViewById(R.id.list_menu);
        Listmenu.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                if (position == 0)
                {
                    ConnectivityManager connec = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

                    if (connec != null && ((connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) || (connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED)))
                    {
                        Intent i = new Intent(v.getContext(), MapsFragment.class);
                        startActivity(i);
                    }
                    else if (connec != null && ((connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.DISCONNECTED) || (connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.DISCONNECTED )))
                    {
                        soundwarning.start();
                        Toast.makeText(getApplicationContext(), "You must be connected to the internet!", Toast.LENGTH_SHORT).show();
                    }
                }

                else if (position == 1)
                {
                    Intent i = new Intent(v.getContext(), DenahActivity.class);
                    startActivity(i);
                }

                else if (position == 2)
                {
                    if((ArchitectView.getSupportedFeaturesForDevice(getApplicationContext()) & StartupConfiguration.Features.Geo) != 0)
                    {
                        Intent i = new Intent(v.getContext(), SampleCamActivityGeo.class);
                        startActivity(i);
                    }
                    else
                    {
                        soundwarning.start();
                        Toast.makeText(MainActivity.this, "Your device doesnot have Compass sensor!", Toast.LENGTH_SHORT).show();
                    }

                }

                else if (position == 3)
                {

                    if((ArchitectView.getSupportedFeaturesForDevice(getApplicationContext()) & StartupConfiguration.Features.Tracking2D) != 0)
                    {
                        Intent i = new Intent(v.getContext(), SampleCamActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        soundwarning.start();
                        Toast.makeText(MainActivity.this, "Your device camera doesnot support hdpi capturing!", Toast.LENGTH_SHORT).show();
                    }
                }

                else if (position == 4)
                {
                    Intent i = new Intent(v.getContext(), GalleryActivity.class);
                    startActivity(i);
                }

                else if (position == 5)
                {
                    Intent i = new Intent(v.getContext(), VideoActivity.class);
                    startActivity(i);
                }

                else if (position == 6)
                {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://googledrive.com/host/0BxQMyJVlV8MWRFdqblJhSTZIVGc/panorama.html"));
                    startActivity(browserIntent);
                }

                else
                {
                    Intent i = new Intent(v.getContext(), AboutActivity.class);
                    startActivity(i);
                }
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem m = menu.findItem(R.id.back);
        m.setVisible(false);
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
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop()
    {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}

    public void onBackPressed()
    {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
}
