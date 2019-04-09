package com.election_commission.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    ImageView captchaImage;
    Document mainDocument;
    private EditText epicNoEditText;
    private EditText captchaCode;
     Button searchButton;
    private ProgressDialog progressDialog;
    private Map<String, String> cookies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        epicNoEditText = findViewById(R.id.epicNoEditText);
        captchaImage = findViewById(R.id.captha);
        captchaCode = findViewById(R.id.captchaCode);
        searchButton = findViewById(R.id.searchButton);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Please wait..");

        final ArrayList<String> aList = new ArrayList<String>();
        aList.add("ABC1111111");
        aList.add("ABC1239876");
        aList.add("QWE8769876");
        aList.add("DER8769876");
        aList.add("JHY8769876");
        aList.add("CXV8769876");
        aList.add("LKJ8769876");



        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0;i<7;i++)
                {

                   if(epicNoEditText.getText().toString().equals(aList.get(i)))
                    {
                        if(captchaCode.getText().toString().equals("W68HP")) {
                            Intent voter = new Intent(getApplicationContext(), voterinfo.class);
                            voter.putExtra("abc", i);
                            startActivity(voter);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Captcha is wrong!", Toast.LENGTH_LONG).show();
                        }

                    }
                   else{
                       Toast.makeText(getApplicationContext(), "EPIC is invalid!", Toast.LENGTH_LONG).show();
                   }

                }




            }
        });




    }

//    class MyTask extends AsyncTask<Void, Void, Void>{
//
//        @Override
//        protected void onPreExecute() {
//            progressDialog.show();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            try {
//
//                Connection.Response response1 = Jsoup
//                        .connect("https://electoralsearch.in/Home")
//                        .referrer("https://electoralsearch.in/")
//                        .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36")
//                        .execute();
//
//                mainDocument = response1.parse();
//
//                String __RequestVerificationToken = response1.cookies().get("__RequestVerificationToken");
//                String serverAffinity = response1.cookies().get("ServerAffinity");
//                System.out.println("__RequestVerificationToken "+ __RequestVerificationToken);
//                System.out.println("ServerAffinity "+ serverAffinity);
//                cookies = new HashMap<>();
//                cookies.put("__RequestVerificationToken", __RequestVerificationToken);
//                cookies.put("ServerAffinity", serverAffinity);
//                cookies.put("runOnce", "true");
//
////                System.out.println("Document : "+document.getElementById("tab2").getElementById("name"));
//
////                Element element = document.getElementById("tab2").getElementById("imgCaptchaDiv");
////                System.out.println("ELEMENT *** : "+ element);
////                final String image = element.attr("src");
//
//                Connection.Response response2 = Jsoup
//                        .connect("https://electoralsearch.in/Home/GetCaptcha?image=true")
//                        .referrer("https://electoralsearch.in/")
//                        .ignoreContentType(true)
//                        .cookies(cookies)
//                        .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36")
//                        .execute();
//
//                String electoralSearchIdCookie = response2.cookie("electoralSearchId");
//                cookies.put("electoralSearchId", electoralSearchIdCookie);
//
//                final Bitmap bmp = BitmapFactory.decodeByteArray(response2.bodyAsBytes(), 0, response2.bodyAsBytes().length);
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        captchaImage.setImageBitmap(bmp);
//                    }
//                });
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }

//        @Override
//        protected void onPostExecute(Void aVoid) {
//            progressDialog.cancel();
//            searchButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    String epicNumber = epicNoEditText.getText().toString();
//                    String captchaCodeVal = captchaCode.getText().toString();
//                    SearchUser searchUser = new SearchUser(MainActivity.this, cookies, epicNumber, captchaCodeVal);
//                    searchUser.execute();
//                }
//            });
//        }
    }


