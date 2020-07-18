package com.example.sportsappnav;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class calendarPush {
    public void push (Context ctx, ArrayList<String> resultArray, ArrayList<Integer> timeStampArray, ArrayList<String> venueArray, int calID2) {

        TimeZone timezoneDefault = TimeZone.getDefault();
        String timezone = timezoneDefault.getID();

        ContentResolver cr = ctx.getContentResolver();


        for (int i = 0; i < resultArray.size(); i++) {
            String title = resultArray.get(i);
            int timeStamp2 = timeStampArray.get(i);

            long begin =(long) timeStamp2 *1000L; // starting time in milliseconds
            long end =(long) (timeStamp2*1000L) +7200000L; // ending time in milliseconds

            String loc = venueArray.get(i);
            ContentValues values = new ContentValues();
            values.put(CalendarContract.Events.DTSTART,  begin);
            values.put(CalendarContract.Events.DTEND,  end );
            values.put(CalendarContract.Events.EVENT_TIMEZONE, timezone);
            values.put(CalendarContract.Events.TITLE, title);
            values.put(CalendarContract.Events.DESCRIPTION, title);
            values.put(CalendarContract.Events.EVENT_LOCATION, loc);
            values.put(CalendarContract.Events.CALENDAR_ID, calID2);

            Cursor cursor =
                    CalendarContract.Instances.query(ctx.getContentResolver(), null, begin, end, title);
            if (cursor.getCount() == 0) {
                cr.insert(CalendarContract.Events.CONTENT_URI, values);
            }
        }

    }

}