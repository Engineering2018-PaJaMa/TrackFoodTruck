package com.example.pajama.trackfoodtruck.Activities;

import com.example.pajama.trackfoodtruck.ListAdapter.ReviewListAdapter;
import com.example.pajama.trackfoodtruck.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DetailsActivity extends AppCompatActivity
{

	String[] dateArray = {"13 Lipca","23 Lutego","15 Sierpnia","5 Stycznia"};

	String[] authorArray = {
			"Bradley Henderson",
			"Efe Peck",
			"Melanie Nolan",
			"Jamie-Lee Rennie"
	};

	String[] reviewArray = {
			"Wow",
			"Delicious in rolls",
			"Great",
			"Nice"
	};
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		ReviewListAdapter reviewListAdapter = new ReviewListAdapter(this, dateArray, authorArray, reviewArray);
		listView = (ListView) findViewById(R.id.reviewsList);
		listView.setAdapter(reviewListAdapter);
	}

}
