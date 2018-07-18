package com.example.a16022738.codeitquiz;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Lessons extends Fragment {

    Button btnOne, btnTwo, btnThree, btnFour, btnFive;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lessons_activity, container, false);

        btnOne= (Button) view.findViewById(R.id.btn1);
        btnTwo= (Button) view.findViewById(R.id.btn2);
        btnThree= (Button) view.findViewById(R.id.btn3);
        btnFour= (Button) view.findViewById(R.id.btn4);
        btnFive= (Button)view.findViewById(R.id.btn5);


        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=4ekASokneGU&list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al&index=4"));
                startActivity(intent);
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=WZXq5_9_JDs&index=8&list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al"));
                startActivity(intent);
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=L5_7XQR0r0w&index=10&list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al"));
                startActivity(intent);
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=_NfwcH5zKpA&index=13&list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al"));
                startActivity(intent);
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=z-QgsXkYqjc&list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al&index=14"));
                startActivity(intent);
            }
        });








        return view;
    }

}
