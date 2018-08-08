package com.example.a16022738.codeitquiz;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

public class UpdateProfile extends AppCompatActivity {
    Button btnUpdate;
    EditText etUsername, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        etUsername = findViewById(R.id.editUsername);
        etEmail = findViewById(R.id.editEmail);
        btnUpdate = findViewById(R.id.btnUpdate);


        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String id = getIntent().getStringExtra("id");
//        Log.i("34",email);
//        Log.i("35",username);


        etUsername.setText(username);
        etEmail.setText(email);


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Code for step 1 start
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(UpdateProfile.this);
                String id = preferences.getString("id", "");
                String url = "https://codeit100.000webhostapp.com/updateUser.php";

                HttpRequest request = new HttpRequest(url);



                request.setOnHttpResponseListener(mHttpResponseListener);
                request.setMethod("POST");

                request.addData("id",id);
                request.addData("username", etUsername.getText().toString());
                request.addData("email", etEmail.getText().toString());

                request.execute();
                // Code for step 1 end
                Toast.makeText(UpdateProfile.this, "Contact record is updated successfully", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(UpdateProfile.this, ProfileActivity.class);
//                startActivity(intent);
            }
        });
    }



    // Code for step 2 start
    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response) {

                    // process response here
                    try {
                        Log.i("JSON Results: ", response);

                        JSONObject jsonObj = new JSONObject(response);

                        Toast.makeText(getApplicationContext(), jsonObj.getString("message"), Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
    }

