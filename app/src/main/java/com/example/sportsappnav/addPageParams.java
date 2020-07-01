package com.example.sportsappnav;
import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.util.*;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



      class addPageParams{
        Context  ctx;
        int teamID;
        TextView data;
        addPageParams(Context ctx, int teamID, TextView data){
            this.ctx = ctx;
            this.teamID = teamID;
            this.data = data;
        }
    }

     class addPage extends AsyncTask<addPageParams, Void, String> {


        String result;
        String venue;
        Response response;
        ArrayList<String> resultArray = new ArrayList<String>();
        int timeStamp;
        ArrayList<Integer> timeStampArray = new ArrayList<Integer>();
        ArrayList<String> venueArray = new ArrayList<String>();
        TimeZone timezoneDefault = TimeZone.getDefault();
        String timezone =  timezoneDefault.getID();
        TextView data;


        @Override
        protected String doInBackground(addPageParams... params) {

            // getting the next matches

            Context ctx = params[0].ctx;
            int teamID = params[0].teamID;
            data = params[0].data;
            System.out.println("test111111");
            System.out.println(teamID);
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

            //beginning of calendar pushing


            String[] PERMISSIONS = {
                    Manifest.permission.READ_CALENDAR,
                    Manifest.permission.WRITE_CALENDAR,
            };

            if (ActivityCompat.checkSelfPermission(ctx, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions((Activity) ctx, PERMISSIONS, 1);}

            if (ActivityCompat.checkSelfPermission(ctx, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions((Activity) ctx, PERMISSIONS, 1);}

            if (ActivityCompat.checkSelfPermission(ctx, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions((Activity) ctx, PERMISSIONS, 1);}


            ContentResolver cr = ctx.getContentResolver();
            ContentValues[] eventsArray = new ContentValues[resultArray.size()];

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

            for (int i = 0; i < resultArray.size(); i++) {
                String title = resultArray.get(i);
                int timeStamp2 = timeStampArray.get(i);
                String loc = venueArray.get(i);
                ContentValues values = new ContentValues();
                values.put(CalendarContract.Events.DTSTART,  (long) timeStamp2 *1000L);
                values.put(CalendarContract.Events.DTEND,  (long) (timeStamp2*1000L) +7200000L );
                values.put(CalendarContract.Events.EVENT_TIMEZONE, timezone);
                values.put(CalendarContract.Events.TITLE, title);
                values.put(CalendarContract.Events.DESCRIPTION, title);
                values.put(CalendarContract.Events.EVENT_LOCATION, loc);
                values.put(CalendarContract.Events.CALENDAR_ID, 1);
                eventsArray[i] = values;
            }
            cr.bulkInsert(CalendarContract.Events.CONTENT_URI, eventsArray);

            String result2 = "";
            for (String s : resultArray) {
                result2 +=s + "\n";
            }


            return result2;
        }





        @Override
        protected void onPostExecute(String result2) {
            //switching from response type to string


            System.out.println("this is onPostExecute");
            System.out.println(result2);
            data.setText(result2);


            super.onPostExecute(result2);
            System.out.println("////////");
            System.out.println(data);

        }


    }

