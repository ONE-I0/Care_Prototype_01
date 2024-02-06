package com.example.care_prototype_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

// SplashScreen class extending AppCompatActivity
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout for the splash screen
        setContentView(R.layout.splash_screen);

        // Create a handler to delay the start of the main activity
        Handler handler = new Handler();

        // Use the postDelayed method to delay the runnable execution
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an intent to start the main activity
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);

                // Start the main activity
                startActivity(intent);

                // Finish the splash screen activity to prevent it from being accessible via the back button
                finish();
            }
        }, 4000); // 4000 milliseconds (4 seconds) delay before starting the main activity
    }
}