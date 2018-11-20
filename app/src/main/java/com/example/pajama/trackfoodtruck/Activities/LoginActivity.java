package com.example.pajama.trackfoodtruck.Activities;

import com.example.pajama.trackfoodtruck.R;
import com.example.pajama.trackfoodtruck.httpUserController.HttpPutUser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity
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
        //new HttpPutUser().execute("001", "UserZTel", "pass", "test", "test", "test", "1");
		Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
		startActivity(intent);
	}

	public void goToRegisterActivity(View view)
	{
		Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
		startActivity(intent);
	}
}
