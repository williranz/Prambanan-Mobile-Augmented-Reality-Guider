package com.willyranz.prambanan_virtual_guide;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Acer V5-132 on 3/15/2016.
 */
public class MapsFragment extends AppCompatActivity {

    private GoogleMap map;
    private Location location;
    private LatLng startingpoint, destination;
    TextView textlat;
    TextView textlong;
    TextView textdistance;
    TextView textlokasi;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.animator.slide_up, R.animator.slide_down);
        setContentView(R.layout.maps_fragment);
        textlat = (TextView) findViewById(R.id.txtlat);
        textlong = (TextView) findViewById(R.id.txtlong);
        textdistance = (TextView) findViewById(R.id.txtdistance);
        textlokasi = (TextView) findViewById(R.id.txtlocation);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);

        final LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {

            }

            public void onProviderDisabled(String arg0) {
                // TODO Auto-generated method stub

            }

            public void onProviderEnabled(String arg0) {
                // TODO Auto-generated method stub

            }

            public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
                // TODO Auto-generated method stub

            }
        };

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);


        map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

        if (map != null) {
            // Enable MyLocation Button in the Map

            if (location != null) {
                map.setMyLocationEnabled(true);

                moveToMyLocation();

                startingpoint = new LatLng(location.getLatitude(), location.getLongitude());
                destination = new LatLng(-7.752021, 110.491467);


                map.addMarker(new MarkerOptions()
                        .position(startingpoint)
                        .title("Your Current Postition :)")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_person_marker)));


                map.addMarker(new MarkerOptions()
                        .position(destination)
                        .title("Prambanan")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker)));

                //get distance
                textlokasi.setText("Current Location");
                Location start = new Location("");
                start.setLatitude(startingpoint.latitude);
                start.setLongitude(startingpoint.longitude);
                Location end = new Location("");
                end.setLatitude(destination.latitude);
                end.setLongitude(destination.longitude);
                textlat.setText("Latitude : " + startingpoint.latitude);
                textlong.setText("Longitude : " + startingpoint.longitude);
                textdistance.setText("Distance to Prambanan : " + start.distanceTo(end)/1000 + " Km");

                // Getting URL to the Google Directions API
                String url = getDirectionsUrl(startingpoint, destination);
                DownloadTask downloadTask = new DownloadTask();
                // Start downloading json data from Google Directions API
                downloadTask.execute(url);


                // Setting onclick event listener for the map
                map.setOnMapClickListener(new OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng point) {
                    map.clear();
                    map.addMarker(new MarkerOptions()
                            .position(destination)
                            .title("Prambanan")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker)));


                    // Creating MarkerOptions
                    MarkerOptions options = new MarkerOptions();
                    // Setting the position of the marker
                    options.position(point);
                    //Setting icon for the marker
                    options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                    //Setting title for the marker
                    options.title("Starting Point");

                    // Add new marker to the Google Map Android API V2
                    map.addMarker(options);

                    // Checks, whether start and end locations are captured
                    startingpoint = point;

                    //get distance
                    textlokasi.setText("Selected Location");
                    Location start = new Location("");
                    start.setLatitude(startingpoint.latitude);
                    start.setLongitude(startingpoint.longitude);
                    Location end = new Location("");
                    end.setLatitude(destination.latitude);
                    end.setLongitude(destination.longitude);
                    textlat.setText("Latitude : " + startingpoint.latitude);
                    textlong.setText("Longitude : " + startingpoint.longitude);
                    textdistance.setText("Distance to Prambanan : " + start.distanceTo(end)/1000 + " Km");

                    // Getting URL to the Google Directions API
                    String url = getDirectionsUrl(startingpoint, destination);
                    DownloadTask downloadTask = new DownloadTask();
                    // Start downloading json data from Google Directions API
                    downloadTask.execute(url);

                    }

                });
            }
            else
            {
                Toast.makeText(MapsFragment.this, "Wait GPS retrieving your device location!", Toast.LENGTH_SHORT).show();

            }
        }
        else
        {
            Toast.makeText(MapsFragment.this, "Map is not loaded!", Toast.LENGTH_SHORT).show();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetMap();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private String getDirectionsUrl(LatLng origin, LatLng dest) {

        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;

        return url;
    }

    /**
     * A method to download json data from url
     */
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception while downloading url", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MapsFragment Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.willyranz.prambanan_virtual_guide/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
            Action.TYPE_VIEW, // TODO: choose an action type.
            "MapsFragment Page", // TODO: Define a title for the content shown.
            // TODO: If you have web page content that matches this app activity's content,
            // make sure this auto-generated web page URL is correct.
            // Otherwise, set the URL to null.
            Uri.parse("http://host/path"),
            // TODO: Make sure this auto-generated app deep link URI is correct.
            Uri.parse("android-app://com.willyranz.prambanan_virtual_guide/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of doInBackground()
        @Override
        protected void onPostExecute(String result)
        {
            if(result != null)
            {
                super.onPostExecute(result);
                ParserTask parserTask = new ParserTask();
                // Invokes the thread for parsing the JSON data
                parserTask.execute(result);
            }
            else
            {
                Toast.makeText(MapsFragment.this, "Internet connection needed!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * A class to parse the Google Places in JSON format
     */
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>>
    {
        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData)
        {
            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;

            if(result != null) {

                // Traversing through all the routes
                for (int i = 0; i < result.size(); i++) {
                    points = new ArrayList<LatLng>();
                    lineOptions = new PolylineOptions();

                    // Fetching i-th route
                    List<HashMap<String, String>> path = result.get(i);

                    // Fetching all the points in i-th route
                    for (int j = 0; j < path.size(); j++) {
                        HashMap<String, String> point = path.get(j);

                        double lat = Double.parseDouble(point.get("lat"));
                        double lng = Double.parseDouble(point.get("lng"));
                        LatLng position = new LatLng(lat, lng);

                        points.add(position);
                    }

                    // Adding all the points in the route to LineOptions
                    lineOptions.addAll(points);
                    lineOptions.width(5);
                    lineOptions.color(Color.RED);
                }

                if (lineOptions == null) {
                    Toast.makeText(MapsFragment.this, "Cant draw location... Please click appropriate location on the map!", Toast.LENGTH_SHORT).show();
                } else {
                    // Drawing polyline in the Google Map for the i-th route
                    map.addPolyline(lineOptions);
                }
            }
            else
            {
                Toast.makeText(MapsFragment.this, "Internet connection needed!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void moveToMyLocation()
    {
        if (location != null)
        {
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 13));
        }
    }

    private void ResetMap()
    {
        map.clear();

        map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        if (map != null)
        {
            if(location!=null) {
                // Enable MyLocation Button in the Map
                map.setMyLocationEnabled(true);
                moveToMyLocation();
                startingpoint = new LatLng(location.getLatitude(), location.getLongitude());
                destination = new LatLng(-7.752021, 110.491467);

                map.addMarker(new MarkerOptions()
                        .position(startingpoint)
                        .title("Your Current Postition :)")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_person_marker)));

                map.addMarker(new MarkerOptions()
                        .position(destination)
                        .title("Prambanan")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker)));

                //get distance
                textlokasi.setText("Current Location");
                Location start = new Location("");
                start.setLatitude(startingpoint.latitude);
                start.setLongitude(startingpoint.longitude);
                Location end = new Location("");
                end.setLatitude(destination.latitude);
                end.setLongitude(destination.longitude);
                textlat.setText("Latitude : " + startingpoint.latitude);
                textlong.setText("Longitude : " + startingpoint.longitude);
                textdistance.setText("Distance to Prambanan : " + start.distanceTo(end)/1000 + " Km");

                // Getting URL to the Google Directions API
                String url = getDirectionsUrl(startingpoint, destination);
                DownloadTask downloadTask = new DownloadTask();
                // Start downloading json data from Google Directions API
                downloadTask.execute(url);
            }
            else
            {
                Toast.makeText(MapsFragment.this, "Wait GPS retrieving your device location!", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(MapsFragment.this, "Map is not loaded!", Toast.LENGTH_SHORT).show();
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
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
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
