package com.example.pajama.trackfoodtruck.httpReviewsController;

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

import com.example.pajama.trackfoodtruck.Data.Review;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import android.os.AsyncTask;
import android.util.Log;

public class HttpGetReviews extends AsyncTask<String, Void, List<Review>>
{

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
	protected List doInBackground(String... arg)
	{
		final String url = "http://212.191.92.88:51110/tft/review"; // the  url from where to fetch data(json) ip kompa
        RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();

		JSONObject newRestaurant = null;
		try
		{
			newRestaurant = new JSONObject().put("restaurantName", arg[0]);
		}
		catch (JSONException e)
		{
			Log.e("Error", "Problem with getting review");
		}

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(new MediaType("application", "json"));
		HttpEntity<String> requestEntity = new HttpEntity<>(newRestaurant.toString(), requestHeaders);

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new FormHttpMessageConverter());
		messageConverters.add(new StringHttpMessageConverter());
		messageConverters.add(new MappingJackson2HttpMessageConverter());

		restTemplate.setMessageConverters(messageConverters);
		return mapper.convertValue(restTemplate.postForObject(url, requestEntity, ArrayList.class), new TypeReference<List<Review>>()
		{
		});
    }

    @Override
	protected void onPostExecute(List reviews)
	{
		super.onPostExecute(reviews);
    }
}
