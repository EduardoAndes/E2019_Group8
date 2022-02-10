package com.example.agricultureapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Add_post extends AppCompatActivity {

    private CardView cardView, saveButton;
    private EditText title, description;
    private String addAnnouncementURL = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        CardView cardView = findViewById(R.id.ArrowBack);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Add_post.this, homepage.class);
                startActivity(intent);
                finish();
            }
        });

        getSupportActionBar().hide();

        saveButton = findViewById(R.id.Savebtn);
        title = findViewById(R.id.Title);
        description = findViewById(R.id.Description);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAnnouncement();
            }
        });
    }
    private void addAnnouncement(){


    }
}