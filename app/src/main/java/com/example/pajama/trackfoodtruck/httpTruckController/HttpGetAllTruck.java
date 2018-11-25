package com.example.pajama.trackfoodtruck.httpTruckController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.example.pajama.trackfoodtruck.Data.FoodTruck;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		ObjectMapper mapper = new ObjectMapper();
		HttpHeaders requestHeaders = new HttpHeaders();

		requestHeaders.setContentType(new MediaType("application", "json"));

		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		return mapper.convertValue(restTemplate.getForObject(url, ArrayList.class, requestHeaders), new TypeReference<List<FoodTruck>>()
		{
		});
	}

	@Override
	protected void onPostExecute(List foodTrucks)
	{
		Log.e("AllFoodTrucks get log:", foodTrucks.toString());
		super.onPostExecute(foodTrucks);
	}
}
