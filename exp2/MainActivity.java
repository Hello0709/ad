package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initiate();
    }
    private void init()
    {
        imageView = findViewById(R.id.imageView1);
        textView = findViewById(R.id.textView1);
        button = findViewById(R.id.button1);
    }
    private void initiate()
    {
        imageView.setImageResource(R.drawable.carpic);
        textView.setText("Hello\nAndroid Development");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Android Development", Toast.LENGTH_SHORT).show();
            }
        });
    }
}