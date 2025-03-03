package com.atoballesterosbaluyangravidez.studybuddy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignInPage extends AppCompatActivity {
    private EditText email, password;
    private CheckBox rememberMe;
    private Button loginButton;
    private TextView signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signinpage);

        email = findViewById(R.id.emailicon);
        password = findViewById(R.id.password);
        rememberMe = findViewById(R.id.rememberme);
        loginButton = findViewById(R.id.bookbutton);
        signUp = findViewById(R.id.signup);

        SharedPreferences sharedPrefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        if (sharedPrefs.getBoolean("remember", false)) {
            startActivity(new Intent(SignInPage.this, TypeOfProfessional.class));
            finish();
        }

        loginButton.setOnClickListener(v -> {
            String userEmail = email.getText().toString().trim();
            String userPassword = password.getText().toString().trim();

            if (!userEmail.isEmpty() && !userPassword.isEmpty()) {
                SupabaseClient.signIn(userEmail, userPassword, new SupabaseClient.Callback() {
                    @Override
                    public void onSuccess(String response) {
                        runOnUiThread(() -> {
                            if (rememberMe.isChecked()) {
                                sharedPrefs.edit().putBoolean("remember", true).apply();
                            }
                            Toast.makeText(SignInPage.this, "Login successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignInPage.this, TypeOfProfessional.class));
                            finish();
                        });
                    }

                    @Override
                    public void onFailure(String error) {
                        runOnUiThread(() -> {
                            Log.e("SignIn", "Login failed: " + error);
                            Toast.makeText(SignInPage.this, "Login failed: " + error, Toast.LENGTH_SHORT).show();
                        });
                    }
                });
            } else {
                if (userEmail.isEmpty()) email.setError("Email required");
                if (userPassword.isEmpty()) password.setError("Password required");
            }
        });

        signUp.setOnClickListener(v -> {
            Intent intent = new Intent(SignInPage.this, SignUpPage.class);
            startActivity(intent);
        });
    }
}