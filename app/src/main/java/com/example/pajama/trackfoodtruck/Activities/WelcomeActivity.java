package com.example.pajama.trackfoodtruck.Activities;

import java.util.Objects;

import com.example.pajama.trackfoodtruck.Data.FoodTruck;
import com.example.pajama.trackfoodtruck.Fragments.FavouriteFragment;
import com.example.pajama.trackfoodtruck.Fragments.HomeFragment;
import com.example.pajama.trackfoodtruck.Fragments.MapFragment;
import com.example.pajama.trackfoodtruck.R;
import com.example.pajama.trackfoodtruck.httpTruckController.HttpTruckInterface;
import com.example.pajama.trackfoodtruck.httpUserController.HttpUserInterface;
import com.example.pajama.trackfoodtruck.httpUserController.HttpGetUser;
import com.example.pajama.trackfoodtruck.Data.User;

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
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity implements HttpUserInterface, HttpTruckInterface
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
        new HttpGetUser().execute();
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

    @Override
    public void httpGetUser(User user) {
        TextView testUser = (TextView) findViewById(R.id.example_user);

        testUser.setText(user.getId());
    }

    @Override
    public void httpPutUser(String info) {

        TextView putOk = (TextView) findViewById(R.id.put_ok);
        putOk.setText(info);
    }

    @Override
    public void getTruck(FoodTruck truck) {

    }
}
