package com.example.footballpush;

import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Color;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;


public class NationalTeams extends Fragment {

    GridLayout mainGrid;
    Integer teamID;
    TextView data;
    View view;
    calendarDialog radio = new calendarDialog();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        View view2 = inflater.inflate(R.layout.add_page, container, false);



        mainGrid = (GridLayout) view.findViewById(R.id.mainGrid);
        //data = (TextView) view2.findViewById(R.id.textView2);

        setPictures(view);

        //Set Event
        setSingleEvent(mainGrid);



        return view;
    }



    private void setPictures(View view) {
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/1024px-Flag_of_France.svg.png").into((ImageView) view.findViewById(R.id.france));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/1024px-Flag_of_Argentina.svg.png").into((ImageView) view.findViewById(R.id.argentina));
    }



    private void setSingleEvent(GridLayout mainGrid) {

        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int[] finalI = {i};
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    final viewNextFixtures viewNextFixtures = new viewNextFixtures();
                    final calendarPush calendar = new calendarPush();
                    int final2;
                    final2 = fetchData(finalI);
                    final Dialog fbDialogue = new Dialog(getContext());
                    //fbDialogue.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(100, 0, 0, 0)));
                    fbDialogue.setContentView(R.layout.add_page);
                    data = fbDialogue.findViewById(R.id.textView2);
                    data.setTextColor(Color.rgb(0,0,0));
                    fbDialogue.show();
                    fbDialogue.setCancelable(true);
                    fbDialogue.setCanceledOnTouchOutside(true);
                    viewNextFixturesParams params = new viewNextFixturesParams(getContext(), final2, data);
                    viewNextFixtures.execute(params);
                    Button btnsubmit = (Button) fbDialogue.findViewById(R.id.btn_submit);
                    btnsubmit.setOnClickListener(new View.OnClickListener() {

                        @RequiresApi(api = Build.VERSION_CODES.N)
                        @Override
                        public void onClick(View v) {
                            String[] PERMISSIONS = {
                                    Manifest.permission.READ_CALENDAR,
                                    Manifest.permission.WRITE_CALENDAR,
                            };

                            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED ) {
                                ActivityCompat.requestPermissions(getActivity(), PERMISSIONS, 1);
                            }
                            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED ){
                                fbDialogue.dismiss();
                                radio.dialogCreate(getContext(), view, viewNextFixtures.returnResultArray(), viewNextFixtures.returnTimeStampArray(), viewNextFixtures.returnVenueArray());
                            }

                        }
                    });
                }
            });

        }
    }

    private int fetchData(int [] finalI){

        Resources r = getResources();

        //card index to teamID (teamID number from APIFootball)

        //france
        if (finalI[0] == 0) {
            return 2;}
        //argentina
        else if (finalI[0] == 1) {
            return 26;}
        //uruguay
        else if (finalI[0] == 2) {
            return 7;}
        //Portugal
        else if (finalI[0] == 3) {
            return 27;}
        //spain
        else if (finalI[0] == 4) {
            return 9;}
        //russia
        else if (finalI[0] == 5) {
            return 4;}
        //croatia
        else if (finalI[0] == 6) {
            return 3;}
        //denmark
        else if (finalI[0] == 7) {
            return 21;}
        //Brazil
        else if (finalI[0] == 8) {
            return  6;}
        //mexico
        else if (finalI[0] == 9) {
            return 16;}
        //belgium
        else if (finalI[0] == 10) {
            return 1;}
        //japan
        else if (finalI[0] == 11) {
            return  12;}
        //sweden
        else if (finalI[0] == 12) {
            return 5;}
        //switzerland
        else if (finalI[0] == 13) {
            return 15;}
        //columbia
        else if (finalI[0] == 14) {
            return  8;}
        //England
        else if (finalI[0] == 15) {
            return 10;}
        //saudi
        else if (finalI[0] == 16) {
            return  23;}
        //egypt
        else if (finalI[0] == 17) {
            return 32;}
        //morroco
        else if (finalI[0] == 18) {
            return  31;}
        //iran
        else if (finalI[0] == 19) {
            return  22;}

        //australia
        else if (finalI[0] == 20) {
            return  20;}
        //iceland
        else if (finalI[0] == 21) {
            return 18;}
        //peru
        else if (finalI[0] == 22) {
            return 30;}
        //nigeria
        else if (finalI[0] == 23) {
            return  19;}
        //costarica
        else if (finalI[0] == 24) {
            return  29;}
        //serbia
        else if (finalI[0] == 25) {
            return 14;}
        //germany
        else if (finalI[0] == 26) {
            return  25;}
        //south korea
        else if (finalI[0] == 27) {
            return 17;}
        //panama
        else if (finalI[0] == 28) {
            return  11;}
        //tunisia
        else if (finalI[0] == 29) {
            return 28;}
        //poland
        else if (finalI[0] == 30) {
            return 24;}
        //Senegal
        else if (finalI[0] == 31) {
            return  13;}


        return 100;
    }


}