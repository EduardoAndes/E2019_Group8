package com.example.agricultureapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class RegisterActivity extends AppCompatActivity {

    EditText editText_Fullname, editText_Email, editText_Username, editText_Password ;
    Button btnRegister;
    TextView linklogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editText_Fullname = findViewById(R.id.editText_Fullname);
        editText_Email = findViewById(R.id.editText_Email);
        editText_Username = findViewById(R.id.editText_Username);
        editText_Password = findViewById(R.id.editText_Password);

        getSupportActionBar().hide();

        TextView linklogin = findViewById(R.id.loginlink);
        linklogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);

                finish();
            }
        });

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText_Fullname.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter your Fullname", Toast.LENGTH_SHORT).show();
                } else if (editText_Email.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter your Email", Toast.LENGTH_SHORT).show();
                } else if (editText_Username.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter your Username", Toast.LENGTH_SHORT).show();
                } else if (editText_Password.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Enter your Password", Toast.LENGTH_SHORT).show();
               }else{


                    HashMap<String, String> params = new HashMap<>();
                    params.put("fullname", editText_Fullname.getText().toString());
                    params.put("email", editText_Email.getText().toString());
                    params.put("username", editText_Username.getText().toString());
                    params.put("password", editText_Password.getText().toString());
                    Register(params);
                }

            }

        });

    }


    private void Register(HashMap<String, String> params) {

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
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
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