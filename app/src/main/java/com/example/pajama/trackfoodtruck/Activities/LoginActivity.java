package com.example.pajama.trackfoodtruck.Activities;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.example.pajama.trackfoodtruck.R;
import com.example.pajama.trackfoodtruck.httpUserController.HttpGetUser;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements ResponseErrorHandler
{

	TextView emailForm;
	TextView passwordForm;
	public static String currentLogInUser;
	public static String currentUserEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initLayout();
	}

	public void initLayout()
	{
		emailForm = findViewById(R.id.loginEmail);
		passwordForm = findViewById(R.id.loginPassword);
	}

	public void goTologinActivity(View view) throws ExecutionException, InterruptedException
	{
		String email = emailForm.getText().toString();
		String password = passwordForm.getText().toString();
		Log.i("Email: ", email);
		Log.i(" Password: ", password);

		HttpGetUser userProcess = new HttpGetUser();

		if (userProcess.execute(email, password).get().getErrorMsg().equals(500))
		{
			Toast.makeText(getApplicationContext(), "Can't find such user", Toast.LENGTH_SHORT).show();
		}
		else
		{
			currentLogInUser = userProcess.get().getLogin();
			currentUserEmail = userProcess.get().getEmail();
			Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
			startActivity(intent);
		}
	}

	public void goToRegisterActivity(View view)
	{
		Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException
	{
		return (response.getStatusCode().series() == CLIENT_ERROR || response.getStatusCode().series() == SERVER_ERROR);
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException
	{
		if (response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR)
		{
			// handle SERVER_ERROR

		}
		else if (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR)
		{
			// handle CLIENT_ERROR
			if (response.getStatusCode() == HttpStatus.NOT_FOUND)
			{
				throw new Resources.NotFoundException();
			}
		}
	}

}
