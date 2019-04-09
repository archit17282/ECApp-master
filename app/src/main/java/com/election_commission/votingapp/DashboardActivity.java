package com.election_commission.votingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView gvContentView;
    private Elements elements;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Elements> _arrelements;
    private LinearLayoutManager mLayoutManager;
    private String[] _strTestType = {"General, PwD, Third Gender"};

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rowitems_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView tvHeader = (TextView) findViewById(R.id.tvheader);


        CardView togo=findViewById(R.id.card1);
        CardView tog=findViewById(R.id.card2);
        CardView to=findViewById(R.id.card3);


        togo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent login = new Intent (getApplicationContext(), MainActivity.class);

                startActivity(login);


            }
        });

        tog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent login = new Intent (getApplicationContext(), MainActivity.class);

                startActivity(login);


            }
        });

        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent login = new Intent (getApplicationContext(), MainActivity.class);

                startActivity(login);


            }
        });

    }


}
