package com.election_commission.votingapp;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NormalAPI {

    @POST("peopleinline?assemblyid=25")
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    Call<APIResponse> getAssemblyLine(@Body LineCount lineCount);
}
