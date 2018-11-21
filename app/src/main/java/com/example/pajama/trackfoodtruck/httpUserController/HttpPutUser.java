package com.example.pajama.trackfoodtruck.httpUserController;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.example.pajama.trackfoodtruck.Data.User;

import android.os.AsyncTask;
import android.util.Log;

public class HttpPutUser extends AsyncTask<String, Void, Boolean>
{

	@Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
	protected Boolean doInBackground(String... arg)
	{
        final String url = "http://192.168.1.110:8080/tft/user"; // the  url from where to fetch data(json)
        RestTemplate restTemplate = new RestTemplate(true);

        User newUser = new User();
        newUser.setLogin(arg[0]);
        newUser.setEmail(arg[1]);
        newUser.setPassword(arg[2]);
        newUser.setRepPassword(arg[3]);
       

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        HttpEntity<User> requestEntity = new HttpEntity<>(newUser, requestHeaders);

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        Log.e("User send log: ", result);

		return true;
    }

	@Override
	protected void onPostExecute(Boolean result)
	{
		super.onPostExecute(result);
    }
}