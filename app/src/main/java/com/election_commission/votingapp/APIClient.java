package com.election_commission.votingapp;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import retrofit2.Callback;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static final String BASE_URL = "echack.herokuapp.com/";

    private static APIClient apiClient;

    private static final String TAG = APIClient.class.getSimpleName();

    private static Retrofit retrofit = null;

    private static final Object mLock = new Object();

    public APIClient(){

    }

    public static APIClient getSingletonApiClient(){
        synchronized (mLock){
            if(apiClient == null)
                apiClient = new APIClient();

            return apiClient;
        }
    }

    private static Retrofit getClient(){
        if(retrofit == null){

            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(60 * 3, TimeUnit.SECONDS)
                    .readTimeout(60 * 3, TimeUnit.SECONDS)
                    .writeTimeout(60 * 3, TimeUnit.SECONDS);

            GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient.build())
                    .addConverterFactory(gsonConverterFactory)
                    .build();
        }
        return retrofit;
    }

    public void assemblyLine(LineCount request, Callback<APIResponse> callback){
        Call<APIResponse> call = null;
        try{
            NormalAPI apiService = APIClient.getClient().create(NormalAPI.class);

            call = apiService.getAssemblyLine(request);
            call.enqueue(callback);

        } catch(Throwable e){
            callback.onFailure(call, e);
        }
    }

}
