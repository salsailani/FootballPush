package com.example.sportsappnav.dummy;
import okhttp3.OkHttpClient;

public class App
{
    public static void main( String[] args ) throws Exception
    {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api-football-v1.p.rapidapi.com/v2/predictions/157462")
                .get()
                .addHeader("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "9560035ce2msh757478739105ef3p16f2bdjsne73344650fc8")
                .build();

        Response response = client.newCall(request).execute();
    }
}

