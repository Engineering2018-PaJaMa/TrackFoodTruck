package com.example.pajama.trackfoodtruck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity
{

	TextView emailForm;
	TextView passwordForm;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initLayout();
	}

	public void initLayout()
	{
		emailForm = findViewById(R.id.loginEmail);
		passwordForm = findViewById(R.id.loginPassword);
	}

	public void goTologinActivity(View view)
	{
		String email = emailForm.getText().toString();
		String password = passwordForm.getText().toString();
		Log.i("Email: ", email);
		Log.i(" Password: ", password);
		Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);

		JSONObject login = new JSONObject();
		try {
			login.put("email", email);
			login.put("password", password);
		}
		catch (JSONException e) {
			e.printStackTrace();
		}

		Toast.makeText(MainActivity.this, login.toString(), Toast.LENGTH_LONG).show();

		startActivity(intent);
	}

	public void goToRegisterActivity(View view)
	{
		Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
		startActivity(intent);
	}
}
