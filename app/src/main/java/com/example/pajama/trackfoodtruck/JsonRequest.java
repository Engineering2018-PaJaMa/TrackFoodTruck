package com.example.pajama.trackfoodtruck;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonRequest extends AsyncTask<String, Void, String> {

    Activity activity;

    JsonRequest(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... params) {

        String data = "";

        HttpURLConnection httpURLConnection = null;
        try {

            httpURLConnection = (HttpURLConnection) new URL(params[0]).openConnection();
            httpURLConnection.setRequestMethod("POST");

            httpURLConnection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
            wr.writeBytes(params[1]);
            wr.flush();
            wr.close();

            InputStream in = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(in);

            int inputStreamData = inputStreamReader.read();
            while (inputStreamData != -1) {
                char current = (char) inputStreamData;
                inputStreamData = inputStreamReader.read();
                data += current;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return data;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        Log.e("INFO", result.toString());
        Bundle bundle = new Bundle();
        bundle.putString("email", result);
        Intent intent = new Intent(activity, WelcomeActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
//        try {
//            JSONObject res = new JSONObject(result);
//            bundle.putString("email", res.getJSONObject("email").toString());
//            Intent intent = new Intent(activity, WelcomeActivity.class);
//            intent.putExtras(bundle);
//            Log.e("INFO", "DUPA");
//            activity.startActivity(intent);
//        } catch (JSONException e) {
//
//        }
    }
}

