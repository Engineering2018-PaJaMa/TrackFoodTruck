package com.example.pajama.trackfoodtruck.Activities;

import org.springframework.web.client.RestTemplate;

import com.example.pajama.trackfoodtruck.Data.RegisterMessage;
import com.example.pajama.trackfoodtruck.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity
{

	TextView name, email, password, repeatPassword;
	RegisterMessage registerMessage = new RegisterMessage();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		initLayout();
	}

	public void initLayout()
	{
		name = findViewById(R.id.nameEditText);
		email = findViewById(R.id.emailEditText);
		password = findViewById(R.id.passwordEditText);
		repeatPassword = findViewById(R.id.repeatPasswordEditText);
	}

	public void registerUser()
	{
		registerMessage.setName(name.getText().toString());
		registerMessage.setEmail(email.getText().toString());
		registerMessage.setPassword(password.getText().toString());
		registerMessage.setRepeatPassword(repeatPassword.getText().toString());

		RestTemplate restTemplate = new RestTemplate();

		String url = "212.191.92.88:51110/tft/user/register";
		//String response = restTemplate.postForObject(url, registerMessage, String.class);

	}

	public void goToHomeActivity(View view)
	{
		registerUser();
		Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
		startActivity(intent);
	}
}
