package com.example.pajama.trackfoodtruck.httpReviewsController;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.example.pajama.trackfoodtruck.Data.Review;

import android.os.AsyncTask;

public class HttpGetReviews extends AsyncTask<Void, Void, Review> {
	private HttpReviewsIntrface httpReviewsIntreface;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Review doInBackground(Void... arg) {
        final String url = "http://192.168.1.110:8080/tft/review/" + arg[0]; // the  url from where to fetch data(json) ip kompa
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate.getForObject(url, Review.class);
    }

    @Override
    protected void onPostExecute(Review review) {
        httpReviewsIntreface.getReviews(review);
        super.onPostExecute(review);
    }
}
