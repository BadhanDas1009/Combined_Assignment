package com.example.combined_app;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Assignment2 extends AppCompatActivity {

    CheckBox checkbox1, checkbox2;
    RadioGroup radioGroup;
    RatingBar ratingBar;
    SeekBar seekBar;
    Switch switch1;
    TextView outputTextView;

    StringBuilder userInputSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment2);

        // Initialize widgets
        checkbox1 = findViewById(R.id.checkbox1);
        checkbox2 = findViewById(R.id.checkbox2);
        radioGroup = findViewById(R.id.radio_group);
        ratingBar = findViewById(R.id.ratingBar);
        seekBar = findViewById(R.id.seekBar);
        switch1 = findViewById(R.id.switch1);
        outputTextView = findViewById(R.id.outputTextView);

        userInputSummary = new StringBuilder();

        // Initial display
        updateOutputTextView();

        // Checkbox listeners
        CompoundButton.OnCheckedChangeListener checkBoxListener = (buttonView, isChecked) -> updateOutputTextView();
        checkbox1.setOnCheckedChangeListener(checkBoxListener);
        checkbox2.setOnCheckedChangeListener(checkBoxListener);

        // RadioGroup listener
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> updateOutputTextView());

        // RatingBar listener
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> updateOutputTextView());

        // SeekBar listener
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateOutputTextView();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        // Switch listener
        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> updateOutputTextView());
    }

    // Method to update the TextView dynamically
    private void updateOutputTextView() {
        userInputSummary.setLength(0); // Clear the summary

        // CheckBox states
        userInputSummary.append("Future Profession:\n");
        if (checkbox1.isChecked()) userInputSummary.append("- Doctor\n");
        if (checkbox2.isChecked()) userInputSummary.append("- Engineer\n");
        if (!checkbox1.isChecked() && !checkbox2.isChecked()) userInputSummary.append("- None selected\n");

        // RadioButton selection
        int selectedRadioId = radioGroup.getCheckedRadioButtonId();
        userInputSummary.append("\nT-Shirt Size:\n");
        if (selectedRadioId != -1) {
            RadioButton selectedRadio = findViewById(selectedRadioId);
            userInputSummary.append("- ").append(selectedRadio.getText()).append("\n");
        } else {
            userInputSummary.append("- None selected\n");
        }

        // RatingBar value
        userInputSummary.append("\nRating:\n");
        userInputSummary.append("- ").append(ratingBar.getRating()).append(" stars\n");

        // SeekBar value
        userInputSummary.append("\nVolume:\n");
        userInputSummary.append("- ").append(seekBar.getProgress()).append(" out of 100\n");

        // Switch state
        userInputSummary.append("\nNotifications:\n");
        userInputSummary.append("- ").append(switch1.isChecked() ? "Enabled" : "Disabled").append("\n");

        // Update TextView
        outputTextView.setText(userInputSummary.toString());
    }
}
