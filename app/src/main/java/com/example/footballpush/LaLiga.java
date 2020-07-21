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


public class LaLiga extends Fragment {

    GridLayout mainGrid;
    Integer teamID;
    TextView data;
    View view;
    radioDialog radio = new radioDialog();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_la_liga, container, false);
        View view2 = inflater.inflate(R.layout.add_page, container, false);



        mainGrid = (GridLayout) view.findViewById(R.id.mainGrid);
        //data = (TextView) view2.findViewById(R.id.textView2);

        setPictures(view);

        //Set Event
        setSingleEvent(mainGrid);



        return view;
    }



    private void setPictures(View view) {
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/9/98/Club_Athletic_Bilbao_logo.svg/1024px-Club_Athletic_Bilbao_logo.svg.png").into((ImageView) view.findViewById(R.id.athleticClub));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/b/b8/Club_Deportivo_Legan%C3%A9s_logo.svg/1024px-Club_Deportivo_Legan%C3%A9s_logo.svg.png").into((ImageView) view.findViewById(R.id.leganes));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/4/47/FC_Barcelona_%28crest%29.svg/1024px-FC_Barcelona_%28crest%29.svg.png").into((ImageView) view.findViewById(R.id.barcelona));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/2/2e/Deportivo_Alaves_logo.svg/1024px-Deportivo_Alaves_logo.svg.png").into((ImageView) view.findViewById(R.id.alaves));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/1/13/Real_betis_logo.svg/1024px-Real_betis_logo.svg.png").into((ImageView) view.findViewById(R.id.realBetis));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/7/7b/Levante_Uni%C3%B3n_Deportiva%2C_S.A.D._logo.svg/1024px-Levante_Uni%C3%B3n_Deportiva%2C_S.A.D._logo.svg.png").into((ImageView) view.findViewById(R.id.levante));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/1/12/RC_Celta_de_Vigo_logo.svg/1024px-RC_Celta_de_Vigo_logo.svg.png").into((ImageView) view.findViewById(R.id.celtafigo));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/d/d6/Rcd_espanyol_logo.svg/1024px-Rcd_espanyol_logo.svg.png").into((ImageView) view.findViewById(R.id.espanyol));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/3/3b/SD_Eibar_logo_2016.svg/1024px-SD_Eibar_logo_2016.svg.png").into((ImageView) view.findViewById(R.id.eibar));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/3/3b/Sevilla_FC_logo.svg/1024px-Sevilla_FC_logo.svg.png").into((ImageView) view.findViewById(R.id.sevilla));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/5/56/Real_Madrid_CF.svg/1024px-Real_Madrid_CF.svg.png").into((ImageView) view.findViewById(R.id.realmadrid));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/4/46/Getafe_logo.svg/1024px-Getafe_logo.svg.png").into((ImageView) view.findViewById(R.id.getafe));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/c/ce/Valenciacf.svg/1024px-Valenciacf.svg.png").into((ImageView) view.findViewById(R.id.valencia));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/f/f4/Atletico_Madrid_2017_logo.svg/1024px-Atletico_Madrid_2017_logo.svg.png").into((ImageView) view.findViewById(R.id.atleticoMadrid));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/7/70/Villarreal_CF_logo.svg/1024px-Villarreal_CF_logo.svg.png").into((ImageView) view.findViewById(R.id.villareal));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/f/f1/Real_Sociedad_logo.svg/1024px-Real_Sociedad_logo.svg.png").into((ImageView) view.findViewById(R.id.realSociedad));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/8/8a/Logo_of_SD_Huesca.svg/1024px-Logo_of_SD_Huesca.svg.png").into((ImageView) view.findViewById(R.id.huesca));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/9/90/For_article_Girona_FC.svg/1024px-For_article_Girona_FC.svg.png").into((ImageView) view.findViewById(R.id.girona));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/6/6e/Real_Valladolid_Logo.svg/1024px-Real_Valladolid_Logo.svg.png").into((ImageView) view.findViewById(R.id.valladolid));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/EscudoRayoVallecano.svg/1024px-EscudoRayoVallecano.svg.png").into((ImageView) view.findViewById(R.id.rayovallecano));


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

        //athletic club
        if (finalI[0] == 0) {
            return 531;}
        //leganes
        else if (finalI[0] == 1) {
            return 537;}
        //Barcelona
        else if (finalI[0] == 2) {
            return 529;}
        //Alaves
        else if (finalI[0] == 3) {
            return 542;}
        //real betis
        else if (finalI[0] == 4) {
            return 543;}
        //levante
        else if (finalI[0] == 5) {
            return 539;}
        //celtafigo
        else if (finalI[0] == 6) {
            return 538;}
        //espanyol
        else if (finalI[0] == 7) {
            return 540;}
        //eibar
        else if (finalI[0] == 8) {
            return  545;}
        //sevilla
        else if (finalI[0] == 9) {
            return 536;}
        //real madrid
        else if (finalI[0] == 10) {
            return 541;}
        //getafe
        else if (finalI[0] == 11) {
            return  546;}
        //valencia
        else if (finalI[0] == 12) {
            return 532;}
        //atletico madrid
        else if (finalI[0] == 13) {
            return 530;}
        //villareal
        else if (finalI[0] == 14) {
            return  533;}
        //real sociedad
        else if (finalI[0] == 15) {
            return 548;}
        //huesca
        else if (finalI[0] == 16) {
            return  726;}
        //girona
        else if (finalI[0] == 17) {
            return 547;}
        //valladolid
        else if (finalI[0] == 18) {
            return  720;}
        //rayo vallecano
        else if (finalI[0] == 19) {
            return  728;}

        return 100;
    }


}