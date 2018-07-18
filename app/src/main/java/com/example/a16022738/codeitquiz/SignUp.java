package com.example.a16022738.codeitquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;


public class SignUp extends AppCompatActivity {


    TextView tvTitle, tvTitle2;
    Button btnCreate, btnSignUp;
    EditText editTextUser, editTextPassword, editTextEmail;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

    }

    @Override
    protected void onResume() {
        super.onResume();

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle2 = (TextView) findViewById(R.id.tvTitle2);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        editTextUser = (EditText) findViewById(R.id.etUsername);
//        editTextConfirm = (EditText) findViewById(R.id.etConfirm);
        editTextEmail = (EditText) findViewById(R.id.etEmail);
        editTextPassword = (EditText) findViewById(R.id.etPass);


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Code for step 1 start

                String url = "https://codeit100.000webhostapp.com/User/createUser.php";

                HttpRequest request = new HttpRequest(url);
                Log.i("Signup",editTextPassword.getText().toString());

                request.setOnHttpResponseListener(mHttpResponseListener);
                request.setMethod("POST");
                request.addData("Username",editTextUser.getText().toString());
                request.addData("Email",editTextEmail.getText().toString());
                request.addData("Password",editTextPassword.getText().toString());
                request.execute();
                // Code for step 1 end
                Intent activity = new Intent(SignUp.this,Login.class);
                activity.putExtra("Username", editTextUser.getText().toString());
                activity.putExtra("Email",editTextEmail.getText().toString());
                activity.putExtra("Password",editTextPassword.getText().toString());

            }
        });
            }


    // Code for step 2 start
    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response){

                    // process response here
                    try {
                        Log.i("JSON Results: ", response);

                        JSONObject jsonObj = new JSONObject(response);
                        Toast.makeText(getApplicationContext(), jsonObj.getString("message"), Toast.LENGTH_SHORT).show();

                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                }
            };
// Code for step 2 end





    }




