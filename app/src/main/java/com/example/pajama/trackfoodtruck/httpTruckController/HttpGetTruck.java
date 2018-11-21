package com.example.pajama.trackfoodtruck.httpTruckController;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.example.pajama.trackfoodtruck.Data.FoodTruck;

import android.os.AsyncTask;
import android.util.Log;

public class HttpGetTruck extends AsyncTask<Void, Void, FoodTruck> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected FoodTruck doInBackground(Void... arg) {
		final String url = "http://192.168.1.110:8080/tft/foodtruck"; // the  url from where to fetch data(json)
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate.getForObject(url, FoodTruck.class);
    }

    @Override
    protected void onPostExecute(FoodTruck foodTruck) {
        Log.e("FoodTruck get log:", foodTruck.toString());
        super.onPostExecute(foodTruck);
    }
}
