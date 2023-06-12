package com.example.care_prototype_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import care_fragments.HomeFragment;
import care_fragments.QuizFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    QuizFragment quizFragment = new QuizFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.Home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                } else if (item.getItemId()==R.id.Quiz) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,quizFragment).commit();
                }
                return true;
            }
        });
    }
}
