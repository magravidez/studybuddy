package com.atoballesterosbaluyangravidez.studybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TypeOfProfessional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.typeofprofessional);

        TextView nameGoesHere = findViewById(R.id.namegoeshere);
        ImageView doctorCard = findViewById(R.id.doctorcard);
        ImageView gramCard = findViewById(R.id.gramcard);
        ImageView mathCard = findViewById(R.id.mathcard);
        ImageView psyCard = findViewById(R.id.psycard);
        ImageView sciCard = findViewById(R.id.scicard);
        
        View.OnClickListener navigateToSessionType = view -> {
            Intent intent = new Intent(TypeOfProfessional.this, SessionType.class);
            startActivity(intent);
        };

        doctorCard.setOnClickListener(navigateToSessionType);
        gramCard.setOnClickListener(navigateToSessionType);
        mathCard.setOnClickListener(navigateToSessionType);
        psyCard.setOnClickListener(navigateToSessionType);
        sciCard.setOnClickListener(navigateToSessionType);
    }
}