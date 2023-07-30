package com.example.care_prototype_01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import care_fragments.HomeFragment;
import care_fragments.quiz.QuizFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    final HomeFragment homeFragment = new HomeFragment();
    final QuizFragment quizFragment = new QuizFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.Home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
            } else if (item.getItemId()==R.id.Quiz) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,quizFragment).commit();
            }
            return true;
        });
    }
    @Override
    public void onBackPressed() {
        // Create a confirmation dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Close App");
        builder.setMessage("Are you sure you want to close the app?");
        builder.setPositiveButton("Close App", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Close the app
                finishAffinity();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Dismiss the dialog and do nothing (app remains open)
                dialog.dismiss();
            }
        });

        // Show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
