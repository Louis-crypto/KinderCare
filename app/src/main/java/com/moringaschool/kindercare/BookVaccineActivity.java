package com.moringaschool.kindercare;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class BookVaccineActivity extends AppCompatActivity {

    EditText appointmentPicker;
    EditText timePicker;
    TimePickerDialog timePickerDialog;
    DatePickerDialog.OnDateSetListener setListener;
    private Button bookAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_vaccine);

        appointmentPicker = findViewById(R.id.appointmentDatePicker);
        timePicker = findViewById(R.id.timePicker);
        bookAppointment = findViewById(R.id.bookAppointmentButton);


        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog = new TimePickerDialog(BookVaccineActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timePicker.setText(hourOfDay + ":" + minute);
                    }
                }, 0, 0, false);
                timePickerDialog.show();
            }
        });

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        appointmentPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(BookVaccineActivity.this, android.R.style.Widget_Holo_Light_ActionBar
                , setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1 ;
                String date = day+"/"+month+"/"+year;
                appointmentPicker.setText(date);
            }
        };

        appointmentPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        BookVaccineActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day+"/"+month+"/"+year;
                        appointmentPicker.setText(date);
                    }
                } ,year, month, day);
                datePickerDialog.show();
            }
        });

        bookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = appointmentPicker.getText().toString();
                String time = timePicker.getText().toString();
                Intent intent = new Intent(BookVaccineActivity.this,ShowAppontmentActivity.class);
                intent.putExtra("keydate", date);
                intent.putExtra("keytime", time);
                startActivity(intent);
            }
        });
    }
}