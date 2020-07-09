package com.example.sportsappnav;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class LigueOne extends Fragment {

    GridLayout mainGrid;
    Integer teamID;
    TextView data;
    View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ligue_one, container, false);



        mainGrid = (GridLayout) view.findViewById(R.id.mainGrid);
        //data = (TextView) view2.findViewById(R.id.textView2);

        setPictures(view);

        //Set Event
        setSingleEvent(mainGrid);



        return view;
    }



    private void setPictures(View view) {
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/a/a7/Paris_Saint-Germain_F.C..svg/1024px-Paris_Saint-Germain_F.C..svg.png").into((ImageView) view.findViewById(R.id.psg));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/a/aa/SM_Caen_2016_logo.svg/1024px-SM_Caen_2016_logo.svg.png").into((ImageView) view.findViewById(R.id.caen));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Girondins_de_Bordeaux.png/1024px-Girondins_de_Bordeaux.png").into((ImageView) view.findViewById(R.id.bordeaux));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/8/80/Racing_Club_de_Strasbourg_logo.svg/1024px-Racing_Club_de_Strasbourg_logo.svg.png").into((ImageView) view.findViewById(R.id.strasbourg));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/c/c6/Olympique_Lyonnais.svg/1024px-Olympique_Lyonnais.svg.png").into((ImageView) view.findViewById(R.id.lyon));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/f/f6/Amiens_SC_Logo.svg/1024px-Amiens_SC_Logo.svg.png").into((ImageView) view.findViewById(R.id.amiens));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/d/d4/Angers_SCO_logo.svg/1024px-Angers_SCO_logo.svg.png").into((ImageView) view.findViewById(R.id.angers));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/0/05/N%C3%AEmes_Olympique_2018_logo.svg/1024px-N%C3%AEmes_Olympique_2018_logo.svg.png").into((ImageView) view.findViewById(R.id.nimes));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/3/3f/Lille_OSC_2018_logo.svg/1024px-Lille_OSC_2018_logo.svg.png").into((ImageView) view.findViewById(R.id.lille));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/9/9e/Stade_Rennais_FC.svg/1024px-Stade_Rennais_FC.svg.png").into((ImageView) view.findViewById(R.id.rennes));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/a/a8/Montpellier_HSC_logo.svg/1024px-Montpellier_HSC_logo.svg.png").into((ImageView) view.findViewById(R.id.montpellier));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/f/f7/Dijon_FCO_logo.svg/1024px-Dijon_FCO_logo.svg.png").into((ImageView) view.findViewById(R.id.dijon));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/2/2e/OGC_Nice_logo.svg/1024px-OGC_Nice_logo.svg.png").into((ImageView) view.findViewById(R.id.nice));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/c/cb/Stade_de_Reims.png/1024px-Stade_de_Reims.png").into((ImageView) view.findViewById(R.id.reims));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Logo_AS_Saint-%C3%89tienne.svg/1024px-Logo_AS_Saint-%C3%89tienne.svg.png").into((ImageView) view.findViewById(R.id.saintetienne));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/5/56/En_Avant_Guingamp_logo.svg/1024px-En_Avant_Guingamp_logo.svg.png").into((ImageView) view.findViewById(R.id.guinamp));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/FC_Nantes_2019_logo.svg/1024px-FC_Nantes_2019_logo.svg.png").into((ImageView) view.findViewById(R.id.nantes));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/AS_Monaco_FC.svg/1024px-AS_Monaco_FC.svg.png").into((ImageView) view.findViewById(R.id.monaco));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d8/Olympique_Marseille_logo.svg/1024px-Olympique_Marseille_logo.svg.png").into((ImageView) view.findViewById(R.id.marseille));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/6/63/Toulouse_FC_2018_logo.svg/1024px-Toulouse_FC_2018_logo.svg.png").into((ImageView) view.findViewById(R.id.toulouse));


    }



    private void setSingleEvent(GridLayout mainGrid) {

        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int[] finalI = {i};
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
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
                            calendar.push(getContext(), addPage.returnResultArray(), addPage.returnTimeStampArray(), addPage.returnVenueArray() );
                            fbDialogue.dismiss();
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
            return 85;}
        //caen
        else if (finalI[0] == 1) {
            return 88;}
        //bordeaux
        else if (finalI[0] == 2) {
            return 78;}
        //strasbourg
        else if (finalI[0] == 3) {
            return 95;}
        //lyon
        else if (finalI[0] == 4) {
            return 80;}
        //amiens
        else if (finalI[0] == 5) {
            return 87;}
        //angers
        else if (finalI[0] == 6) {
            return 77;}
        //nimes
        else if (finalI[0] == 7) {
            return 92;}
        //lille
        else if (finalI[0] == 8) {
            return  79;}
        //rennes
        else if (finalI[0] == 9) {
            return 94;}
        //montpellier
        else if (finalI[0] == 10) {
            return 82;}
        //dijon
        else if (finalI[0] == 11) {
            return  89;}
        //nice
        else if (finalI[0] == 12) {
            return 84;}
        //reims
        else if (finalI[0] == 13) {
            return 93;}
        //saint etienne
        else if (finalI[0] == 14) {
            return  1063;}
        //guinamp
        else if (finalI[0] == 15) {
            return 90;}
        //nantes
        else if (finalI[0] == 16) {
            return  83;}
        //monaco
        else if (finalI[0] == 17) {
            return 91;}
        //marseille
        else if (finalI[0] == 18) {
            return  81;}
        //toulouse
        else if (finalI[0] == 19) {
            return  96;}

        return 100;
    }


}