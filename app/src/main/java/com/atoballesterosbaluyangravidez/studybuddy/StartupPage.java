package com.atoballesterosbaluyangravidez.studybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class StartupPage extends AppCompatActivity {
    private ImageView continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startuppage);

        continueButton = findViewById(R.id.continuebutton);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartupPage.this, SignInPage.class);
                startActivity(intent);
            }
        });
    }
}