package com.example.pajama.trackfoodtruck.Activities;

import java.util.Objects;

import com.example.pajama.trackfoodtruck.ListAdapter.ReviewListAdapter;
import com.example.pajama.trackfoodtruck.R;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

		Toolbar myToolbar = findViewById(R.id.ActivityToolbar);
		setSupportActionBar(myToolbar);
		Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

		ReviewListAdapter reviewListAdapter = new ReviewListAdapter(this, dateArray, authorArray, reviewArray);
		listView = (ListView) findViewById(R.id.reviewsList);
		listView.setAdapter(reviewListAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_settings:

				Intent intent = new Intent(DetailsActivity.this, SettingsActivity.class);
				startActivity(intent);
				return true;

			default:

				return super.onOptionsItemSelected(item);

		}
	}

}
