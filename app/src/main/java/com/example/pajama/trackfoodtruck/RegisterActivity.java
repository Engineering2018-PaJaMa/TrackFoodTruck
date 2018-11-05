package com.example.pajama.trackfoodtruck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;

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

		if (validateName(name) && validateEmail(email) && validatePassword(password, repeatPassword)) {

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
		} else {

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
}
