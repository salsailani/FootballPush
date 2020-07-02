package com.example.sportsappnav;
import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.util.*;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



      class addPageParams{
        Context  ctx;
        int teamID;
        TextView data;
        addPageParams(Context ctx, int teamID, TextView data){
            this.ctx = ctx;
            this.teamID = teamID;
            this.data = data;
        }
    }

     class addPage extends AsyncTask<addPageParams, Void, String> {


        String result;
        String venue;
        Response response;
        ArrayList<String> resultArray = new ArrayList<String>();
        int timeStamp;
        ArrayList<Integer> timeStampArray = new ArrayList<Integer>();
        ArrayList<String> venueArray = new ArrayList<String>();
        TimeZone timezoneDefault = TimeZone.getDefault();
        String timezone =  timezoneDefault.getID();
        TextView data;


        @Override
        protected String doInBackground(addPageParams... params) {

            // getting the next matches

            Context ctx = params[0].ctx;
            int teamID = params[0].teamID;
            data = params[0].data;
            System.out.println("test111111");
            System.out.println(teamID);
            OkHttpClient client = new OkHttpClient();
            String URL = "https://api-football-v1.p.rapidapi.com/v2/fixtures/team/" + teamID + "/next/100?timezone=" + timezone;
            Request request = new Request.Builder()
                    .url(URL)
                    .get()
                    .addHeader("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "9560035ce2msh757478739105ef3p16f2bdjsne73344650fc8")
                    .build();
            try {
                response = client.newCall(request).execute();
                String json = response.body().string();

                JSONObject obj = new JSONObject(json);
                JSONObject jsonData = obj.getJSONObject("api");
                JSONArray arr = jsonData.getJSONArray("fixtures");

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject homeTeamObj = arr.getJSONObject(i).getJSONObject("homeTeam");
                    String homeTeam = homeTeamObj.getString("team_name");
                    JSONObject awayTeamObj = arr.getJSONObject(i).getJSONObject("awayTeam");
                    String awayTeam = awayTeamObj.getString("team_name");
                    timeStamp = arr.getJSONObject(i).getInt("event_timestamp");
                    venue = arr.getJSONObject(i).getString("venue");
                    result = homeTeam + " vs " + awayTeam;

                    //Title
                    resultArray.add(result);
                    //TimeStamp
                    timeStampArray.add(timeStamp);
                    //venue
                    venueArray.add(venue);
                }



            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            //beginning of calendar pushing


            String result2 = "";
            for (String s : resultArray) {
                result2 +=s + "\n";
            }


            return result2;
        }


        public ArrayList<String> returnResultArray(){
            return resultArray;
        }
         public ArrayList<Integer> returnTimeStampArray(){
             return timeStampArray;
         }
         public ArrayList<String> returnVenueArray(){
             return venueArray;
         }


        @Override
        protected void onPostExecute(String result2) {
            //switching from response type to string


            System.out.println("this is onPostExecute");
            System.out.println(result2);
            data.setText(result2);


            super.onPostExecute(result2);
            System.out.println("////////");
            System.out.println(data);


        }


    }

