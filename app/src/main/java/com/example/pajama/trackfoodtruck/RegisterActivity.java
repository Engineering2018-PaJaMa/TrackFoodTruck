package com.example.pajama.trackfoodtruck;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
		final EditText name = findViewById(R.id.nameEditText);
		final EditText email = findViewById(R.id.emailEditText);
		final EditText password = findViewById(R.id.passwordEditText);
		final EditText repeatPassword = findViewById(R.id.repeatPasswordEditText);

		if (validateName(name) && validateEmail(email) && validatePassword(password, repeatPassword)) {
			register(name.getText().toString(), email.getText().toString(), password.getText().toString(), repeatPassword.getText().toString());
		}
	}

	private boolean validateName(EditText name) {
		String nameInput = name.getText().toString();

		if (nameInput.isEmpty()) {
			name.setError("Name cannot be empty");
			return false;
		} else {
			return true;
		}
	}

	private boolean validatePassword(EditText password, EditText repeatPassword) {
		String passwordInput = password.getText().toString();
		String repeatPasswordInput = repeatPassword.getText().toString();

		if (passwordInput.isEmpty()) {
			password.setError("Password cannot be empty");
			return false;
		}
		else if (passwordInput.equals(repeatPasswordInput)) {
			return true;
		} else {
			password.setError("Password need to be the same");
			return false;
		}
	}

	private boolean validateEmail(EditText email) {
		String emailInput = email.getText().toString().trim();

		if (emailInput.isEmpty()) {
			email.setError("Field can't be empty");
			return false;
		} else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
			email.setError("Please enter a valid email");
			return false;
		} else {
			email.setError(null);
			return true;
		}
	}

	private void register(String name, String email, String password, String repeatPassword) {
		JSONObject register = new JSONObject();
		try {
			register.put("name", name);
			register.put("email", email);
			register.put("password", password);
			register.put("repeatPassword", repeatPassword);
			new JsonRequest(RegisterActivity.this).execute("http://10.0.2.2:8080/tft/user/", register.toString());
			Toast.makeText(RegisterActivity.this, register.toString(), Toast.LENGTH_LONG).show();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
