package com.example.pajama.trackfoodtruck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

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
		JSONObject register = new JSONObject();
		final EditText name = findViewById(R.id.nameEditText);
		final EditText email = findViewById(R.id.emailEditText);
		final EditText password = findViewById(R.id.passwordEditText);
		final EditText repeatPassword = findViewById(R.id.repeatPasswordEditText);

		if(!password.getText().toString().equals(repeatPassword.getText().toString())) {
			Toast.makeText(RegisterActivity.this, "Passowrd doesn't match", Toast.LENGTH_LONG).show();
		}
		else {

			try {
				register.put("name", name.getText().toString());
				register.put("email", email.getText().toString());
				register.put("password", password.getText().toString());
				register.put("repeatPassword", repeatPassword.getText().toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}

			Toast.makeText(RegisterActivity.this, register.toString(), Toast.LENGTH_LONG).show();
			startActivity(intent);
		}
	}
}
