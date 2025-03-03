package com.atoballesterosbaluyangravidez.studybuddy;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class BookAnAppointment extends AppCompatActivity {

    private ImageView arrowLeft;
    private TextView name, specialty, fee, selectDate, selectTime;
    private Button bookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookanappointment);

        arrowLeft = findViewById(R.id.arrowleft);
        name = findViewById(R.id.name);
        specialty = findViewById(R.id.specialty2);
        fee = findViewById(R.id.fee);
        bookButton = findViewById(R.id.bookbutton);
        selectDate = findViewById(R.id.selectdate);
        selectTime = findViewById(R.id.selecttime);

        arrowLeft.setOnClickListener(v -> {
            Intent intent = new Intent(BookAnAppointment.this, ListOfProfessionals.class);
            startActivity(intent);
        });

        bookButton.setOnClickListener(v -> {
            Intent intent = new Intent(BookAnAppointment.this, TypeOfProfessional.class);
            startActivity(intent);
        });

        findViewById(R.id.datepicker).setOnClickListener(v -> openDatePicker());

        findViewById(R.id.timepicker).setOnClickListener(v -> openTimePicker());
    }

    private void openDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, selectedYear, selectedMonth, selectedDay) -> {
            String selectedDateStr = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
            selectDate.setText(selectedDateStr);
        }, year, month, day);

        datePickerDialog.show();
    }

    private void openTimePicker() {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view, selectedHour, selectedMinute) -> {
            String selectedTimeStr = String.format("%02d:%02d", selectedHour, selectedMinute);
            selectTime.setText(selectedTimeStr);
        }, hour, minute, true);

        timePickerDialog.show();
    }
}