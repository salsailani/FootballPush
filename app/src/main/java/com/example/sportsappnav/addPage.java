package com.example.sportsappnav;
import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        Button push = (Button) findViewById(R.id.buttonPush);


        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("pushed");
                // Build an AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(addPage.this);

                // String array for alert dialog multi choice items
                String[] emails = new String[]{
                        "email1",
                        "email2",
                        "email3"
                };

                // Boolean array for initial selected items
                final boolean[] checkedEmails = new boolean[]{
                        true, // email1
                        false, // email2
                        false
                };



                // Convert the email array to list
                final List<String> emailsList = Arrays.asList(emails);

                builder.setMultiChoiceItems(emails, checkedEmails, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        // Update the current focused item's checked status
                        checkedEmails[which] = isChecked;
                        // Get the current focused item
                        String currentItem = emailsList.get(which);
                        // Notify the current action
                        Toast.makeText(getApplicationContext(),
                                currentItem, Toast.LENGTH_SHORT).show();
                    }
                });

                // Specify the dialog is not cancelable
                builder.setCancelable(false);
                // Set a title for alert dialog
                builder.setTitle("Please choose an email");

                // Set the positive/yes button click listener
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when click positive button
//                        tv.setText("Your preferred colors..... \n");
                        for (int i = 0; i<checkedEmails.length; i++){
                            boolean checked = checkedEmails[i];
                            if (checked) {
//                                tv.setText(tv.getText() + colorsList.get(i) + "\n");
                                System.out.println("success");
                                new MyTask().execute();
                            }
                        }
                    }
                });

                // Set the neutral/cancel button click listener
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when click the neutral button
                    }
                });

                AlertDialog dialog = builder.create();
                // Display the alert dialog on interface
                dialog.show();
            }
        });
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

//            calendarPush(resultArray,timeStampArray,venueArray);
            return null;
        }


        protected void calendarPush(ArrayList<String> titleArray, ArrayList<Integer> timeArray, ArrayList<String> location) {

            String[] PERMISSIONS = {
                    Manifest.permission.READ_CALENDAR,
                    Manifest.permission.WRITE_CALENDAR,
            };

            if (ActivityCompat.checkSelfPermission(addPage.this, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(addPage.this, PERMISSIONS, 1);}

            if (ActivityCompat.checkSelfPermission(addPage.this, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(addPage.this, PERMISSIONS, 1);}

            if (ActivityCompat.checkSelfPermission(addPage.this, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(addPage.this, PERMISSIONS, 1);}


                ContentResolver cr = getContentResolver();
                ContentValues[] eventsArray = new ContentValues[titleArray.size()];

            // Projection array. Creating indices for this array instead of doing
            // dynamic lookups improves performance.
             final String[] EVENT_PROJECTION = new String[] {
                    CalendarContract.Calendars._ID,                           // 0
                    CalendarContract.Calendars.ACCOUNT_NAME,                  // 1
                    CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,         // 2
                    CalendarContract.Calendars.OWNER_ACCOUNT,                  // 3
                     CalendarContract.Calendars.IS_PRIMARY                     // 4

             };

            // The indices for the projection array above.
            final int PROJECTION_ID_INDEX = 0;
            final int PROJECTION_ACCOUNT_NAME_INDEX = 1;
            final int PROJECTION_DISPLAY_NAME_INDEX = 2;
            final int PROJECTION_OWNER_ACCOUNT_INDEX = 3;
            final int PROJECTION_VISIBLE = 4;



            // Run query
            Cursor cur = null;
            Uri uri = CalendarContract.Calendars.CONTENT_URI;


            // Submit the query and get a Cursor object back.
            cur = cr.query(uri, EVENT_PROJECTION, null, null, null);


            ArrayList<Long> IDList = new ArrayList<Long>();
            ArrayList<String> displayNameList = new ArrayList<String>();

            // Use the cursor to step through the returned records
            while (cur.moveToNext()) {
                long calID = 0;
                String displayName = null;
                String accountName = null;
                String ownerName = null;
                int visible;


                // Get the field values
                calID = cur.getLong(PROJECTION_ID_INDEX);
                visible = cur.getInt(PROJECTION_VISIBLE);
                displayName = cur.getString(PROJECTION_DISPLAY_NAME_INDEX);

                if (visible == 1) {
                    IDList.add(calID);
                    displayNameList.add(displayName);
                }

                displayName = cur.getString(PROJECTION_DISPLAY_NAME_INDEX);
                accountName = cur.getString(PROJECTION_ACCOUNT_NAME_INDEX);
                ownerName = cur.getString(PROJECTION_OWNER_ACCOUNT_INDEX);
                visible = cur.getInt(PROJECTION_VISIBLE);



            }

                System.out.println(IDList);
                System.out.println(displayNameList);

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