package com.example.combined_app;


import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class Assignment3 extends AppCompatActivity {

    EditText emailEditText, phoneEditText, passwordEditText;
    Button submitButton;
    TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment3);

        // Initialize widgets
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        submitButton = findViewById(R.id.submitButton);
        outputTextView = findViewById(R.id.outputTextView);

        // Set Submit Button Click Listener
        submitButton.setOnClickListener(v -> validateForm());
    }

    // Validation logic
    private void validateForm() {
        String email = emailEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        StringBuilder result = new StringBuilder();

        // Email validation
        if (isValidEmail(email)) {
            result.append("Email: Valid\n");
        } else {
            result.append("Email: Invalid\n");
        }

        // Phone validation
        if (isValidPhone(phone)) {
            result.append("Phone: Valid\n");
        } else {
            result.append("Phone: Invalid\n");
        }

        // Password validation
        if (isValidPassword(password)) {
            result.append("Password: Valid\n");
        } else {
            result.append("Password: Invalid\n");
        }

        // Display results
        outputTextView.setText(result.toString());
    }

    // Email regex validation
    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) &&
                Pattern.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", email);
    }

    // Phone regex validation
    private boolean isValidPhone(String phone) {
        return !TextUtils.isEmpty(phone) &&
                Pattern.matches("^\\+?\\d{10,13}$", phone);
    }

    // Password validation (at least 8 characters, including a number and a letter)
    private boolean isValidPassword(String password) {
        return !TextUtils.isEmpty(password) &&
                Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", password);
    }
}
