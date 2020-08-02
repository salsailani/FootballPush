package com.example.footballpush;

import android.app.Dialog;
import android.content.res.Resources;
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

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class SecondFragment extends Fragment {

    GridLayout mainGrid;
    Integer teamID;
    TextView data;
    View view;
    radioDialog radio = new radioDialog();




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
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Uruguay.svg/1024px-Flag_of_Uruguay.svg.png").into((ImageView) view.findViewById(R.id.uruguay));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Flag_of_Portugal.svg/1024px-Flag_of_Portugal.svg.png").into((ImageView) view.findViewById(R.id.portugal));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/9/9a/Flag_of_Spain.svg/1024px-Flag_of_Spain.svg.png").into((ImageView) view.findViewById(R.id.spain));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/1024px-Flag_of_Russia.svg.png").into((ImageView) view.findViewById(R.id.russia));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Flag_of_Croatia.svg/1024px-Flag_of_Croatia.svg.png").into((ImageView) view.findViewById(R.id.croatia));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Flag_of_Denmark.svg/1024px-Flag_of_Denmark.svg.png").into((ImageView) view.findViewById(R.id.denmark));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/0/05/Flag_of_Brazil.svg/1024px-Flag_of_Brazil.svg.png").into((ImageView) view.findViewById(R.id.brazil));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Flag_of_Mexico.svg/1024px-Flag_of_Mexico.svg.png").into((ImageView) view.findViewById(R.id.mexico));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Flag_of_Belgium.svg/1024px-Flag_of_Belgium.svg.png").into((ImageView) view.findViewById(R.id.belgium));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/9/9e/Flag_of_Japan.svg/1024px-Flag_of_Japan.svg.png").into((ImageView) view.findViewById(R.id.japan));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/4/4c/Flag_of_Sweden.svg/1024px-Flag_of_Sweden.svg.png").into((ImageView) view.findViewById(R.id.sweden));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Flag_of_Switzerland.svg/95px-Flag_of_Switzerland.svg.png").into((ImageView) view.findViewById(R.id.switzerland));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Colombia.svg/1024px-Flag_of_Colombia.svg.png").into((ImageView) view.findViewById(R.id.columbia));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/b/be/Flag_of_England.svg/1024px-Flag_of_England.svg.png").into((ImageView) view.findViewById(R.id.england));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/1024px-Flag_of_Saudi_Arabia.svg.png").into((ImageView) view.findViewById(R.id.saudi));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/1024px-Flag_of_Egypt.svg.png").into((ImageView) view.findViewById(R.id.egypt));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Flag_of_Morocco.svg/1024px-Flag_of_Morocco.svg.png").into((ImageView) view.findViewById(R.id.morroco));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Flag_of_Iran.svg/1024px-Flag_of_Iran.svg.png").into((ImageView) view.findViewById(R.id.iran));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Flag_of_Australia_%28converted%29.svg/1024px-Flag_of_Australia_%28converted%29.svg.png").into((ImageView) view.findViewById(R.id.australia));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Flag_of_Iceland.svg/1024px-Flag_of_Iceland.svg.png").into((ImageView) view.findViewById(R.id.iceland));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Flag_of_Peru.svg/1024px-Flag_of_Peru.svg.png").into((ImageView) view.findViewById(R.id.peru));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Flag_of_Nigeria.svg/1024px-Flag_of_Nigeria.svg.png").into((ImageView) view.findViewById(R.id.nigeria));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Flag_of_Costa_Rica_%28state%29.svg/1024px-Flag_of_Costa_Rica_%28state%29.svg.png").into((ImageView) view.findViewById(R.id.costarica));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Flag_of_Serbia.svg/1024px-Flag_of_Serbia.svg.png").into((ImageView) view.findViewById(R.id.serbia));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/1024px-Flag_of_Germany.svg.png").into((ImageView) view.findViewById(R.id.germany));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Flag_of_South_Korea.svg/1024px-Flag_of_South_Korea.svg.png").into((ImageView) view.findViewById(R.id.southkorea));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Flag_of_Panama.svg/1024px-Flag_of_Panama.svg.png").into((ImageView) view.findViewById(R.id.panama));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Flag_of_Tunisia.svg/1024px-Flag_of_Tunisia.svg.png").into((ImageView) view.findViewById(R.id.tunisia));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/1/12/Flag_of_Poland.svg/1024px-Flag_of_Poland.svg.png").into((ImageView) view.findViewById(R.id.poland));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Flag_of_Senegal.svg/1024px-Flag_of_Senegal.svg.png").into((ImageView) view.findViewById(R.id.senegal));


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