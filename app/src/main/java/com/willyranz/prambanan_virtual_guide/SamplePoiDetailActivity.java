package com.willyranz.prambanan_virtual_guide;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Acer V5-132 on 4/5/2016.
 */
public class SamplePoiDetailActivity extends Activity {

    public static final String EXTRAS_KEY_POI_ID = "id";
    public static final String EXTRAS_KEY_POI_TITILE = "title";
    public static final String EXTRAS_KEY_POI_DESCR = "description";
    String ID = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.sample_poidetail);
        ID = getIntent().getExtras().getString(EXTRAS_KEY_POI_ID);
        ImageView i = (ImageView)findViewById(R.id.imagepoi);

        ((TextView)findViewById(R.id.poi_id)).setText(  getIntent().getExtras().getString(EXTRAS_KEY_POI_ID) );
        ((TextView)findViewById(R.id.poi_title)).setText( getIntent().getExtras().getString(EXTRAS_KEY_POI_TITILE) );
        ((TextView)findViewById(R.id.poi_description)).setText(  getIntent().getExtras().getString(EXTRAS_KEY_POI_DESCR) );


        switch (ID) {
            case "1":
                i.setImageResource(R.drawable.international_entrance);
                break;
            case "2":
                i.setImageResource(R.drawable.entrance_gate);
                break;
            case "3":
                i.setImageResource(R.drawable.entrance_temple);
                break;
            case "4":
                i.setImageResource(R.drawable.exit_temple);
                break;
            case "5":
                i.setImageResource(R.drawable.exit_gate);
                break;
            case "6":
                i.setImageResource(R.drawable.pervara);
                break;
            case "7":
                i.setImageResource(R.drawable.patok);
                break;
            case "8":
                i.setImageResource(R.drawable.patok);
                break;
            case "9":
                i.setImageResource(R.drawable.patok);
                break;
            case "10":
                i.setImageResource(R.drawable.patok);
                break;
            case "11":
                i.setImageResource(R.drawable.kelir);
                break;
            case "12":
                i.setImageResource(R.drawable.kelir);
                break;
            case "13":
                i.setImageResource(R.drawable.kelir);
                break;
            case "14":
                i.setImageResource(R.drawable.kelir);
                break;
            case "15":
                i.setImageResource(R.drawable.apit);
                break;
            case "16":
                i.setImageResource(R.drawable.apit);
                break;
            case "17":
                i.setImageResource(R.drawable.angsa);
                break;
            case "18":
                i.setImageResource(R.drawable.garuda);
                break;
            case "19":
                i.setImageResource(R.drawable.nandi);
                break;
            case "20":
                i.setImageResource(R.drawable.vishnu);
                break;
            case "21":
                i.setImageResource(R.drawable.brahma);
                break;
            case "22":
                i.setImageResource(R.drawable.shiva);
        }
    }
}
