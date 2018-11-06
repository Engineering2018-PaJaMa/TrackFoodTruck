package com.example.pajama.trackfoodtruck.Activities;

import com.example.pajama.trackfoodtruck.R;
import com.example.pajama.trackfoodtruck.api.HttpHandler;

import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity
{

	TextView userIdTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);

		Toolbar myToolbar = (Toolbar) findViewById(R.id.WelcomeActivityToolbar);
		setSupportActionBar(myToolbar);
		getSupportActionBar().setDisplayShowTitleEnabled(false);

		//userIdTextView = findViewById(R.id.userResponseTextView);
		new User().execute();
		createTable();
	}


	public void createTable()
	{

	}

	private class User extends AsyncTask<Void, Void, Void>
	{

		String jsonStr;

		@Override
		protected void onPreExecute()
		{
			super.onPreExecute();
			Toast.makeText(WelcomeActivity.this, "Json Data is downloading", Toast.LENGTH_LONG).show();
		}

		@Override
		protected Void doInBackground(Void... arg0)
		{
			final HttpHandler httpHandler = new HttpHandler();
			//            final String url = "http://127.0.0.1:8080/tft/user/1";    //Testing on device
			final String url = "http://10.0.2.2:8080/tft/user/1";       //Testing on emulator since emulator has its own localhost we need to redirect it to our backend localhost.
			jsonStr = httpHandler.makeServiceCall(url);
			return null;
		}

		@Override
		protected void onPostExecute(Void result)
		{
			super.onPostExecute(result);
			//userIdTextView.setText(jsonStr);
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
			case R.id.action_favourite:

				return true;

			default:

				return super.onOptionsItemSelected(item);

		}
	}
}
