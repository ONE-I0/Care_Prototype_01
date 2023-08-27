package com.example.care_prototype_01.JavaLessonsActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.care_prototype_01.JavaLessonsActivity.JavaOperatorsFragments.JavaOperatorsFragment_1;
import com.example.care_prototype_01.JavaLessonsActivity.JavaOperatorsFragments.JavaOperatorsFragment_2;
import com.example.care_prototype_01.JavaLessonsActivity.JavaOperatorsFragments.JavaOperatorsFragment_3;
import com.example.care_prototype_01.JavaLessonsActivity.JavaOperatorsFragments.JavaOperatorsFragment_4;
import com.example.care_prototype_01.JavaLessonsActivity.JavaOperatorsFragments.ViewPagerAdapter;
import com.example.care_prototype_01.JavaLessonsActivity.JavaOperatorsFragments.ViewPagerUtil;
import com.example.care_prototype_01.R;
import com.example.care_prototype_01.care_languages.JavaLanguageActivity;

import java.util.ArrayList;

public class JavaOperators extends AppCompatActivity {

    private ViewPager2 viewPager;
    private LinearLayout pager_dots;
    private FragmentStateAdapter pagerAdapter;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_operators);
        Toast.makeText(getApplicationContext(), "Swipe right and left", Toast.LENGTH_SHORT).show();
        //this is the back button
        Button btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view -> {
            Intent OpenPythonIntroduction = new Intent(this, JavaLanguageActivity.class);
            startActivity(OpenPythonIntroduction);
        });

        viewPager = findViewById(R.id.viewpager);
        pager_dots = findViewById(R.id.pager_dots);

        fragmentArrayList.add(new JavaOperatorsFragment_1());
        fragmentArrayList.add(new JavaOperatorsFragment_2());
        fragmentArrayList.add(new JavaOperatorsFragment_3());
        fragmentArrayList.add(new JavaOperatorsFragment_4());



        pagerAdapter = new ViewPagerAdapter(this, fragmentArrayList);
        viewPager.setAdapter(pagerAdapter);
        ViewPagerUtil.getInstance().setupIndicator(this, viewPager, pager_dots, fragmentArrayList.size());
    }
}