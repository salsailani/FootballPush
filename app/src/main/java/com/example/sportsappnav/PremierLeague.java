package com.example.sportsappnav;

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
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;



public class PremierLeague extends Fragment {

    GridLayout mainGrid;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_premier_league, container, false);

        mainGrid = (GridLayout) view.findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);



        return view;
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

                    Intent intent = new Intent(getActivity(), addPage.class);

                    //card index to teamID (teamID number from APIFootball)

                    //manchester united
                    if (finalI[0] == 0) {
                        finalI[0] = 33;};
                    //liverpool
                    if (finalI[0] == 1) {
                        finalI[0] = 40;};
                    //chelsea
                    if (finalI[0] == 2) {
                        finalI[0] = 49;};
                    //mancity
                    if (finalI[0] == 3) {
                        finalI[0] = 50;};
                    //tottenham
                    if (finalI[0] == 4) {
                        finalI[0] = 47;};
                    //arsenal
                    if (finalI[0] == 5) {
                        finalI[0] = 42;};
                    //everton
                    if (finalI[0] == 6) {
                        finalI[0] = 45;};
                    //wolves
                    if (finalI[0] == 7) {
                        finalI[0] = 39;};
                    //leiscter
                    if (finalI[0] == 8) {
                        finalI[0] = 46;};
                    //watford
                    if (finalI[0] == 9) {
                        finalI[0] = 38;};
                    //palace
                    if (finalI[0] == 10) {
                        finalI[0] = 52;};
                    //burnley
                    if (finalI[0] == 11) {
                        finalI[0] = 44;};
                    //southampton
                    if (finalI[0] == 12) {
                        finalI[0] = 41;};
                    //newcastle
                    if (finalI[0] == 13) {
                        finalI[0] = 34;};
                    //brighton
                    if (finalI[0] == 14) {
                        finalI[0] = 51;};
                    //westham
                    if (finalI[0] == 15) {
                        finalI[0] = 44;};
                    //astonvilla
                    if (finalI[0] == 16) {
                        finalI[0] = 66;};
                    //sheffield
                    if (finalI[0] == 17) {
                        finalI[0] = 62;};
                    //bournemouth
                    if (finalI[0] == 18) {
                        finalI[0] = 35;};
                    //norwich
                    if (finalI[0] == 19) {
                        finalI[0] = 71;};




                    intent.putExtra("info",  finalI[0]);
                    startActivity(intent);

                }
            });

        }
    }
}
