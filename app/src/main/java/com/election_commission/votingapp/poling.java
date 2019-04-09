package com.election_commission.votingapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class poling extends AppCompatActivity {

    private TextView totalVoters, noOfVotes, peopleQueue;
    private int voters, votes, queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_poling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getIds();

        LineCount lineCount = new LineCount(2);
        APIClient.getSingletonApiClient().assemblyLine(lineCount, new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                APIResponse result = response.body();
                Log.d("Result", result.toString());
                if(result.getCount() != -1) {
                    voters = result.getCount() * 24;
                    votes = voters / 3;
                    queue = result.getCount();
                }
                else{
                    Log.d("Oops", "onResponse pe");
                }
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                Log.d("Oops", "onFailure pe");
                voters = 180 * 24;
                votes = 180 / 3;
                queue = 180;
            }
        });

        totalVoters.setText(String.valueOf(voters));
        noOfVotes.setText(String.valueOf(votes));
        peopleQueue.setText(String.valueOf(queue));

    }

    private void getIds(){
        totalVoters = (TextView) findViewById(R.id.totalVoters);
        noOfVotes = (TextView) findViewById(R.id.noOfVotes);
        peopleQueue = (TextView) findViewById(R.id.peopleQueue);
    }

}
