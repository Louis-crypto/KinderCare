package com.moringaschool.kindercare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class SignupActivity extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kinder-care-4c374-default-rtdb.firebaseio.com");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText fullName = findViewById(R.id.registerBabyName);
        final EditText registerEmail = findViewById(R.id.registerBabyEmail);
        final EditText guardianPhone = findViewById(R.id.registerBabyPhone);
        final EditText registerPassword = findViewById(R.id.registerBabyPassword);
        final Button createAccountButton = findViewById(R.id.buttonCreateAccount);
        final TextView goToLogin = findViewById(R.id.alreadyHaveAccount);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String fullNameText = fullName.getText().toString();
                final String emailText = registerEmail.getText().toString();
                final String guardianPhoneText = guardianPhone.getText().toString();
                final String passwordText = registerPassword.getText().toString();

                if(fullNameText.isEmpty() || emailText.isEmpty() || guardianPhoneText.isEmpty() || passwordText.isEmpty()){
                    Toast.makeText(SignupActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else if(guardianPhoneText.length() > 10){
                    Toast.makeText(SignupActivity.this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(guardianPhoneText)){
                                Toast.makeText(SignupActivity.this, "Phone number already registered", Toast.LENGTH_SHORT).show();
                            }else{
                                databaseReference.child("users").child(guardianPhoneText).child("fullname").setValue(fullNameText);
                                databaseReference.child("users").child(guardianPhoneText).child("email").setValue(emailText);
                                databaseReference.child("users").child(guardianPhoneText).child("password").setValue(passwordText);

                                Toast.makeText(SignupActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}