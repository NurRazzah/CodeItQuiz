package com.example.a16022738.codeitquiz;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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


public class Login extends AppCompatActivity {

    Button login;
    EditText editUsername, editPassword;
    TextView textViewSignUp;
    // internet operation  and it will take time to show the progress dialog
//   ProgressDialog progressDialog;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        login = (Button) findViewById(R.id.btnLog);
        editUsername = (EditText) findViewById(R.id.editName);
        editPassword = (EditText) findViewById(R.id.editPassword);
        textViewSignUp = (TextView) findViewById(R.id.tvSignUp);


        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "https://codeit100.000webhostapp.com/User/doLogin.php";

                HttpRequest request = new HttpRequest(url);

                request.setOnHttpResponseListener(mHttpResponseListener);
                request.setMethod("POST");
                request.addData("username", editUsername.getText().toString());
                request.addData("password", editPassword.getText().toString());

                request.execute();
                // Code for step 1 end
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

                            JSONObject result = new JSONObject(response);
                            Boolean authenticated = result.getBoolean("authenticated");
                            if (authenticated == true){


//                                String username = result.getString("username");
//                                String password = result.getString("password");
//
//                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                                intent.putExtra("username" , username);
//                                intent.putExtra("password" , password);
//
//                                startActivity(intent);


                                String id = result.getString("user_id");
                                Log.i("ID: ", id);

                                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(Login.this);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString("id",id);
                                editor.apply();

                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);



//                                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
//                                finish();
                            }else {
                                Toast.makeText(Login.this, "Login failed. Please checked your login credentials.",Toast.LENGTH_LONG).show();
                            }

                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }

                    }
                };


// Code for step 2 end




    }












