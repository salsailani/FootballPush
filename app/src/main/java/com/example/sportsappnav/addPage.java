package com.example.sportsappnav;
import android.os.AsyncTask;
import android.os.Bundle;
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

        @Override
        protected Void doInBackground(Void... voids) {
            OkHttpClient client = new OkHttpClient();
            TimeZone timezonedefault = TimeZone.getDefault();
            // checking default time zone value
            String timezone =  timezonedefault.getID();
            String URL = "https://api-football-v1.p.rapidapi.com/v2/fixtures/team/33/next/10?timezone=" + timezone;
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
                JSONObject object = arr.getJSONObject(i).getJSONObject("homeTeam");
                JSONObject object2 = arr.getJSONObject(i).getJSONObject("awayTeam");
                result = object.getString("team_name") + " vs " + object2.getString("team_name");
                }


            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            TextView data = (TextView) findViewById(R.id.textView2);
            data.setText(result);
            super.onPostExecute(aVoid);
        }


    }

}
