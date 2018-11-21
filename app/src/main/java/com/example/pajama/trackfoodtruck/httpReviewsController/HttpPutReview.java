package com.example.pajama.trackfoodtruck.httpReviewsController;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.example.pajama.trackfoodtruck.Data.Review;

import android.os.AsyncTask;
import android.util.Log;

public class HttpPutReview extends AsyncTask<String, Void, Boolean>
{

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

	@Override
	protected Boolean doInBackground(String... arg)
	{
        final String url = "http://192.168.1.110:8080/tft/review/" + arg[0]; // the  url from where to fetch data(json)
        RestTemplate restTemplate = new RestTemplate(true);

        Review newReview = new Review();
        newReview.setHeadline(arg[1]);
        newReview.setBody(arg[2]);
        newReview.setRating(Double.parseDouble(arg[3]));
        newReview.setAuthorName(arg[4]);

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        HttpEntity<Review> requestEntity = new HttpEntity<>(newReview, requestHeaders);

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        Log.e("Review send log:", result);

		return true;
    }

    @Override
	protected void onPostExecute(Boolean result)
	{
        super.onPostExecute(result);
    }
}
