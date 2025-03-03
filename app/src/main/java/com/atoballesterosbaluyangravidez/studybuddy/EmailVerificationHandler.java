package com.atoballesterosbaluyangravidez.studybuddy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EmailVerificationHandler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri data = getIntent().getData();
        Log.d("EmailVerification", "Deep Link: " + data.toString());

        if (data != null) {
            String fragment = data.getFragment();
            Log.d("EmailVerification", "Fragment: " + fragment);

            if (fragment != null && fragment.startsWith("access_token=")) {
                String token = fragment.substring("access_token=".length());
                Log.d("EmailVerification", "Access Token: " + token);

                if (token != null && !token.isEmpty()) {
                    Toast.makeText(this, "Email verified successfully!", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(EmailVerificationHandler.this, TypeOfProfessional.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "Invalid verification link. Token is missing.", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Invalid verification link format. access_token not found.", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "No verification data found.", Toast.LENGTH_LONG).show();
        }
    }
}