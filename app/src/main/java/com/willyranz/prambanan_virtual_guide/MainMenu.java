package com.willyranz.prambanan_virtual_guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Acer V5-132 on 3/5/2016.
 */
public class MainMenu extends AppCompatActivity
{
    ListView Listabout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.animator.slide_in, R.animator.slide_out);
        setContentView(R.layout.main_menu);
        setListenerListView();

        Lobject weather_data[] = new Lobject[]
        {
                new Lobject(R.drawable.a2_1, "General Information"),
                new Lobject(R.drawable.a2_2, "History"),
                new Lobject(R.drawable.a2_3, "The Temple Compound"),
                new Lobject(R.drawable.a2_4, "Architecture"),
                new Lobject(R.drawable.a2_5, "Reliefs")
        };

        LobjectAdapter adapter = new LobjectAdapter(this,
                R.layout.listview_item_row, weather_data);

        Listabout.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(MainMenu.this, MainActivity.class));
            }
        });

    }

    private void setListenerListView()
    {
        Listabout = (ListView) findViewById(R.id.list_about);
        Listabout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(v.getContext(), GD.class);
                    startActivity(i);
                } else if (position == 1) {
                    Intent i = new Intent(v.getContext(), His.class);
                    startActivity(i);
                } else if (position == 2) {
                    Intent i = new Intent(v.getContext(), Tem.class);
                    startActivity(i);
                } else if (position == 3) {
                    Intent i = new Intent(v.getContext(), Arc.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(v.getContext(), Rel.class);
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
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed()
    {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}
