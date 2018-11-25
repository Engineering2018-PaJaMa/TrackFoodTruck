package com.example.pajama.trackfoodtruck.Activities;

import java.util.concurrent.ExecutionException;

import com.example.pajama.trackfoodtruck.R;
import com.example.pajama.trackfoodtruck.httpUserController.HttpGetUser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

	public void goTologinActivity(View view) throws ExecutionException, InterruptedException
	{
		Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
		startActivity(intent);
//		String email = emailForm.getText().toString();
//		String password = passwordForm.getText().toString();
//		Log.i("Email: ", email);
//		Log.i(" Password: ", password);
//		HttpGetUser userProcess = new HttpGetUser();
//		userProcess.execute();
//		if (userProcess.get().getEmail().equals(email) && userProcess.get().getPassword().equals(password))
//		{
//			Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
//			startActivity(intent);
//		}
//		else
//		{
//			Log.e("Fail login", "Wrong data");
//			Toast.makeText(getApplicationContext(), "There is no such user", Toast.LENGTH_LONG).show();
//		}
	}

	public void goToRegisterActivity(View view)
	{
		Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
		startActivity(intent);
	}
}
