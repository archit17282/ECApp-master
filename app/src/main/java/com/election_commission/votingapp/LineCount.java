package com.election_commission.votingapp;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LineCount implements Serializable {

    @SerializedName("count")
    private int count;

    public LineCount(int count){
        this.count = count;
    }

}
