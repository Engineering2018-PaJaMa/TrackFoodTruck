package com.example.pajama.trackfoodtruck.httpUserController;

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
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.pajama.trackfoodtruck.Data.User;

import android.os.AsyncTask;
import android.util.Log;

public class HttpGetUser extends AsyncTask<String, Void, User>
{

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
	protected User doInBackground(String... arg)
	{
		final String url = "http://212.191.92.88:51110/tft/user"; // the  url from where to fetch data(json) ip kompa

		RestTemplate restTemplate = new RestTemplate();

		JSONObject newUser = null;
		try
		{
			if (arg.length == 1)
			{
				newUser = new JSONObject().put("email", arg[0]);
			}
			else
			{
				newUser = new JSONObject().put("password", arg[1]).put("email", arg[0]);
			}
		}
		catch (JSONException e)
		{
			Log.e("Error", "Problem with getting user");
		}

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(new MediaType("application", "json"));
		HttpEntity<String> requestEntity = new HttpEntity<>(newUser.toString(),requestHeaders);

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new FormHttpMessageConverter());
		messageConverters.add(new StringHttpMessageConverter());
		messageConverters.add(new MappingJackson2HttpMessageConverter());

		restTemplate.setMessageConverters(messageConverters);

		try
		{
			return restTemplate.postForObject(url, requestEntity, User.class);
		}
		catch (HttpServerErrorException e)
		{
			Log.e("FoodTruck Server ERROR", e.toString());
			User errMsg = new User();
			errMsg.setErrorMsg(500);
			return errMsg;
		}
    }

    @Override
    protected void onPostExecute(User user) {
        Log.e("User get log:", user.toString());
        super.onPostExecute(user);
    }
}
