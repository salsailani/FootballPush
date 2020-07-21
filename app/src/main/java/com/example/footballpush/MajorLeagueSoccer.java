package com.example.footballpush;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class MajorLeagueSoccer extends Fragment {

    GridLayout mainGrid;
    Integer teamID;
    TextView data;
    View view;
    radioDialog radio = new radioDialog();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_major_league_soccer, container, false);



        mainGrid = (GridLayout) view.findViewById(R.id.mainGrid);
        //data = (TextView) view2.findViewById(R.id.textView2);

        setPictures(view);

        //Set Event
        setSingleEvent(mainGrid);



        return view;
    }



    private void setPictures(View view) {
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/b/bb/Atlanta_MLS.svg/1024px-Atlanta_MLS.svg.png").into((ImageView) view.findViewById(R.id.AtlantaUnited));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/3/35/Portland_Timbers_logo.svg/1024px-Portland_Timbers_logo.svg.png").into((ImageView) view.findViewById(R.id.PortlandTimbers));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/5/51/New_York_Red_Bulls_logo.svg/1024px-New_York_Red_Bulls_logo.svg.png").into((ImageView) view.findViewById(R.id.NYredbulls));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/0/09/Sporting_Kansas_City_logo.svg/1024px-Sporting_Kansas_City_logo.svg.png").into((ImageView) view.findViewById(R.id.SportingKansasCity));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/5/54/Columbus_Crew_SC_Logo.svg/1024px-Columbus_Crew_SC_Logo.svg.png").into((ImageView) view.findViewById(R.id.ColumbusCrew));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/2/27/Seattle_Sounders_FC.svg/1024px-Seattle_Sounders_FC.svg.png").into((ImageView) view.findViewById(R.id.SeattleSounders));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/f/f9/New_York_City_FC.svg/1024px-New_York_City_FC.svg.png").into((ImageView) view.findViewById(R.id.NewYorkCityfc));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/5/54/Real_Salt_Lake_2010.svg/1024px-Real_Salt_Lake_2010.svg.png").into((ImageView) view.findViewById(R.id.RealSaltLake));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/4/46/Philadelphia_Union_2018_logo.svg/1024px-Philadelphia_Union_2018_logo.svg.png").into((ImageView) view.findViewById(R.id.PhiladelphiaUnion));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/c/c9/FC_Dallas_logo.svg/1024px-FC_Dallas_logo.svg.png").into((ImageView) view.findViewById(R.id.FCDallas));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/3/32/D.C._United_logo_%282016%29.svg/1024px-D.C._United_logo_%282016%29.svg.png").into((ImageView) view.findViewById(R.id.DCUnited));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/8/86/Los_Angeles_Football_Club.svg/1024px-Los_Angeles_Football_Club.svg.png").into((ImageView) view.findViewById(R.id.LosAngelesFC));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/7/7c/Toronto_FC_Logo.svg/1024px-Toronto_FC_Logo.svg.png").into((ImageView) view.findViewById(R.id.TorontoFC));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/0/0c/Houston_Dynamo_logo.svg/1024px-Houston_Dynamo_logo.svg.png").into((ImageView) view.findViewById(R.id.HoustonDynamo));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/d/d6/New_England_Revolution_logo.svg/1024px-New_England_Revolution_logo.svg.png").into((ImageView) view.findViewById(R.id.NewEnglandRevolution));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/6/6a/Orlando_City_2014.svg/1024px-Orlando_City_2014.svg.png").into((ImageView) view.findViewById(R.id.OrlandoCitySC));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/9/98/San_Jose_Earthquakes_2014.svg/1024px-San_Jose_Earthquakes_2014.svg.png").into((ImageView) view.findViewById(R.id.SanJoseEarthquakes));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/2/2e/Minnesota_United_2014.svg/1024px-Minnesota_United_2014.svg.png").into((ImageView) view.findViewById(R.id.MinnesotaStarsFC));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/5/5d/Vancouver_Whitecaps_FC_logo.svg/1024px-Vancouver_Whitecaps_FC_logo.svg.png").into((ImageView) view.findViewById(R.id.VancouverWhitecaps));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/9/94/Montreal_Impact_%28MLS%29_logo.svg/1024px-Montreal_Impact_%28MLS%29_logo.svg.png").into((ImageView) view.findViewById(R.id.montrealImpact));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/7/70/Los_Angeles_Galaxy_logo.svg/1024px-Los_Angeles_Galaxy_logo.svg.png").into((ImageView) view.findViewById(R.id.LAGalaxy));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/2/2b/Colorado_Rapids_logo.svg/1024px-Colorado_Rapids_logo.svg.png").into((ImageView) view.findViewById(R.id.ColoradoRapids));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/9/90/Chicago_Fire_FC_logo_%282019%29.svg/1024px-Chicago_Fire_FC_logo_%282019%29.svg.png").into((ImageView) view.findViewById(R.id.ChicagoFire));
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
                    final addPage addPage = new addPage();
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
                    addPageParams params = new addPageParams(getContext(), final2, data);
                    addPage.execute(params);
                    Button btnsubmit = (Button) fbDialogue.findViewById(R.id.btn_submit);
                    btnsubmit.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            fbDialogue.dismiss();
                            radio.dialogCreate(getContext(), view, addPage.returnResultArray(), addPage.returnTimeStampArray(), addPage.returnVenueArray());
                        }
                    });
                }
            });

        }
    }

    private int fetchData(int [] finalI){

        Resources r = getResources();

        //card index to teamID (teamID number from APIFootball)

        //psg
        if (finalI[0] == 0) {
            return 1608;}
        //caen
        else if (finalI[0] == 1) {
            return 1617;}
        //bordeaux
        else if (finalI[0] == 2) {
            return 1602;}
        //strasbourg
        else if (finalI[0] == 3) {
            return 1611;}
        //lyon
        else if (finalI[0] == 4) {
            return 1613;}
        //amiens
        else if (finalI[0] == 5) {
            return 1595;}
        //angers
        else if (finalI[0] == 6) {
            return 1604;}
        //nimes
        else if (finalI[0] == 7) {
            return 1606;}
        //lille
        else if (finalI[0] == 8) {
            return  1599;}
        //rennes
        else if (finalI[0] == 9) {
            return 1597;}
        //montpellier
        else if (finalI[0] == 10) {
            return 1615;}
        //dijon
        else if (finalI[0] == 11) {
            return  1616;}
        //nice
        else if (finalI[0] == 12) {
            return 1601;}
        //reims
        else if (finalI[0] == 13) {
            return 1600;}
        //saint etienne
        else if (finalI[0] == 14) {
            return  1609;}
        //guinamp
        else if (finalI[0] == 15) {
            return 1598;}
        //nantes
        else if (finalI[0] == 16) {
            return  1596;}
        //monaco
        else if (finalI[0] == 17) {
            return 1612;}
        else if (finalI[0] == 18) {
            return 1986;}
        //saint etienne
        else if (finalI[0] == 19) {
            return  1614;}
        //guinamp
        else if (finalI[0] == 20) {
            return 1605;}
        //nantes
        else if (finalI[0] == 21) {
            return  1610;}
        //monaco
        else if (finalI[0] == 22) {
            return 1607;}

        return 100;
    }


}