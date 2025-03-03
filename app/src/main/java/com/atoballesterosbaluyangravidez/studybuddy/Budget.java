package com.atoballesterosbaluyangravidez.studybuddy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Budget extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget);

        ImageView backButton = findViewById(R.id.arrowleft);
        ImageView continueButton = findViewById(R.id.continuebutton);
        RadioGroup radioGroup = findViewById(R.id.radiogroup);

        GradientDrawable defaultBorder = new GradientDrawable();
        defaultBorder.setShape(GradientDrawable.RECTANGLE);
        defaultBorder.setCornerRadius(25);
        defaultBorder.setStroke(4, Color.parseColor("#828282"));
        defaultBorder.setColor(Color.TRANSPARENT);

        GradientDrawable activeBorder = new GradientDrawable();
        activeBorder.setShape(GradientDrawable.RECTANGLE);
        activeBorder.setCornerRadius(25);
        activeBorder.setStroke(4, Color.parseColor("#4A90E2"));
        activeBorder.setColor(Color.TRANSPARENT);

        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            View view = radioGroup.getChildAt(i);
            if (view instanceof RadioButton) {
                ((RadioButton) view).setBackgroundDrawable(defaultBorder);
                ((RadioButton) view).setButtonTintList(ContextCompat.getColorStateList(this, R.color.colorText));
                ((RadioButton) view).setTextColor(Color.parseColor("#202020"));
            }
        }

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            for (int i = 0; i < group.getChildCount(); i++) {
                View view = group.getChildAt(i);
                if (view instanceof RadioButton) {
                    ((RadioButton) view).setBackgroundDrawable(defaultBorder);
                    ((RadioButton) view).setTextColor(Color.parseColor("#202020"));
                    ((RadioButton) view).setButtonTintList(ContextCompat.getColorStateList(this, R.color.colorText));
                }
            }

            RadioButton selectedRadioButton = findViewById(checkedId);
            if (selectedRadioButton != null) {
                selectedRadioButton.setBackgroundDrawable(activeBorder);
                selectedRadioButton.setTextColor(Color.parseColor("#4A90E2"));
                selectedRadioButton.setButtonTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary));
            }
        });

        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(Budget.this, Location.class);
            startActivity(intent);
            finish();
        });

        continueButton.setOnClickListener(view -> {
            Intent intent = new Intent(Budget.this, ProgressBar.class);
            startActivity(intent);
            finish();
        });
    }
}