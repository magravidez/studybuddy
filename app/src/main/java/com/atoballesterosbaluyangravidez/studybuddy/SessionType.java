package com.atoballesterosbaluyangravidez.studybuddy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class SessionType extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sessiontype);

        ImageView backButton = findViewById(R.id.arrowleft);
        ImageView continueButton = findViewById(R.id.continuebutton);

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(SessionType.this, TypeOfProfessional.class);
            startActivity(intent);
            finish();
        });

        continueButton.setOnClickListener(v -> {
            Intent intent = new Intent(SessionType.this, Location.class);
            startActivity(intent);
        });

        RadioGroup radioGroup = findViewById(R.id.radiogroup);
        RadioButton radioButton1 = findViewById(R.id.budget1);
        RadioButton radioButton2 = findViewById(R.id.budget2);
        RadioButton radioButton3 = findViewById(R.id.budget3);

        GradientDrawable defaultBorder = new GradientDrawable();
        defaultBorder.setShape(GradientDrawable.RECTANGLE);
        defaultBorder.setCornerRadius(25);
        defaultBorder.setStroke(4, Color.parseColor("#828282"));
        defaultBorder.setColor(Color.TRANSPARENT);

        radioButton1.setBackground(defaultBorder);
        radioButton2.setBackground(defaultBorder);
        radioButton3.setBackground(defaultBorder);
        radioButton1.setButtonTintList(ContextCompat.getColorStateList(this, R.color.colorText));
        radioButton2.setButtonTintList(ContextCompat.getColorStateList(this, R.color.colorText));
        radioButton3.setButtonTintList(ContextCompat.getColorStateList(this, R.color.colorText));

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            radioButton1.setBackground(defaultBorder);
            radioButton1.setTextColor(Color.parseColor("#202020"));
            radioButton1.setButtonTintList(ContextCompat.getColorStateList(this, R.color.colorText));

            radioButton2.setBackground(defaultBorder);
            radioButton2.setTextColor(Color.parseColor("#202020"));
            radioButton2.setButtonTintList(ContextCompat.getColorStateList(this, R.color.colorText));

            radioButton3.setBackground(defaultBorder);
            radioButton3.setTextColor(Color.parseColor("#202020"));
            radioButton3.setButtonTintList(ContextCompat.getColorStateList(this, R.color.colorText));

            GradientDrawable activeBorder = new GradientDrawable();
            activeBorder.setShape(GradientDrawable.RECTANGLE);
            activeBorder.setCornerRadius(25);
            activeBorder.setStroke(4, Color.parseColor("#4A90E2"));
            activeBorder.setColor(Color.TRANSPARENT);

            RadioButton selectedRadioButton = findViewById(checkedId);
            selectedRadioButton.setBackground(activeBorder);
            selectedRadioButton.setTextColor(Color.parseColor("#4A90E2"));
            selectedRadioButton.setButtonTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary));
        });
    }
}