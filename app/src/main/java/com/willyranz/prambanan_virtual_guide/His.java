package com.willyranz.prambanan_virtual_guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer V5-132 on 3/21/2016.
 */
public class His extends AppCompatActivity {
    private Pager_adapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.animator.antislide_up, R.animator.antislide_down);
        setContentView(R.layout.pager_his);
        initializePaging();
    }

    private void initializePaging()
    {
        List<Fragment> fragments = getFragments();
        mPagerAdapter = new Pager_adapter(this.getSupportFragmentManager(), fragments);
        ViewPager pager = (ViewPager) findViewById(R.id.viewmember);
        pager.setAdapter(mPagerAdapter);
    }

    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(Fragment.instantiate(this, His_1_1.class.getName()));
        fList.add(Fragment.instantiate(this, His_1_2.class.getName()));
        fList.add(Fragment.instantiate(this, His_1_3.class.getName()));
        fList.add(Fragment.instantiate(this, His_1_4.class.getName()));
        return fList;
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
            Intent i = new Intent(getApplicationContext(),MainMenu.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
