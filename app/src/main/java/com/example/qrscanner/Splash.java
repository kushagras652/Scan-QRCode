package com.example.qrscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {

    //ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

      //  getSupportActionBar().hide();
       // pb=findViewById(R.id.progressBar);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               // pb.setVisibility(View.VISIBLE);
                startActivity(new Intent(Splash.this,MainActivity.class));
                finish();
            }
        },3000);
    }
}