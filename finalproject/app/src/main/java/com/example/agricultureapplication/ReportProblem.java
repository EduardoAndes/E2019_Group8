package com.example.agricultureapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ReportProblem extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reportproblem);

        ImageView imageView = findViewById(R.id.ArrowBack);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportProblem.this, homepage.class);
                startActivity(intent);
                finish();
            }
        });

        getSupportActionBar().hide();
    }
}