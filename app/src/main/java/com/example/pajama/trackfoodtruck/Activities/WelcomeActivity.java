package com.example.pajama.trackfoodtruck.Activities;

import java.util.Objects;

import com.example.pajama.trackfoodtruck.Fragments.FavouriteFragment;
import com.example.pajama.trackfoodtruck.Fragments.HomeFragment;
import com.example.pajama.trackfoodtruck.Fragments.MapFragment;
import com.example.pajama.trackfoodtruck.R;
import com.example.pajama.trackfoodtruck.api.HttpHandler;
import com.example.pajama.trackfoodtruck.userData.User;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class WelcomeActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);

		Toolbar myToolbar = findViewById(R.id.ActivityToolbar);
		setSupportActionBar(myToolbar);
		Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
		BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
		bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

		loadFragment(new HomeFragment());
		new HttpRequestTask().execute();
	}

	private class HttpRequestTask extends AsyncTask<Void, Void, User>
	{

		@Override
		protected void onPreExecute()
		{
			super.onPreExecute();
			Toast.makeText(WelcomeActivity.this, "Json Data is downloading", Toast.LENGTH_LONG).show();
		}

		@Override
		protected User doInBackground(Void... arg0) {
			final String url = "http://192.168.1.110:8080/tft/user/1"; // the  url from where to fetch data(json)
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

			return restTemplate.getForObject(url, User.class);
		}

		@Override
		protected void onPostExecute(User user) {
			TextView infoIdText = (TextView) findViewById(R.id.example_user);
			infoIdText.setText(user.getUsername());
		}
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

				Intent intent = new Intent(WelcomeActivity.this, SettingsActivity.class);
				startActivity(intent);
				return true;

			default:

				return super.onOptionsItemSelected(item);

		}
	}
	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
			= new BottomNavigationView.OnNavigationItemSelectedListener() {

		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {

			Fragment fragment;

			switch (item.getItemId()) {
				case R.id.navigation_home:
					fragment = new HomeFragment();
					loadFragment(fragment);
					return true;
				case R.id.navigation_favourite:
					fragment = new FavouriteFragment();
					loadFragment(fragment);
					return true;
				case R.id.navigation_map:
					fragment = new MapFragment();
					loadFragment(fragment);
					return true;
			}

			return false;
		}
	};

	private void loadFragment(Fragment fragment) {
		// load fragment
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.container, fragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}

}
