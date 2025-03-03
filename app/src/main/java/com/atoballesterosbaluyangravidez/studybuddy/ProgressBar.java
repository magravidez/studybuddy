package com.atoballesterosbaluyangravidez.studybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ProgressBar extends AppCompatActivity {

    private android.widget.ProgressBar progressBar;
    private ImageView completeImage, continueButton;
    private TextView message1, message2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar);

        progressBar = findViewById(R.id.progressBar);
        completeImage = new ImageView(this);
        completeImage.setImageResource(R.drawable.complete);
        message1 = findViewById(R.id.message);
        message2 = findViewById(R.id.message2);
        continueButton = findViewById(R.id.continuebutton);
        continueButton.setVisibility(View.GONE);

        new Handler().postDelayed(() -> {
            progressBar.setVisibility(View.GONE);

            message1.setVisibility(View.GONE);

            message2.setText("Search complete!\n Here are your best matches.");

            completeImage.setLayoutParams(progressBar.getLayoutParams());
            ((ConstraintLayout) progressBar.getParent()).addView(completeImage);

            continueButton.setVisibility(View.VISIBLE);

        }, 3000);

        continueButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProgressBar.this, ListOfProfessionals.class);
            startActivity(intent);
            finish();
        });
    }
}