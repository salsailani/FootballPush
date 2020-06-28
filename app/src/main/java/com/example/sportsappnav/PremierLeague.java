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

                    //manunited
                    if (finalI[0] == 0) {
                        finalI[0] = R.integer.manunited;};
                    //liverpool
                    if (finalI[0] == 1) {
                        finalI[0] = R.integer.liverpool;};
                    //chelsea
                    if (finalI[0] == 2) {
                        finalI[0] = R.integer.chelsea;};
                    //mancity
                    if (finalI[0] == 3) {
                        finalI[0] = R.integer.mancity;};
                    //tottenham
                    if (finalI[0] == 4) {
                        finalI[0] = R.integer.tottenham;};
                    //arsenal
                    if (finalI[0] == 5) {
                        finalI[0] = R.integer.arsenal;};
                    //everton
                    if (finalI[0] == 6) {
                        finalI[0] = R.integer.everton;};
                    //wolves
                    if (finalI[0] == 7) {
                        finalI[0] = R.integer.wolves;};
                    //leiscter
                    if (finalI[0] == 8) {
                        finalI[0] = R.integer.leiscter;};
                    //watford
                    if (finalI[0] == 9) {
                        finalI[0] = R.integer.watford;};
                    //palace
                    if (finalI[0] == 10) {
                        finalI[0] = R.integer.palace;};
                    //burnley
                    if (finalI[0] == 11) {
                        finalI[0] = R.integer.burnley;};
                    //southampton
                    if (finalI[0] == 12) {
                        finalI[0] = R.integer.southampton;};
                    //newcastle
                    if (finalI[0] == 13) {
                        finalI[0] = R.integer.newcastle;};
                    //brighton
                    if (finalI[0] == 14) {
                        finalI[0] = R.integer.brighton;};
                    //westham
                    if (finalI[0] == 15) {
                        finalI[0] = R.integer.westham;};
                    //astonvilla
                    if (finalI[0] == 16) {
                        finalI[0] = R.integer.astonvilla;};
                    //sheffield
                    if (finalI[0] == 17) {
                        finalI[0] = R.integer.sheffield;};
                    //bournemouth
                    if (finalI[0] == 18) {
                        finalI[0] = R.integer.bournemouth;};
                    //norwich
                    if (finalI[0] == 19) {
                        finalI[0] = R.integer.norwich;};




                    intent.putExtra("info",  finalI[0]);
                    startActivity(intent);

                }
            });

        }
    }
}
