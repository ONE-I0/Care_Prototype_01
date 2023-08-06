package com.example.care_prototype_01.JavaLessonsActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.care_prototype_01.JavaLessonsActivity.JavaOopFragments.JavaOopFragment_1;
import com.example.care_prototype_01.JavaLessonsActivity.JavaOopFragments.JavaOopFragment_2;
import com.example.care_prototype_01.JavaLessonsActivity.JavaOopFragments.JavaOopFragment_3;
import com.example.care_prototype_01.JavaLessonsActivity.JavaOopFragments.JavaOopFragment_4;
import com.example.care_prototype_01.JavaLessonsActivity.JavaOopFragments.JavaOopFragment_5;
import com.example.care_prototype_01.JavaLessonsActivity.JavaOopFragments.ViewPagerAdapter;
import com.example.care_prototype_01.JavaLessonsActivity.JavaOopFragments.ViewPagerUtil;
import com.example.care_prototype_01.R;
import com.example.care_prototype_01.care_languages.JavaLanguageActivity;

import java.util.ArrayList;

public class JavaOop extends AppCompatActivity {
    private ViewPager2 viewPager;
    private LinearLayout pager_dots;
    private FragmentStateAdapter pagerAdapter;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_oop);


        //this is the back button
        Button btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view -> {
            Intent OpenPythonIntroduction = new Intent(this, JavaLanguageActivity.class);
            startActivity(OpenPythonIntroduction);
        });

        viewPager = findViewById(R.id.viewpager);
        pager_dots = findViewById(R.id.pager_dots);

        fragmentArrayList.add(new JavaOopFragment_1());
        fragmentArrayList.add(new JavaOopFragment_2());
        fragmentArrayList.add(new JavaOopFragment_3());
        fragmentArrayList.add(new JavaOopFragment_4());
        fragmentArrayList.add(new JavaOopFragment_5());

        pagerAdapter = new ViewPagerAdapter(this, fragmentArrayList);
        viewPager.setAdapter(pagerAdapter);
        ViewPagerUtil.getInstance().setupIndicator(this, viewPager, pager_dots, fragmentArrayList.size());
    }

}