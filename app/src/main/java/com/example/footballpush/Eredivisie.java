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


public class Eredivisie extends Fragment {

    GridLayout mainGrid;
    Integer teamID;
    TextView data;
    View view;
    calendarDialog radio = new calendarDialog();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eredivisie, container, false);



        mainGrid = (GridLayout) view.findViewById(R.id.mainGrid);
        //data = (TextView) view2.findViewById(R.id.textView2);

        setPictures(view);

        //Set Event
        setSingleEvent(mainGrid);



        return view;
    }



    private void setPictures(View view) {
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/PEC_Zwolle_logo.svg/1024px-PEC_Zwolle_logo.svg.png").into((ImageView) view.findViewById(R.id.pecZwolle));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/e/e1/SC_Heerenveen_logo.svg/1024px-SC_Heerenveen_logo.svg.png").into((ImageView) view.findViewById(R.id.Heerenveen));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/7/79/Ajax_Amsterdam.svg/1024px-Ajax_Amsterdam.svg.png").into((ImageView) view.findViewById(R.id.ajax));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/9/9e/Heracles_Almelo_logo.svg/1024px-Heracles_Almelo_logo.svg.png").into((ImageView) view.findViewById(R.id.Heracles));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/7/77/Willem_II_logo.svg/1024px-Willem_II_logo.svg.png").into((ImageView) view.findViewById(R.id.WillemII));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/2/2a/VVV-Venlo_Logo.svg/1024px-VVV-Venlo_Logo.svg.png").into((ImageView) view.findViewById(R.id.VVVvenlo));
        Picasso.get().load("https://media.api-sports.io/football/teams/196.png").into((ImageView) view.findViewById(R.id.Excelsior));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/2/2d/Fortuna_Sittard_logo.svg/1024px-Fortuna_Sittard_logo.svg.png").into((ImageView) view.findViewById(R.id.FortunaSittard));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/0/05/PSV_Eindhoven.svg/1024px-PSV_Eindhoven.svg.png").into((ImageView) view.findViewById(R.id.PSVEindhoven));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/FC_Utrecht.svg/1024px-FC_Utrecht.svg.png").into((ImageView) view.findViewById(R.id.Utrecht));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/a/ad/ADO_Den_Haag_logo.svg/1024px-ADO_Den_Haag_logo.svg.png").into((ImageView) view.findViewById(R.id.ADODenHaag));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/8/83/FC_Emmen_logo.svg/1024px-FC_Emmen_logo.svg.png").into((ImageView) view.findViewById(R.id.Emmen));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/2/28/VBV_De_Graafschap_Doetinchem.svg/1024px-VBV_De_Graafschap_Doetinchem.svg.png").into((ImageView) view.findViewById(R.id.DeGraafschap));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/e/e3/Feyenoord_logo.svg/1024px-Feyenoord_logo.svg.png").into((ImageView) view.findViewById(R.id.Feyenoord));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/c/c8/SBV_Vitesse_logo.svg/1024px-SBV_Vitesse_logo.svg.png").into((ImageView) view.findViewById(R.id.Vitesse));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/2/2c/FC_Groningen_logo.svg/1024px-FC_Groningen_logo.svg.png").into((ImageView) view.findViewById(R.id.Groningen));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/AZ_Alkmaar.svg/1024px-AZ_Alkmaar.svg.png").into((ImageView) view.findViewById(R.id.AZAlkmaar));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Logo_NAC_Breda.png/1024px-Logo_NAC_Breda.png").into((ImageView) view.findViewById(R.id.NACBreda));
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

        //psg
        if (finalI[0] == 0) {
            return 193;}
        //caen
        else if (finalI[0] == 1) {
            return 210;}
        //bordeaux
        else if (finalI[0] == 2) {
            return 194;}
        //strasbourg
        else if (finalI[0] == 3) {
            return 206;}
        //lyon
        else if (finalI[0] == 4) {
            return 195;}
        //amiens
        else if (finalI[0] == 5) {
            return 204;}
        //angers
        else if (finalI[0] == 6) {
            return 196;}
        //nimes
        else if (finalI[0] == 7) {
            return 205;}
        //lille
        else if (finalI[0] == 8) {
            return  197;}
        //rennes
        else if (finalI[0] == 9) {
            return 207;}
        //montpellier
        else if (finalI[0] == 10) {
            return 198;}
        //dijon
        else if (finalI[0] == 11) {
            return  208;}
        //nice
        else if (finalI[0] == 12) {
            return 199;}
        //reims
        else if (finalI[0] == 13) {
            return 209;}
        //saint etienne
        else if (finalI[0] == 14) {
            return  200;}
        //guinamp
        else if (finalI[0] == 15) {
            return 202;}
        //nantes
        else if (finalI[0] == 16) {
            return  201;}
        //monaco
        else if (finalI[0] == 17) {
            return 203;}

        return 100;
    }


}