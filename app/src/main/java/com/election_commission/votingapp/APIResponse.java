package com.election_commission.votingapp;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import androidx.annotation.NonNull;

public class APIResponse implements Serializable {

    @SerializedName("count")
    private int count;

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public int getCount() {
        return count;
    }
}
