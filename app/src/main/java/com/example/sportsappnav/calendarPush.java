package com.example.sportsappnav;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;
import java.util.TimeZone;

public class calendarPush {
    public void push (Context ctx, ArrayList<String> resultArray, ArrayList<Integer> timeStampArray, ArrayList<String> venueArray) {

        TimeZone timezoneDefault = TimeZone.getDefault();
        String timezone =  timezoneDefault.getID();
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

    }

}
