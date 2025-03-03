package com.atoballesterosbaluyangravidez.studybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ListOfProfessionals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofprofessionals);

        ImageView arrowLeft = findViewById(R.id.arrowleft);
        ImageView continueButton = findViewById(R.id.continuebutton);

        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListOfProfessionals.this, TypeOfProfessional.class);
                startActivity(intent);
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListOfProfessionals.this, Professional.class);
                startActivity(intent);
            }
        });
    }
}