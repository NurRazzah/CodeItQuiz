package com.example.a16022738.codeitquiz;


import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Leaderboard extends android.support.v4.app.Fragment {

    private ListView lvUser;
    private ArrayList<Users> alUsers;
    private ArrayAdapter<Users> aaUsers;

    // TODO (3) Declare loginId and apikey
    private String loginId, apikey;

    private String firstName, strLastName, strMobile, strContactId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_leaderboard, container, false);


        lvUser = (ListView) view.findViewById(R.id.lvUsers);
        alUsers = new ArrayList<Users>();

        aaUsers = new UserAdapter(getActivity(), R.layout.user_row, alUsers);
        lvUser.setAdapter(aaUsers);

        // TODO (4) Get loginId and apikey from the previous Intent
        Intent intent = getActivity().getIntent();
//        loginId = intent.getStringExtra("loginId");
//        apikey = intent.getStringExtra("apikey");
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


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        lvUser = (ListView) findViewById(R.id.lvUsers);
//        alUsers = new ArrayList<Users>();
//
//        aaUsers = new UserAdapter(this, R.layout.user_row, alUsers);
//        lvUser.setAdapter(aaUsers);
//
//        TODO (4) Get loginId and apikey from the previous Intent
//        Intent intent = getIntent();
////        loginId = intent.getStringExtra("loginId");
////        apikey = intent.getStringExtra("apikey");


    @Override
    public void onResume() {
        super.onResume();


        alUsers.clear();

        // TODO (5) Refresh the main activity with the latest list of contacts by calling getListOfContacts.php
        // What is the web service URL?
        // What is the HTTP method?
        // What parameters need to be provided?


        String url = "https://codeit100.000webhostapp.com/User/getListOfPlayer.php";

        HttpRequest request = new HttpRequest(url);

        request.setOnHttpResponseListener(mHttpResponseListener);
        request.setMethod("GET");
//        request.addData("loginId", loginId);
//        request.addData("apikey", apikey);

        request.execute();
        // Code for step 1 end

    }

    // TODO (6) In the HttpResponseListener for getListOfContacts.php, get all contacts from the results and show in the list
    // Code for step 2 start
    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response) {

                    // process response here
                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObj = jsonArray.getJSONObject(i);

                            int id = jsonObj.getInt("user_id");
                            String strfirstName = jsonObj.getString("username");


                            Users newItem = new Users(id, strfirstName);

                            alUsers.add(newItem);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    aaUsers.notifyDataSetChanged();
                }
            };
    // Code for step 2 end


}


