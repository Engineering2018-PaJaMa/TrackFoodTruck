package com.example.pajama.trackfoodtruck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView emailForm, passwordForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
    }

    public void initLayout(){
        emailForm = findViewById(R.id.loginEmail);
        passwordForm = findViewById(R.id.loginPassword);
    }

    public void logIn(View view)
    {
        String email = emailForm.getText().toString();
        String password = passwordForm.getText().toString();
        Log.i("Email: ", email);
        Log.i(  " Password: ", password);
        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void register(View view)
    {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
