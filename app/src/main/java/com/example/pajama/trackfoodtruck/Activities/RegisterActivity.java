package com.example.pajama.trackfoodtruck.Activities;

import java.util.concurrent.ExecutionException;

import com.example.pajama.trackfoodtruck.R;
import com.example.pajama.trackfoodtruck.httpUserController.HttpPutUser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity
{

    TextView name, email, password, repeatPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initLayout();
    }

    public void initLayout() {
        name = findViewById(R.id.nameEditText);
        email = findViewById(R.id.emailEditText);
        password = findViewById(R.id.passwordEditText);
        repeatPassword = findViewById(R.id.repeatPasswordEditText);
    }

	public void registerUser(View view) throws ExecutionException, InterruptedException
	{
		HttpPutUser userToSend = new HttpPutUser();
		userToSend.execute(
                name.getText().toString(),
                email.getText().toString(),
                password.getText().toString(),
                repeatPassword.getText().toString());
		if (userToSend.get())
		{
			Log.e("TEST", "Sending data complete");
			Toast.makeText(getApplicationContext(), "Sending data complete", Toast.LENGTH_LONG).show();
		}

		Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
		startActivity(intent);
	}

}
