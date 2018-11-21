package com.example.pajama.trackfoodtruck.httpUserController;

import android.os.AsyncTask;

import com.example.pajama.trackfoodtruck.Data.User;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class HttpGetUser extends AsyncTask<Void, Void, User> {
    private HttpUserInterface httpUserInterface;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected User doInBackground(Void... arg) {
        final String url = "http://192.168.1.110:8080/tft/user"; // the  url from where to fetch data(json) ip kompa
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate.getForObject(url, User.class);
    }

    @Override
    protected void onPostExecute(User user) {
        httpUserInterface.httpGetUser(user);
        super.onPostExecute(user);
    }
}
