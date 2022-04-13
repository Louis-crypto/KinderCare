package com.moringaschool.kindercare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShowAppontmentActivity extends AppCompatActivity {

    private TextView showDate, showTime;
    private Button confirmAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_appontment);

        showDate = findViewById(R.id.dateSelected);
        showTime = findViewById(R.id.timeSelected);
        confirmAppointment = findViewById(R.id.confirmAppointmentButton);

        String pickedDate = getIntent().getStringExtra("keydate");
        String pickedTime = getIntent().getStringExtra("keytime");

        showDate.setText("Your appointment is on " + pickedDate);
        showTime.setText("At " + pickedTime);

        confirmAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShowAppontmentActivity.this, "We are looking forward to seeing you", Toast.LENGTH_LONG).show();
                startActivity(new Intent(ShowAppontmentActivity.this, ViewAllVaccinesActivity.class));
            }
        });
    }
}