package com.example.pajama.trackfoodtruck.Activities;

import java.util.Objects;

import com.example.pajama.trackfoodtruck.Fragments.FavouriteFragment;
import com.example.pajama.trackfoodtruck.Fragments.HomeFragment;
import com.example.pajama.trackfoodtruck.Fragments.MapFragment;
import com.example.pajama.trackfoodtruck.R;

import android.content.Intent;
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
			MapFragment mapFragment;

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
					startActivity(new Intent(WelcomeActivity.this, MapFragment.class));
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
