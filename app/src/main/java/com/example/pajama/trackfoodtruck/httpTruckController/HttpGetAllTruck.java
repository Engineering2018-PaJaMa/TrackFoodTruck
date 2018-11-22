package com.example.pajama.trackfoodtruck.httpTruckController;

import java.util.List;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.example.pajama.trackfoodtruck.Data.FoodTruck;

import android.os.AsyncTask;
import android.util.Log;

public class HttpGetAllTruck extends AsyncTask<Void, Void, List<FoodTruck>>
{

	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();
	}

	@Override
	protected List<FoodTruck> doInBackground(Void... arg)
	{
		final String url = "http://212.191.92.88:51110/tft/foodtruck/all"; // the  url from where to fetch data(json)
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		return restTemplate.getForObject(url, List.class);
	}

	@Override
	protected void onPostExecute(List foodTrucks)
	{
		Log.e("AllFoodTrucks get log:", foodTrucks.toString());
		super.onPostExecute(foodTrucks);
	}
}
