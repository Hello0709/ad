package com.example.ad_exp_4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class DisplayDataActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        TextView textViewDisplayData = findViewById(R.id.textViewDisplayData);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String subject = extras.getString("subject");
            String gender = extras.getString("gender");
            String qualifications = extras.getString("qualifications");
            String message = "Subject: " + subject + "\nGender: " + gender + "\nQualification: " +
                    qualifications;
            textViewDisplayData.setText(message);
        }
    }
}