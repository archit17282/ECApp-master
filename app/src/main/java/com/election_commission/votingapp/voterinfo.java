package com.election_commission.votingapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class voterinfo extends AppCompatActivity {


    ImageView a1;
    TextView a2;
    TextView a3;
    TextView a4;
    TextView a5;
    CardView a6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voterinfo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<struc> abc=new ArrayList<>();
        struc qw=new struc();
        qw.name="Ramesh Gupta";
        qw.fname="Sanjay Gupta";
        qw.gender="Male";
        qw.age="40 years";
         abc.add(qw);

                Intent intent = getIntent();
                int Value = intent.getIntExtra("abc", 0);

                a1=findViewById(R.id.voteri);
        a2=findViewById(R.id.name);
        a3=findViewById(R.id.Fname);
        a4=findViewById(R.id.gender);
        a5=findViewById(R.id.age);
        a6=findViewById(R.id.office);


        String name ="Name: "+abc.get(0).name;
        String fname ="Fathers Name: "+abc.get(0).fname;
        String gender ="Gender:  "+abc.get(0).gender;
        String age ="As on 1:01:2019:  "+abc.get(0).age;

        a2.setText(name);
        a3.setText(fname);
        a4.setText(gender);
        a5.setText(age);


        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent poling = new Intent (getApplicationContext(), poling.class);
                startActivity(poling);


            }
        });

    }

}
