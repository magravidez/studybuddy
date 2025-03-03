package com.atoballesterosbaluyangravidez.studybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpPage extends AppCompatActivity {
    private EditText email, password;
    private Button signUpButton;
    private TextView signInLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signuppage);

        email = findViewById(R.id.emailicon);
        password = findViewById(R.id.password);
        signUpButton = findViewById(R.id.bookbutton);
        signInLink = findViewById(R.id.signin);

        signUpButton.setOnClickListener(v -> {
            String userEmail = email.getText().toString().trim();
            String userPassword = password.getText().toString().trim();

            if (!userEmail.isEmpty() && !userPassword.isEmpty()) {
                String redirectUrl = "studybuddy://callback";
                SupabaseClient.signUp(userEmail, userPassword, redirectUrl, new SupabaseClient.Callback() {
                    @Override
                    public void onSuccess(String response) {
                        runOnUiThread(() -> {
                            Toast.makeText(SignUpPage.this, "✅ Sign-up successful! Please check your email to verify.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUpPage.this, SignInPage.class));
                        });
                    }

                    @Override
                    public void onFailure(String error) {
                        runOnUiThread(() -> Toast.makeText(SignUpPage.this, "❌ Sign-up failed: " + error, Toast.LENGTH_SHORT).show());
                    }
                });
            } else {
                if (userEmail.isEmpty()) email.setError("Email required");
                if (userPassword.isEmpty()) password.setError("Password required");
            }
        });

        signInLink.setOnClickListener(v -> startActivity(new Intent(SignUpPage.this, SignInPage.class)));
    }
}