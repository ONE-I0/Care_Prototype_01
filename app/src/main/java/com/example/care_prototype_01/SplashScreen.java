package com.example.care_prototype_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    private MediaPlayer codey_intro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        // Initialize the MediaPlayer object with a media file
        codey_intro = MediaPlayer.create(this, R.raw.codeycareintro);
        codey_intro.start();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,MainActivity.class));
            }
        },4000);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Release the MediaPlayer resources when the activity is destroyed
        if (codey_intro != null) {
            codey_intro.release();
            codey_intro = null;
        }
    }
}