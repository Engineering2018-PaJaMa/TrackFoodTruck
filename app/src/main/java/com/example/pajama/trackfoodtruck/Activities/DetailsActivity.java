package com.example.pajama.trackfoodtruck.Activities;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.example.pajama.trackfoodtruck.Data.Review;
import com.example.pajama.trackfoodtruck.ListAdapter.ReviewListAdapter;
import com.example.pajama.trackfoodtruck.R;
import com.example.pajama.trackfoodtruck.httpReviewsController.HttpGetReviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

public class DetailsActivity extends AppCompatActivity
{

	ArrayList<String> dateArray = new ArrayList<>();
	ArrayList<String> authorArray = new ArrayList<>();
	ArrayList<String> reviewArray = new ArrayList<>();
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		HttpGetReviews reviewsProcess = new HttpGetReviews();
		reviewsProcess.execute();

		try
		{
			for (Review review : reviewsProcess.get())
			{
				authorArray.add(review.getAuthor());
				reviewArray.add(review.getBody());
				dateArray.add(review.getRating().toString());
			}
		}
		catch (ExecutionException | InterruptedException e)
		{
			Log.e("Error", "Error with reading reviews");
		}
		ReviewListAdapter reviewListAdapter = new ReviewListAdapter(this, dateArray, authorArray, reviewArray);
		listView = (ListView) findViewById(R.id.reviewsList);
		listView.setAdapter(reviewListAdapter);
	}

}
