package com.example.sportsappnav;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class Bundesliga extends Fragment {

    GridLayout mainGrid;
    Integer teamID;
    TextView data;
    View view;
    radioDialog radio = new radioDialog();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bundesliga, container, false);
        View view2 = inflater.inflate(R.layout.add_page, container, false);



        mainGrid = (GridLayout) view.findViewById(R.id.mainGrid);
        //data = (TextView) view2.findViewById(R.id.textView2);


        setPictures(view);

        //Set Event

        setSingleEvent(mainGrid);



        return view;
    }


    private void setPictures(View view){
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/FC_Bayern_M%C3%BCnchen_logo_%282017%29.svg/1024px-FC_Bayern_M%C3%BCnchen_logo_%282017%29.svg.png").into((ImageView) view.findViewById(R.id.bayernmunich));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Borussia_Dortmund_logo.svg/1024px-Borussia_Dortmund_logo.svg.png").into((ImageView) view.findViewById(R.id.borrusiadortmund));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/0/04/RB_Leipzig_2014_logo.svg/1024px-RB_Leipzig_2014_logo.svg.png").into((ImageView) view.findViewById(R.id.RBlezpeig));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Borussia_M%C3%B6nchengladbach_logo.svg/1024px-Borussia_M%C3%B6nchengladbach_logo.svg.png").into((ImageView) view.findViewById(R.id.BorussiaMonchengladbach));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/5/59/Bayer_04_Leverkusen_logo.svg/1024px-Bayer_04_Leverkusen_logo.svg.png").into((ImageView) view.findViewById(R.id.BayerLeverkusen));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Logo_TSG_Hoffenheim.svg/1024px-Logo_TSG_Hoffenheim.svg.png").into((ImageView) view.findViewById(R.id.Hoffenheim));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Logo-VfL-Wolfsburg.svg/1024px-Logo-VfL-Wolfsburg.svg.png").into((ImageView) view.findViewById(R.id.VfLWolfsburg));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/6/6d/SC_Freiburg_logo.svg/1024px-SC_Freiburg_logo.svg.png").into((ImageView) view.findViewById(R.id.SCFreiburg));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Eintracht_Frankfurt_Logo.svg/1024px-Eintracht_Frankfurt_Logo.svg.png").into((ImageView) view.findViewById(R.id.EintrachtFrankfurt));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Hertha_BSC_Logo_2012.svg/1024px-Hertha_BSC_Logo_2012.svg.png").into((ImageView) view.findViewById(R.id.HerthaBerlin));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/1._FC_Union_Berlin_Logo.svg/1024px-1._FC_Union_Berlin_Logo.svg.png").into((ImageView) view.findViewById(R.id.UnionBerlin));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6d/FC_Schalke_04_Logo.svg/1024px-FC_Schalke_04_Logo.svg.png").into((ImageView) view.findViewById(R.id.FCSchalke04));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Logo_Mainz_05.svg/1024px-Logo_Mainz_05.svg.png").into((ImageView) view.findViewById(R.id.FSVMainz05));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/5/53/FC_Cologne_logo.svg/1024px-FC_Cologne_logo.svg.png").into((ImageView) view.findViewById(R.id.FCKoln));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/c/c5/FC_Augsburg_logo.svg/1024px-FC_Augsburg_logo.svg.png").into((ImageView) view.findViewById(R.id.FCAugsburg));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/SV-Werder-Bremen-Logo.svg/1024px-SV-Werder-Bremen-Logo.svg.png").into((ImageView) view.findViewById(R.id.WerderBremen));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Fortuna_D%C3%BCsseldorf.svg/1024px-Fortuna_D%C3%BCsseldorf.svg.png").into((ImageView) view.findViewById(R.id.FortunaDusseldorf));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/b/b3/SC_Paderborn_07_logo.svg/1024px-SC_Paderborn_07_logo.svg.png").into((ImageView) view.findViewById(R.id.SCPaderborn07));


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
                    fetchData(finalI);
                    final Dialog fbDialogue = new Dialog(getContext());
                    fbDialogue.setContentView(R.layout.add_page);
                    data = fbDialogue.findViewById(R.id.textView2);
                    data.setTextColor(Color.rgb(0,0,0));
                    fbDialogue.show();
                    fbDialogue.setCancelable(true);
                    fbDialogue.setCanceledOnTouchOutside(true);
                    addPageParams params = new addPageParams(getContext(), finalI[0], data);
                    addPage.execute(params);
                    Button btnsubmit = (Button) fbDialogue.findViewById(R.id.btn_submit);
                    btnsubmit.setOnClickListener(new View.OnClickListener() {

                        @RequiresApi(api = Build.VERSION_CODES.N)
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

    private void fetchData(int [] finalI){

        Resources r = getResources();

        //card index to teamID (teamID number from APIFootball)

        //manunited
        if (finalI[0] == 0) {
            finalI[0] = r.getInteger(R.integer.bayernmunchen);};
        //liverpool
        if (finalI[0] == 1) {
            finalI[0] = r.getInteger(R.integer.BorussiaDortmund);};
        //chelsea
        if (finalI[0] == 2) {
            finalI[0] = r.getInteger(R.integer.RBLeipzig);};
        //mancity
        if (finalI[0] == 3) {
            finalI[0] = r.getInteger(R.integer.BorussiaMonchengladbach);};
        //tottenham
        if (finalI[0] == 4) {
            finalI[0] = r.getInteger(R.integer.BayerLeverkusen);};
        //arsenal
        if (finalI[0] == 5) {
            finalI[0] = r.getInteger(R.integer.Hoffenheim);};
        //everton
        if (finalI[0] == 6) {
            finalI[0] = r.getInteger(R.integer.VfLWolfsburg);};
        //wolves
        if (finalI[0] == 7) {
            finalI[0] = r.getInteger(R.integer.SCFreiburg);};
        //leiscter
        if (finalI[0] == 8) {
            finalI[0] = r.getInteger(R.integer.EintrachtFrankfurt);};
        //watford
        if (finalI[0] == 9) {
            finalI[0] = r.getInteger(R.integer.HerthaBerlin);};
        //palace
        if (finalI[0] == 10) {
            finalI[0] = r.getInteger(R.integer.UnionBerlin);};
        //burnley
        if (finalI[0] == 11) {
            finalI[0] = r.getInteger(R.integer.FCSchalke04);};
        //southampton
        if (finalI[0] == 12) {
            finalI[0] = r.getInteger(R.integer.FSVMainz05);};
        //newcastle
        if (finalI[0] == 13) {
            finalI[0] = r.getInteger(R.integer.FCKoln);};
        //brighton
        if (finalI[0] == 14) {
            finalI[0] = r.getInteger(R.integer.FCAugsburg);};
        //westham
        if (finalI[0] == 15) {
            finalI[0] = r.getInteger(R.integer.WerderBremen);};
        //astonvilla
        if (finalI[0] == 16) {
            finalI[0] = r.getInteger(R.integer.FortunaDusseldorf);};
        //sheffield
        if (finalI[0] == 17) {
            finalI[0] = r.getInteger(R.integer.SCPaderborn07);};


    }
}



