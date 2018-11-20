package com.example.pajama.trackfoodtruck.httpUserController;

import android.os.AsyncTask;
import android.util.Log;

import com.example.pajama.trackfoodtruck.Data.User;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;


public class HttpPutUser extends AsyncTask<String, Void, Void> {
    private HttpUserInterface httpUserInterface;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String... arg) {
        final String url = "http://192.168.1.110:8080/tft/user"; // the  url from where to fetch data(json)
        RestTemplate restTemplate = new RestTemplate(true);

        User newUser = new User();
        newUser.setLogin(arg[0]);
        newUser.setPassword(arg[1]);
        newUser.setRepPassword(arg[2]);
        newUser.setEmail(arg[3]);

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        HttpEntity<User> requestEntity = new HttpEntity<>(newUser, requestHeaders);

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        Log.e("QQQWWEE", result);

        return null;
    }


    protected void onPostExecute() {
        httpUserInterface.httpPutUser("Sending data complete");
    }
}