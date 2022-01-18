package com.example.agricultureapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText editText_Firstname, editText_Lastname, editText_Birthday, editText_Age, editText_Email, editText_Username, editText_Password;
    String str_Firstname, str_Lastname, str_Birthday, str_Age, str_Email, str_Username, str_Password;
    String url = "https://e2019cc107group8.000webhostapp.com/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editText_Firstname = findViewById(R.id.editText_Firstname);
        editText_Lastname = findViewById(R.id.editText_Lastname);
        editText_Birthday = findViewById(R.id.editText_Birthday);
        editText_Age = findViewById(R.id.editText_Age);
        editText_Email = findViewById(R.id.editText_Email);
        editText_Username = findViewById(R.id.editText_Username);
        editText_Password = findViewById(R.id.editText_Password);

        getSupportActionBar().hide();

        TextView textView = findViewById(R.id.loginlink);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }
    public void Register(View view){
        if(editText_Firstname.getText().toString().equals("")){
            Toast.makeText(this, "Enter Firstname", Toast.LENGTH_SHORT).show();
        }
        else if(editText_Lastname.getText().toString().equals("")){
            Toast.makeText(this, "Enter Lastname", Toast.LENGTH_SHORT).show();
        }
        else if(editText_Birthday.getText().toString().equals("")){
            Toast.makeText(this, "Enter Birthday", Toast.LENGTH_SHORT).show();
        }
        else if(editText_Age.getText().toString().equals("")){
            Toast.makeText(this, "Enter Age", Toast.LENGTH_SHORT).show();
        }
        else if(editText_Email.getText().toString().equals("")){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
        }
        else if(editText_Username.getText().toString().equals("")){
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
        }
        else if(editText_Password.getText().toString().equals("")){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }
        else{
            str_Firstname = editText_Firstname.getText().toString().trim();
            str_Lastname = editText_Lastname.getText().toString().trim();
            str_Birthday = editText_Birthday.getText().toString().trim();
            str_Age = editText_Age.getText().toString().trim();
            str_Email = editText_Email.getText().toString().trim();
            str_Username = editText_Username.getText().toString().trim();
            str_Password = editText_Password.getText().toString().trim();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(RegisterActivity.this, response,Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(RegisterActivity.this, error.getMessage().toString(),Toast.LENGTH_SHORT).show();
                }
            }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();

                    params.put("firstname", str_Firstname);
                    params.put("lastname", str_Lastname);
                    params.put("birthday",str_Birthday);
                    params.put("age", str_Age);
                    params.put("email", str_Email);
                    params.put("username", str_Username);
                    params.put("password", str_Password);
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);

            requestQueue.add(request);

        }
    }
}