package com.example.agricultureapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class welcome_screen extends AppCompatActivity {
    Button loginButton;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        getSupportActionBar().hide();

        loginButton = findViewById(R.id.loginbtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcome_screen.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        TextView textView = findViewById(R.id.Registerlink1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcome_screen.this, RegisterActivity.class);
                startActivity(intent);

                finish();
            }
        });

    }
}