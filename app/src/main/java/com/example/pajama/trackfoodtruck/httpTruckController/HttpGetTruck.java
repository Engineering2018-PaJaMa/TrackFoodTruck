package com.example.pajama.trackfoodtruck.httpTruckController;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.example.pajama.trackfoodtruck.Data.FoodTruck;

import android.os.AsyncTask;
import android.util.Log;

public class HttpGetTruck extends AsyncTask<String, Void, FoodTruck>
{

	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();
	}

	@Override
	protected FoodTruck doInBackground(String... arg)
	{
		final String url = "http://212.191.92.88:51110/tft/foodtruck"; // the  url from where to fetch data(json) ip kompa
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		JSONObject newFoodTruck = null;
		try
		{
			newFoodTruck = new JSONObject().put("name", arg[0]);
		}
		catch (JSONException e)
		{
			Log.e("Error", "Problem with getting foodtruck");
		}

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(new MediaType("application", "json"));
		HttpEntity<String> requestEntity = new HttpEntity<>(newFoodTruck.toString(), requestHeaders);

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new FormHttpMessageConverter());
		messageConverters.add(new StringHttpMessageConverter());
		messageConverters.add(new MappingJackson2HttpMessageConverter());

		restTemplate.setMessageConverters(messageConverters);

		return restTemplate.postForObject(url, requestEntity, FoodTruck.class);
	}

	@Override
	protected void onPostExecute(FoodTruck foodTruck)
	{
		Log.e("Truck get log:", foodTruck.toString());
		super.onPostExecute(foodTruck);
	}
}
