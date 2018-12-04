package com.example.pajama.trackfoodtruck.httpUserController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.example.pajama.trackfoodtruck.Data.User;
import com.example.pajama.trackfoodtruck.Data.UserProperties;

import android.os.AsyncTask;

public class HttpDeleteFavourite extends AsyncTask<String, Void, Boolean>
{

	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();
	}

	@Override
	protected Boolean doInBackground(String... arg)
	{
		final String url = "http://212.191.92.88:51110/tft/user/favourites"; // the  url from where to fetch data(json)
		RestTemplate restTemplate = new RestTemplate(new SimpleClientHttpRequestFactory());
		HttpHeaders requestHeaders = new HttpHeaders();

		requestHeaders.setContentType(new MediaType("application", "json"));

		List<String> tmpList = new ArrayList<>();
		tmpList.add(arg[1]);

		UserProperties delFavFoodTrack = new UserProperties();
		delFavFoodTrack.setName(arg[0]);
		delFavFoodTrack.setFavouriteFoodTrucks(tmpList);

		HttpEntity<UserProperties> entity = new HttpEntity<>(delFavFoodTrack, requestHeaders);

		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		//restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

		restTemplate.exchange(url, HttpMethod.DELETE, entity, User.class);
		return true;
	}

	@Override
	protected void onPostExecute(Boolean result)
	{
		super.onPostExecute(result);
	}
}
