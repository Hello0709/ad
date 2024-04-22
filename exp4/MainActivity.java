package com.example.ad_exp_4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private Spinner spinnerSubject;
    private RadioGroup radioGroupGender;
    private CheckBox checkBoxBachelor, checkBoxMaster;
    private Button buttonSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerSubject = findViewById(R.id.spinnerSubject);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkBoxBachelor = findViewById(R.id.checkBoxBachelor);
        checkBoxMaster = findViewById(R.id.checkBoxMaster);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        List<String> subjects = new ArrayList<>();
        subjects.add("Mathematics");
        subjects.add("Science");
        subjects.add("History");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, subjects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubject.setAdapter(adapter);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }
    private void submitForm() {

        String selectedSubject = spinnerSubject.getSelectedItem().toString();

        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        RadioButton selectedGender = findViewById(selectedGenderId);
        String gender = selectedGender.getText().toString();

        StringBuilder qualifications = new StringBuilder();
        if (checkBoxBachelor.isChecked()) {
            qualifications.append("Bachelor's Degree, ");
        }
        if (checkBoxMaster.isChecked()) {
            qualifications.append("Master's Degree, ");
        }
        if (qualifications.length() > 0) {
            qualifications.delete(qualifications.length() - 2, qualifications.length());
        }

        Intent intent = new Intent(MainActivity.this, DisplayDataActivity.class);
        intent.putExtra("subject", selectedSubject);
        intent.putExtra("gender", gender);
        intent.putExtra("qualifications", qualifications.toString());
        startActivity(intent);
    }
}