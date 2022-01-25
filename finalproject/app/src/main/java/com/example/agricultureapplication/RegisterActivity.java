package com.example.agricultureapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class RegisterActivity<loginlink> extends AppCompatActivity {
    EditText EditText_Firstname, EditText_Lastname, EditText_Birthday, EditText_Age, EditText_Email,EditText_Username,EditText_Password;
    Button btnRegister;
    TextView loginlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        EditText_Firstname = findViewById(R.id.EditText_Firstname);
        EditText_Lastname = findViewById(R.id.EditText_Lastname);
        EditText_Birthday = findViewById(R.id.EditText_Birthday);
        EditText_Age = findViewById(R.id.EditText_Age);
        EditText_Email = findViewById(R.id.EditText_Email);
        EditText_Username = findViewById(R.id.EditText_Username);
        EditText_Password = findViewById(R.id.editTextTextPassword);


        loginlink = (TextView) findViewById(R.id.loginlink);
        loginlink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);

                finish();
            }
        });

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (EditText_Firstname.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter first name", Toast.LENGTH_SHORT).show();
                } else if (EditText_Lastname.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter last name", Toast.LENGTH_SHORT).show();
                } else if (EditText_Birthday.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter birthday", Toast.LENGTH_SHORT).show();
                } else if (EditText_Age.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter age", Toast.LENGTH_SHORT).show();
                } else if (EditText_Email.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                } else if (EditText_Username.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter username", Toast.LENGTH_SHORT).show();
                } else if (EditText_Password.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                }/* else if (!emailValidator(inputemail.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Enter valid email", Toast.LENGTH_SHORT).show();

                } */ else {

                    HashMap<String, String> params = new HashMap<>();
                    params.put("Firstname",EditText_Firstname.getText().toString());
                    params.put("Lastname",EditText_Lastname.getText().toString());
                    params.put("Birthday",EditText_Birthday.getText().toString());
                    params.put("Age",EditText_Age.getText().toString());
                    params.put("Email",EditText_Email.getText().toString());
                    params.put("Username",EditText_Username.getText().toString());
                    params.put("Password",EditText_Password.getText().toString());
                    register(params);
                }
            }
        });
    }


        private void register(HashMap<String, String> params) {

            final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
            progressDialog.setTitle("Please wait");
            progressDialog.setMessage("Registering...");
            progressDialog.setCancelable(false);
            progressDialog.show();

            NetworkService networkService = NetworkClient.getClient().create(NetworkService.class);
            Call<RegistrationResponseModel> registerCall = networkService.register(params);
            registerCall.enqueue(new Callback<RegistrationResponseModel>() {
                @Override
                public void onResponse(@NonNull Call<RegistrationResponseModel> call, @NonNull Response<RegistrationResponseModel> response) {
                    RegistrationResponseModel responseBody = response.body();
                    if (responseBody != null) {
                        if (responseBody.getSuccess().equals("1")) {
                            Toast.makeText(RegisterActivity.this, responseBody.getMessage(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, responseBody.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    progressDialog.dismiss();
                }

                @Override
                public void onFailure(@NonNull Call<RegistrationResponseModel> call, @NonNull Throwable t) {
                    progressDialog.dismiss();
                }
            });
            }
    }
