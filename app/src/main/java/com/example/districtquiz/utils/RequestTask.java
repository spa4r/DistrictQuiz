package com.example.districtquiz.utils;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RequestTask  extends AsyncTask<String, String, String> {

    public static final String URI = "https://crudcrud.com/api/43cec45b61e548d3b5b61c66e0e297c7/questions";

    public String doInBackground(String... strings)  {

        StringBuilder total = null;
        URL url = null;
        HttpURLConnection urlConnection = null;

        try {
            url = new URL(RequestTask.URI);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader r = new BufferedReader(new InputStreamReader(in));
            total = new StringBuilder();
            for (String line; (line = r.readLine()) != null; ) {
                total.append(line).append('\n');
            }
            urlConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        return total.toString();
    }

}