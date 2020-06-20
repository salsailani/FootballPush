package com.example.sportsappnav;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.util.*;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class addPage extends AppCompatActivity  {

    TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_page);

        TextView data = (TextView) findViewById(R.id.textView2);
        new MyTask().execute();


    }

    private class MyTask extends AsyncTask<Void, Void, Void> {
        String result;
        String result2;
        Response response;
        ArrayList<String> resultArray = new ArrayList<String>();
        int timeStamp;


        Intent intent = getIntent();
        int teamID = intent.getIntExtra("info", 0);

        @Override
        protected Void doInBackground(Void... voids) {
            OkHttpClient client = new OkHttpClient();
            TimeZone timezonedefault = TimeZone.getDefault();
            // checking default time zone value
            String timezone =  timezonedefault.getID();
            String URL = "https://api-football-v1.p.rapidapi.com/v2/fixtures/team/" + teamID + "/next/20?timezone=" + timezone;
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
                    for (int i = 0; i < arr.length() - 1; i++) {
                JSONObject homeTeamObj = arr.getJSONObject(i).getJSONObject("homeTeam");
                String homeTeam = homeTeamObj.getString("team_name");
                JSONObject awayTeamObj = arr.getJSONObject(i).getJSONObject("awayTeam");
                String awayTeam = awayTeamObj.getString("team_name");


                int timeStamp = arr.getJSONObject(i).getInt("event_timestamp");
                result = homeTeam + " vs " + awayTeam;
                resultArray.add(result);

                        /*calendar attempt
                        ContentResolver cr = getContentResolver();
                        ContentValues values = new ContentValues();
                        values.put(CalendarContract.Events.DTSTART, timeStamp);
                        values.put(CalendarContract.Events.TITLE, homeTeam + "vs " + awayTeam);
                        values.put(CalendarContract.Events.DESCRIPTION, "Football Match");
                        //values.put(CalendarContract.Events.CALENDAR_ID, calID);
                        Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);
                        */

                }

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }



            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            TextView data = (TextView) findViewById(R.id.textView2);

            //switching from response type to string
            String result2 = "";
            for (String s : resultArray) {
                result2 +=s + "\n";
            }

            data.setText(result2);
            super.onPostExecute(aVoid);
        }




    }

}
