package com.example.a16022738.codeitquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends Fragment {

    private TextView etUsername, etEmail;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile, container, false);

        etUsername = (TextView) view.findViewById (R.id.viewUsername);
        etEmail = (TextView)view.findViewById(R.id.viewEmail);

        return view;

        // Code for step 1 end

//        Intent i = getIntent();
//        int contactId = i.getIntExtra("id", 0);
//
//        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent activity = new Intent(CreateContactsActivity.this, UpdateActivity.class);
//                activity.putExtra("id", String.valueOf(alContacts.get(i).getContactId()));
//                activity.putExtra("FirstName", String.valueOf(alContacts.get(i).getFirstName()));
//                activity.putExtra("LastName",String.valueOf(alContacts.get(i).getLastName()));
//                activity.putExtra("Mobile",String.valueOf(alContacts.get(i).getNumber()));
//
//                startActivity(activity);
//            }
//        });


    }




    @Override
    public void onResume () {
        super.onResume();



        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getView().getContext());
        String id = preferences.getString("id", "");
        Log.i("ttt",id);
        // Code for step 1 start
        HttpRequest request = new HttpRequest
                ("https://codeit100.000webhostapp.com/User/getProfile.php?user_id="+id);
        request.setOnHttpResponseListener(mHttpResponseListener);
        request.setMethod("GET");
        request.execute();
    }


    // Code for step 2 start
    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response) {

                    // process response here
                    try {
                        JSONObject jsonObj = new JSONObject(response);


                            String userName = jsonObj.getString("username");
                            String email = jsonObj.getString("email");

                        etUsername.setText(userName);
                        etEmail.setText(email);


                            Log.i("WWWW",userName);
                            Log.i("WWW",email);



                    } catch (Exception e) {
                        e.printStackTrace();
                    }

//                    aaContact.notifyDataSetChanged();
                }


            };
    // Code for step 2 end
}



