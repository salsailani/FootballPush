package com.example.sportsappnav;
import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class addPage extends AppCompatActivity  {

    TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_page);

        //TextView data = (TextView) findViewById(R.id.textView2);
        //data.setText(fetchData());
    }

/*
    private String fetchData () {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://api-football-v1.p.rapidapi.com/v2/fixtures/team/33/next/10?timezone=Europe%252FLondon")
                    .get()
                    .addHeader("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "9560035ce2msh757478739105ef3p16f2bdjsne73344650fc8")
                    .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
            return("error check trace");
        }
        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return("error check trace");
        }


    }
*/



}
