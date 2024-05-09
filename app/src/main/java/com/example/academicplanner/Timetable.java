package com.example.academicplanner;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    // Define EditText fields for each day of the week
    EditText monday, tuesday, wednesday, thursday, friday, saturday, sunday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Initialize EditText fields by finding them using their IDs
        monday = findViewById(R.id.Monday1);
        tuesday = findViewById(R.id.Tuesday1);
        wednesday = findViewById(R.id.Wednesday1);
        thursday = findViewById(R.id.Thursday1);
        friday = findViewById(R.id.Friday1);
        saturday = findViewById(R.id.Saturday1);
        sunday = findViewById(R.id.Sunday1);
        monday = findViewById(R.id.Monday2);
        tuesday = findViewById(R.id.Tuesday2);
        wednesday = findViewById(R.id.Wednesday2);
        thursday = findViewById(R.id.Thursday2);
        friday = findViewById(R.id.Friday2);
        saturday = findViewById(R.id.Saturday2);
        sunday = findViewById(R.id.Sunday2);
        monday = findViewById(R.id.Monday3);
        tuesday = findViewById(R.id.Tuesday3);
        wednesday = findViewById(R.id.Wednesday3);
        thursday = findViewById(R.id.Thursday3);
        friday = findViewById(R.id.Friday3);
        saturday = findViewById(R.id.Saturday3);
        sunday = findViewById(R.id.Sunday3);
        monday = findViewById(R.id.Monday4);
        tuesday = findViewById(R.id.Tuesday4);
        wednesday = findViewById(R.id.Wednesday4);
        thursday = findViewById(R.id.Thursday4);
        friday = findViewById(R.id.Friday4);
        saturday = findViewById(R.id.Saturday4);
        sunday = findViewById(R.id.Sunday4);
        monday = findViewById(R.id.Monday5);
        tuesday = findViewById(R.id.Tuesday5);
        wednesday = findViewById(R.id.Wednesday5);
        thursday = findViewById(R.id.Thursday5);
        friday = findViewById(R.id.Friday5);
        saturday = findViewById(R.id.Saturday5);
        sunday = findViewById(R.id.Sunday5);
        monday = findViewById(R.id.Monday6);
        tuesday = findViewById(R.id.Tuesday6);
        wednesday = findViewById(R.id.Wednesday6);
        thursday = findViewById(R.id.Thursday6);
        friday = findViewById(R.id.Friday6);
        saturday = findViewById(R.id.Saturday6);
        sunday = findViewById(R.id.Sunday6);
        monday = findViewById(R.id.Monday7);
        tuesday = findViewById(R.id.Tuesday7);
        wednesday = findViewById(R.id.Wednesday7);
        thursday = findViewById(R.id.Thursday7);
        friday = findViewById(R.id.Friday7);
        saturday = findViewById(R.id.Saturday7);
        sunday = findViewById(R.id.Sunday7);
// Set listeners to handle user input
        setListeners();
    }
    private void setListeners() {
// Set OnFocusChangeListener for each EditText to save changes when
        focus changes;
        View.OnFocusChangeListener listener = new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
// Save the text when focus is lost
                    saveText((EditText) v);
                }
            }
        };
// Attach the listener to each EditText field
        monday.setOnFocusChangeListener(listener);
        tuesday.setOnFocusChangeListener(listener);
        wednesday.setOnFocusChangeListener(listener);
        thursday.setOnFocusChangeListener(listener);
        friday.setOnFocusChangeListener(listener);
        saturday.setOnFocusChangeListener(listener);
        sunday.setOnFocusChangeListener(listener);
    }
    private void saveText(EditText editText) {
// Get the text entered by the user
        String text = editText.getText().toString();
// Save the text or perform any necessary actions
// For demonstration, let's just display the text in the log
        System.out.println("User input for " +
                editText.getResources().getResourceEntryName(editText.getId()) + ": " + text);
    }
}