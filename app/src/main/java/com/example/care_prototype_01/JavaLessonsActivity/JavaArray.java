package com.example.care_prototype_01.JavaLessonsActivity;

import android.content.Intent;

import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;


import com.example.care_prototype_01.JavaLessonsActivity.JavaArrayFragments.JavaArraysFragment_1;
import com.example.care_prototype_01.JavaLessonsActivity.JavaArrayFragments.JavaArraysFragment_2;
import com.example.care_prototype_01.JavaLessonsActivity.JavaArrayFragments.JavaArraysFragment_3;
import com.example.care_prototype_01.JavaLessonsActivity.JavaArrayFragments.JavaArraysFragment_4;
import com.example.care_prototype_01.JavaLessonsActivity.JavaArrayFragments.JavaArraysFragment_5;
import com.example.care_prototype_01.JavaLessonsActivity.JavaArrayFragments.JavaArraysFragment_6;
import com.example.care_prototype_01.JavaLessonsActivity.JavaArrayFragments.JavaArraysFragment_7;
import com.example.care_prototype_01.JavaLessonsActivity.JavaArrayFragments.JavaArraysFragment_8;
import com.example.care_prototype_01.JavaLessonsActivity.JavaArrayFragments.JavaArraysFragment_9;
import com.example.care_prototype_01.JavaLessonsActivity.JavaArrayFragments.ViewPagerAdapter;
import com.example.care_prototype_01.JavaLessonsActivity.JavaArrayFragments.ViewPagerUtil;
import com.example.care_prototype_01.R;
import com.example.care_prototype_01.care_languages.CSharpLanguageActivity;
import com.example.care_prototype_01.care_languages.JavaLanguageActivity;


import java.util.ArrayList;


public class JavaArray extends AppCompatActivity {
    private ViewPager2 viewPager;
    private LinearLayout pager_dots;
    private FragmentStateAdapter pagerAdapter;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_array);


        Toolbar toolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);

        Toast.makeText(getApplicationContext(), "Swipe right and left", Toast.LENGTH_SHORT).show();
        //this is the back button
        ImageButton btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view -> {
            Intent back = new Intent(this, JavaLanguageActivity.class);
            startActivity(back);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });

        viewPager = findViewById(R.id.viewpager);
        pager_dots = findViewById(R.id.pager_dots);

        fragmentArrayList.add(new JavaArraysFragment_1());
        fragmentArrayList.add(new JavaArraysFragment_2());
        fragmentArrayList.add(new JavaArraysFragment_3());
        fragmentArrayList.add(new JavaArraysFragment_4());
        fragmentArrayList.add(new JavaArraysFragment_5());
        fragmentArrayList.add(new JavaArraysFragment_6());
        fragmentArrayList.add(new JavaArraysFragment_7());
        fragmentArrayList.add(new JavaArraysFragment_8());
        fragmentArrayList.add(new JavaArraysFragment_9());

        pagerAdapter = new ViewPagerAdapter(this, fragmentArrayList);
        viewPager.setAdapter(pagerAdapter);
        ViewPagerUtil.getInstance().setupIndicator(this, viewPager, pager_dots, fragmentArrayList.size());
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish(); // Finish the current activity
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out); // Apply cross-fade animation
    }
}