package com.example.agricultureapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
public class Publish_post extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_post);

        getSupportActionBar().hide();
    }
}