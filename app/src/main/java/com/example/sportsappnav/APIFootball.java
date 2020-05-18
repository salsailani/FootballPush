package com.example.sportsappnav;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIFootball
{
    public static String main( String[] args ) throws Exception
    {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api-football-v1.p.rapidapi.com/v2/fixtures/team/33/next/10?timezone=Europe%252FLondon")
                .get()
                .addHeader("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "9560035ce2msh757478739105ef3p16f2bdjsne73344650fc8")
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}

