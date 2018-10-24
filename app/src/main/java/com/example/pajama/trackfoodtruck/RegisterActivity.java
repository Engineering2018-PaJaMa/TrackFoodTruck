package com.example.pajama.trackfoodtruck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RegisterActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
	}

	public void registerUser(View view)
	{
		Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
		startActivity(intent);
	}
}
