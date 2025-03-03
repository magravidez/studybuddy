package com.atoballesterosbaluyangravidez.studybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Professional extends AppCompatActivity {

    private ImageView header, arrowLeft, avatar, phone, check1, check2;
    private TextView professional, name, specialty, specialty2, experience,
            contactDetails, availability, phoneNumber, email, online, f2f, fee;
    private View bookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.professional);

        header = findViewById(R.id.header);
        arrowLeft = findViewById(R.id.arrowleft);
        avatar = findViewById(R.id.avatar);
        phone = findViewById(R.id.phone);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);

        professional = findViewById(R.id.professional);
        name = findViewById(R.id.name);
        specialty = findViewById(R.id.specialty);
        specialty2 = findViewById(R.id.specialty2);
        experience = findViewById(R.id.experienceph);
        contactDetails = findViewById(R.id.contactdetails);
        availability = findViewById(R.id.availability);
        phoneNumber = findViewById(R.id.phonenumber);
        email = findViewById(R.id.email);
        online = findViewById(R.id.online);
        f2f = findViewById(R.id.f2f);
        fee = findViewById(R.id.fee);
        bookButton = findViewById(R.id.bookbutton);


        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Professional.this, TypeOfProfessional.class);
                startActivity(intent);
            }
        });

        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Professional.this, BookAnAppointment.class);
                startActivity(intent);
            }
        });
    }
}