package com.example.myapplication;

import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchData extends AsyncTask<Void,Void,Void> {
    String out="";
    String name="";
    String dark_color="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://gist.githubusercontent.com/iranjith4/522d5b466560e91b8ebab54743f2d0fc/raw/7b108e4aaac287c6c3fdf93c3343dd1c62d24faf/radius-mobile-intern.json");
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while (line!=null)
            {
                line=bufferedReader.readLine();
                out=out+line;
            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JSONObject json=new JSONObject(out);
            JSONObject data=json.getJSONObject("data");
            JSONObject profile=data.getJSONObject("profile");
            JSONObject color=data.getJSONObject("theme");

            name = profile.getString("first_name");
            name = name+" ";
            name = name+profile.getString("last_name");
            dark_color = color.getString("dark_colour");





        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.api.setText(name);
        MainActivity.mainLayout.setBackgroundColor(Color.parseColor(dark_color));
        //Log.d("SHOW",dark_color);
    }
}
