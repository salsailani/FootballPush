package com.example.footballpush;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

public class readCalendar {
    Set<Integer> IDList = new HashSet<>();
    Set<String> displayNameList = new LinkedHashSet<String>();
    Map< String, Integer> hmap;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String[] read(Context ctx, ArrayList<String> resultArray) {
        TimeZone timezoneDefault = TimeZone.getDefault();
        String timezone = timezoneDefault.getID();



        ContentResolver cr = ctx.getContentResolver();
        ContentValues[] eventsArray = new ContentValues[resultArray.size()];


        // Projection array. Creating indices for this array instead of doing
        // dynamic lookups improves performance.
        final String[] EVENT_PROJECTION = new String[]{
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




        // Use the cursor to step through the returned records
        while (cur.moveToNext()) {
            //int calID = 0;
            String displayName = null;
            String accountName = null;
            String ownerName = null;
            int visible;


            // Get the field values
            Integer calID = (int) (long) cur.getLong(PROJECTION_ID_INDEX);
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
        hmap = new HashMap< String , Integer>();

        Iterator it1 = displayNameList.iterator();
        Iterator it2 = IDList.iterator();
        while(it1.hasNext()) {
            hmap.put((String) it1.next(), (Integer) it2.next());
        }



        final String[] displayNameArray= displayNameList.toArray(new String[displayNameList.size()]);
        return displayNameArray;


    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Integer[] returnIDList(){
        Integer[] IDListArray = (Integer[]) IDList.toArray();
        for (int i=0; i<IDListArray.length;i++){
            IDListArray[i] =  Math.toIntExact(IDListArray[i]);
        }
        return IDListArray;
    }
    public String[] returnDisplayNameList(){
        String[] displayNameArray= displayNameList.toArray(new String[displayNameList.size()]);
        return displayNameArray;
    }
}
