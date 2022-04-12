package com.moringaschool.kindercare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText email = findViewById(R.id.babyEmail);
        final EditText password = findViewById(R.id.babyPassword);
        final Button login = findViewById(R.id.loginButton);
        final TextView createAccount = findViewById(R.id.dontHaveAccount);


    }
}