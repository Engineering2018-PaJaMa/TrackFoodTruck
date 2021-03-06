package com.example.pajama.trackfoodtruck.Activities;

import java.util.Objects;

import com.example.pajama.trackfoodtruck.Data.ApplicationData;
import com.example.pajama.trackfoodtruck.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);

		Toolbar myToolbar = findViewById(R.id.include);
		setSupportActionBar(myToolbar);
		Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

		myToolbar.setNavigationIcon(R.drawable.ic_backbutton);

		Button logOut = findViewById(R.id.logOutButton);
		logOut.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
				ApplicationData.trackForMap = null;
				ApplicationData.choosenTrack = null;
				startActivity(intent);
			}
		});

		myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(),WelcomeActivity.class));
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

				Intent intent = new Intent(SettingsActivity.this, WelcomeActivity.class);
				startActivity(intent);
				return true;

			default:

				return super.onOptionsItemSelected(item);

		}
	}
}
