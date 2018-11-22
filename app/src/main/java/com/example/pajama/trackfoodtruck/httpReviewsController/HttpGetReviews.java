package com.example.pajama.trackfoodtruck.httpReviewsController;

import java.util.List;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.example.pajama.trackfoodtruck.Data.Review;

import android.os.AsyncTask;

public class HttpGetReviews extends AsyncTask<Void, Void, List<Review>>
{

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
	protected List doInBackground(Void... arg)
	{
		final String url = "http://212.191.92.88:51110/tft/review"; // the  url from where to fetch data(json) ip kompa
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		return restTemplate.getForObject(url, List.class);
    }

    @Override
	protected void onPostExecute(List reviews)
	{
		super.onPostExecute(reviews);
    }
}
