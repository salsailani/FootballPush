package com.example.sportsappnav;
import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.util.*;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class addPage extends AppCompatActivity  {

    TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_page);

        TextView data = (TextView) findViewById(R.id.textView2);
        new MyTask().execute();

    }

    private class MyTask extends AsyncTask<Void, Void, Void> {
        String result;
        String venue;
        Response response;
        ArrayList<String> resultArray = new ArrayList<String>();
        int timeStamp;
        ArrayList<Integer> timeStampArray = new ArrayList<Integer>();
        ArrayList<String> venueArray = new ArrayList<String>();
        TimeZone timezoneDefault = TimeZone.getDefault();
        String timezone =  timezoneDefault.getID();
        final int callbackId = 42;
        public int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION =1;



        Intent intent = getIntent();
        int teamID = intent.getIntExtra("info", 0);

        @Override
        protected Void doInBackground(Void... voids) {
            OkHttpClient client = new OkHttpClient();
            String URL = "https://api-football-v1.p.rapidapi.com/v2/fixtures/team/" + teamID + "/next/100?timezone=" + timezone;
            Request request = new Request.Builder()
                    .url(URL)
                    .get()
                    .addHeader("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "9560035ce2msh757478739105ef3p16f2bdjsne73344650fc8")
                    .build();
            try {
                response = client.newCall(request).execute();
                String json = response.body().string();

                JSONObject obj = new JSONObject(json);
                JSONObject jsonData = obj.getJSONObject("api");
                JSONArray arr = jsonData.getJSONArray("fixtures");

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject homeTeamObj = arr.getJSONObject(i).getJSONObject("homeTeam");
                    String homeTeam = homeTeamObj.getString("team_name");
                    JSONObject awayTeamObj = arr.getJSONObject(i).getJSONObject("awayTeam");
                    String awayTeam = awayTeamObj.getString("team_name");
                    timeStamp = arr.getJSONObject(i).getInt("event_timestamp");
                    venue = arr.getJSONObject(i).getString("venue");
                    result = homeTeam + " vs " + awayTeam;

                    //Title
                    resultArray.add(result);
                    //TimeStamp
                    timeStampArray.add(timeStamp);
                    //venue
                    venueArray.add(venue);
                }



            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            calendarPush(resultArray,timeStampArray,venueArray);
            return null;
        }


        //, ArrayList<Integer> timeArray, ArrayList<String> location
        protected void calendarPush(ArrayList<String> titleArray, ArrayList<Integer> timeArray, ArrayList<String> location) {


            if (ActivityCompat.checkSelfPermission(addPage.this, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(addPage.this, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(addPage.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);}else if(ActivityCompat.checkSelfPermission(addPage.this, Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(addPage.this, Manifest.permission.WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED) {

                ContentResolver cr = getContentResolver();
                ContentValues[] eventsArray = new ContentValues[titleArray.size()];

                Uri uri = CalendarContract.Calendars.CONTENT_URI;
                String[] projection = new String[]{
                        CalendarContract.Calendars._ID,
                        CalendarContract.Calendars.ACCOUNT_NAME,
                        CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,
                        CalendarContract.Calendars.NAME,
                        CalendarContract.Calendars.CALENDAR_COLOR
                };

                Cursor cursor = cr.query(uri, projection, null, null, null);



                for (int i = 0; i < titleArray.size(); i++) {
                    String title = titleArray.get(i);
                    int timeStamp2 = timeArray.get(i);
                    String loc = location.get(i);
                    ContentValues values = new ContentValues();
                    values.put(CalendarContract.Events.DTSTART,  (long) timeStamp2 *1000L);
                    values.put(CalendarContract.Events.DTEND,  (long) (timeStamp2*1000L) +7200000L );
                    values.put(CalendarContract.Events.EVENT_TIMEZONE, timezone);
                    values.put(CalendarContract.Events.TITLE, title);
                    values.put(CalendarContract.Events.DESCRIPTION, title);
                    values.put(CalendarContract.Events.EVENT_LOCATION, loc);
                    values.put(CalendarContract.Events.CALENDAR_ID, 1);
                    if (ActivityCompat.checkSelfPermission(addPage.this, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    eventsArray[i] = values;
                }
                cr.bulkInsert(CalendarContract.Events.CONTENT_URI, eventsArray);
            }


        }



        @Override
        protected void onPostExecute(Void aVoid) {
            TextView data = (TextView) findViewById(R.id.textView2);

            //switching from response type to string
            String result2 = "";
            for (String s : resultArray) {
                result2 +=s + "\n";
            }

            data.setText(result2);
            super.onPostExecute(aVoid);
        }

    }

}
