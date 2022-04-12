package com.moringaschool.kindercare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kinder-care-4c374-default-rtdb.firebaseio.com");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText guardianPhone = findViewById(R.id.babyEmail);
        final EditText loginpassword = findViewById(R.id.babyPassword);
        final Button loginButton = findViewById(R.id.loginButton);
        final TextView createAccount = findViewById(R.id.dontHaveAccount);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String guardianPhoneText = guardianPhone.getText().toString();
                final String userPassword = loginpassword.getText().toString();

                if(guardianPhoneText.isEmpty() || userPassword.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please enter email or password", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(guardianPhoneText)){
                                final String getPassword = snapshot.child(guardianPhoneText).child("password").getValue(String.class);

                                if(getPassword.equals(userPassword)){
                                    Toast.makeText(LoginActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this, ViewAllVaccinesActivity.class));
                                }else{
                                    Toast.makeText(LoginActivity.this, "Wrong password! try again", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(LoginActivity.this, "You have entered wrong phone number", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });

    }


}