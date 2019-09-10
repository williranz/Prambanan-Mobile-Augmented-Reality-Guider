package com.willyranz.prambanan_virtual_guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Acer V5-132 on 4/9/2016.
 */
public class WebviewActivity extends AppCompatActivity {

    String indice = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.animator.slide_in, R.animator.slide_out);
        setContentView(R.layout.web_view);

        Bundle b = getIntent().getExtras();
        indice = b.getString("bawa");

        WebView web = (WebView)findViewById(R.id.webView);

        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);


        if(indice.equalsIgnoreCase("alurdewa"))
        {
            web.loadUrl("file:///android_asset/web/index.html");
        }

        else if(indice.equalsIgnoreCase("anakdewa"))
        {
            web.loadUrl("file:///android_asset/web/index1.html");
        }

        else if(indice.equalsIgnoreCase("bangau"))
        {
            web.loadUrl("file:///android_asset/web/index2.html");
        }

        else if(indice.equalsIgnoreCase("bersaudara"))
        {
            web.loadUrl("file:///android_asset/web/index3.html");
        }

        else if(indice.equalsIgnoreCase("burunganeh"))
        {
            web.loadUrl("file:///android_asset/web/index4.html");
        }

        else if(indice.equalsIgnoreCase("ceritamonyet"))
        {
            web.loadUrl("file:///android_asset/web/index5.html");
        }

        else if(indice.equalsIgnoreCase("dewadalam"))
        {
            web.loadUrl("file:///android_asset/web/index6.html");
        }

        else if(indice.equalsIgnoreCase( "dewamuda"))
        {
            web.loadUrl("file:///android_asset/web/index7.html");
        }

        else if(indice.equalsIgnoreCase( "dewatidur"))
        {
            web.loadUrl("file:///android_asset/web/index8.html");
        }

        else if(indice.equalsIgnoreCase("dewatua"))
        {
            web.loadUrl("file:///android_asset/web/index9.html");
        }

        else if(indice.equalsIgnoreCase("duaorg"))
        {
            web.loadUrl("file:///android_asset/web/index10.html");
        }

        else if(indice.equalsIgnoreCase( "entelop"))
        {
            web.loadUrl("file:///android_asset/web/index11.html");
        }

        else if(indice.equalsIgnoreCase("gajah"))
        {
            web.loadUrl("file:///android_asset/web/index12.html");
        }

        else if(indice.equalsIgnoreCase("sumo"))
        {
            web.loadUrl("file:///android_asset/web/index13.html");
        }

        else if(indice.equalsIgnoreCase("keinci"))
        {
            web.loadUrl("file:///android_asset/web/index14.html");
        }

        else if(indice.equalsIgnoreCase("macan"))
        {
            web.loadUrl("file:///android_asset/web/index15.html");
        }

        else if(indice.equalsIgnoreCase( "merak"))
        {
            web.loadUrl("file:///android_asset/web/index16.html");
        }

        else if(indice.equalsIgnoreCase( "monyet"))
        {
            web.loadUrl("file:///android_asset/web/index17.html");
        }

        else if(indice.equalsIgnoreCase( "papanresmi"))
        {
            web.loadUrl("file:///android_asset/web/index18.html");
        }

        else if(indice.equalsIgnoreCase("pasangan"))
        {
            web.loadUrl("file:///android_asset/web/index19.html");
        }

        else if(indice.equalsIgnoreCase("potbunga"))
        {
            web.loadUrl("file:///android_asset/web/index20.html");
        }

        else if(indice.equalsIgnoreCase( "rusa"))
        {
            web.loadUrl("file:///android_asset/web/index21.html");
        }

        else if(indice.equalsIgnoreCase("singa"))
        {
            web.loadUrl("file:///android_asset/web/index22.html");
        }

        else if(indice.equalsIgnoreCase( "singajaga"))
        {
            web.loadUrl("file:///android_asset/web/index23.html");
        }

        else if(indice.equalsIgnoreCase("suamiistri"))
        {
            web.loadUrl("file:///android_asset/web/index24.html");
        }


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
            Intent i = new Intent(getApplicationContext(),GalleryActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
