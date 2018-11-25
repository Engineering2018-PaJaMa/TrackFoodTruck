package com.example.pajama.trackfoodtruck.Activities;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import com.example.pajama.trackfoodtruck.Data.Review;
import com.example.pajama.trackfoodtruck.ListAdapter.ReviewListAdapter;
import com.example.pajama.trackfoodtruck.R;
import com.example.pajama.trackfoodtruck.httpReviewsController.HttpGetReviews;
import com.example.pajama.trackfoodtruck.httpTruckController.HttpGetTruck;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

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
		reviewsProcess.execute("foodTruckName");

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

		HttpGetTruck truckProcess = new HttpGetTruck();
		truckProcess.execute("foodTruckName");

		TextView nameTextField = findViewById(R.id.detailDateTextView);
		TextView cuisineTextField = findViewById(R.id.foodTruckFoodTypetextView);
		TextView descriptionTextField = findViewById(R.id.foodTruckDescriptiontextView);
		RatingBar ratingBar = findViewById(R.id.foodTruckDetailsratingBar);

		try
		{
			Log.e("qqqqqqqqqqqq", truckProcess.get().getName());
			nameTextField.setText(truckProcess.get().getName());
			cuisineTextField.setText(truckProcess.get().getCuisine());
			descriptionTextField.setText(truckProcess.get().getDescription());
			ratingBar.setRating(truckProcess.get().getRating().floatValue());
		}
		catch (ExecutionException | InterruptedException e)
		{
			Log.e("Error", "Error with reading truck info");
		}

		Toolbar myToolbar = findViewById(R.id.ActivityToolbar);
		setSupportActionBar(myToolbar);
		Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

		myToolbar.setNavigationIcon(R.drawable.ic_backbutton);

		myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(),WelcomeActivity.class));
			}
		});

		ReviewListAdapter reviewListAdapter = new ReviewListAdapter(this, dateArray, authorArray, reviewArray);
		listView = (ListView) findViewById(R.id.reviewsList);
		listView.setAdapter(reviewListAdapter);

		Button clickButton = (Button) findViewById(R.id.addOpinionButton);
		clickButton.setOnClickListener( new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                addOpinion();
			}
		});
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



	public void addOpinion() {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Add Opinion");

		// Set up the input
		final EditText input = new EditText(this);
		// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
		input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);
		builder.setView(input);

		// Set up the buttons
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				String m_Text = input.getText().toString();
			}
		});
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});

		builder.show();
	}

}
