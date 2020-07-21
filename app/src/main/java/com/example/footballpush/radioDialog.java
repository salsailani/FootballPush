package com.example.footballpush;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

public class radioDialog {

    readCalendar read = new readCalendar();
    final addPage addPage = new addPage();
    //final calendarPush calendar = new calendarPush();
    String selectedItem;


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void dialogCreate(final Context activity, final View view, final ArrayList<String> results, final ArrayList<Integer> time, final ArrayList<String> venue ) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //read.read(activity,addPage.returnResultArray());

        // Set the alert dialog title
        builder.setTitle("Choose a calendar.");

        // Initializing an array of calendars
        final String[] calendars = read.read(activity, addPage.returnResultArray());

        builder.setSingleChoiceItems(
                calendars, // Items list
                -1, // Index of checked item (-1 = no selection)
                new DialogInterface.OnClickListener() // Item click listener
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Get the alert dialog selected item's text
                        selectedItem = Arrays.asList(calendars).get(i);
                    }
                });

        // Set the a;ert dialog positive button
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Just dismiss the alert dialog after selection
                // Or do something now
                final calendarPush calendar = new calendarPush();
                System.out.println(selectedItem);
                int calendarID = read.hmap.get(selectedItem);
                System.out.println(calendarID);
                calendar.push(activity, results, time, venue, calendarID );
                Snackbar mySnackbar = Snackbar.make(view, "Fixtures successfully pushed into calendar    \u2713", 3000);
                mySnackbar.getView().setBackgroundColor(Color.parseColor("#008060"));
                mySnackbar.show();
            }
        });

        // Create the alert dialog
        AlertDialog dialog = builder.create();

        // Finally, display the alert dialog
        dialog.show();
    }
}

