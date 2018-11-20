package com.example.pajama.trackfoodtruck.httpUserController;

import android.os.AsyncTask;

import com.example.pajama.trackfoodtruck.Data.User;

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
        final String url = "http://192.168.1.110:8080/tft/user/" + arg[0]; // the  url from where to fetch data(json)
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(url,
                new User(
                        arg[0],//id
                        arg[1],//username
                        arg[2],//password
                        arg[3],//lastlogin
                        arg[4],//name
                        arg[5],//surname
                        Integer.parseInt(arg[6])//age
                        //arg[7] TODO: favorite foodtrucks
                ));

        return null;
    }


    protected void onPostExecute() {
        httpUserInterface.httpPutUser("Sending data complete");
    }
}