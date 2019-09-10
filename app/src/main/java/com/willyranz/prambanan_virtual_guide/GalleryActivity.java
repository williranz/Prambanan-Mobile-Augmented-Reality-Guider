package com.willyranz.prambanan_virtual_guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class GalleryActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        overridePendingTransition(R.animator.slide_up, R.animator.slide_down);
        setContentView(R.layout.activity_gallery);

       // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);

            ImageView i = (ImageView)rootView.findViewById(R.id.img1);
            ImageView ii = (ImageView)rootView.findViewById(R.id.img2);
            ImageView iii = (ImageView)rootView.findViewById(R.id.img3);
            ImageView iv = (ImageView)rootView.findViewById(R.id.img4);

            if(getArguments().getInt(ARG_SECTION_NUMBER)==1)
            {
                i.setImageResource(R.drawable.g1);
                ii.setImageResource(R.drawable.g2);
                iii.setImageResource(R.drawable.g3);
                iv.setImageResource(R.drawable.g4);
                textView.setText("Scannable target objects in Shiva Temple");

                i.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "gajah");
                        startActivity(i);
                    }
                });

                ii.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa","singa");
                        startActivity(i);
                    }
                });

                iii.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa","rusa");
                        startActivity(i);
                    }
                });

                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa","singajaga");
                        startActivity(i);
                    }
                });
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==2)
            {
                i.setImageResource(R.drawable.g5);
                ii.setImageResource(R.drawable.g6);
                iii.setImageResource(R.drawable.g8);
                iv.setImageResource(R.drawable.g9);
                textView.setText("Scannable target objects in Brahma Temple");

                i.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "dewadalam");
                        startActivity(i);
                    }
                });

                ii.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "dewatua");
                        startActivity(i);
                    }
                });

                iii.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "merak");
                        startActivity(i);
                    }
                });

                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "dewamuda");
                        startActivity(i);
                    }
                });
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==3)
            {

                i.setImageResource(R.drawable.g10);
                ii.setImageResource(R.drawable.g11);
                iii.setImageResource(R.drawable.g12);
                iv.setImageResource(R.drawable.g13);
                textView.setText("Scannable target objects in Vishnu Temple");

                i.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "alurdewa");
                        startActivity(i);
                    }
                });

                ii.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "duaorg");
                        startActivity(i);
                    }
                });

                iii.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "anakdewa");
                        startActivity(i);
                    }
                });

                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "pasangan");
                        startActivity(i);
                    }
                });
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==4)
            {
                i.setImageResource(R.drawable.g14);
                ii.setImageResource(R.drawable.g15);
                iii.setImageResource(R.drawable.g16);
                iv.setImageResource(R.drawable.g17);
                textView.setText("Scannable target objects in Nandi Temple");

                i.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "monyet");
                        startActivity(i);
                    }
                });

                ii.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "burunganeh");
                        startActivity(i);
                    }
                });

                iii.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "bangau");
                        startActivity(i);
                    }
                });

                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "kelinci");
                        startActivity(i);
                    }
                });
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==5)
            {
                i.setImageResource(R.drawable.g18);
                ii.setImageResource(R.drawable.g19);
                iii.setImageResource(R.drawable.g20);
                iv.setImageResource(R.drawable.g21);
                textView.setText("Scannable target objects in Garuda Temple");
                i.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "sumo");
                        startActivity(i);
                    }
                });

                ii.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "entelop");
                        startActivity(i);
                    }
                });

                iii.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "macan");
                        startActivity(i);
                    }
                });

                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "potbunga");
                        startActivity(i);
                    }
                });
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==6)
            {
                i.setImageResource(R.drawable.g22);
                ii.setImageResource(R.drawable.g23);
                iii.setImageResource(R.drawable.g24);
                iv.setImageResource(R.drawable.g25);
                textView.setText("Scannable target objects in Angsa Temple");

                i.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "dewatidur");
                        startActivity(i);
                    }
                });

                ii.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "suamiistri");
                        startActivity(i);
                    }
                });

                iii.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "ceritamonyet");
                        startActivity(i);
                    }
                });

                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "bersaudara");
                        startActivity(i);
                    }
                });
            }

            else
            {
                i.setImageResource(R.drawable.g7);
                textView.setText("Scannable target object in Prambanan outdoor lobby");

                i.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), WebviewActivity.class);
                        i.putExtra("bawa", "papanresmi");
                        startActivity(i);
                    }
                });

            }

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 7 total pages.
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Shiva Temple";
                case 1:
                    return "Brahma Temple";
                case 2:
                    return "Vishnu Temple";
                case 3:
                    return "Nandi Temple";
                case 4:
                    return "Garuda Temple";
                case 5:
                    return "Angsa Temple";
                case 6:
                    return "Outdoor Lobby";
            }
            return null;
        }
    }

    public void onBackPressed()
    {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}
