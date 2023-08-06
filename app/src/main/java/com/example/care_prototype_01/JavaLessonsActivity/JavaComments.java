package com.example.care_prototype_01.JavaLessonsActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.care_prototype_01.JavaLessonsActivity.JavaCommentFragments.JavaCommentsFragment_1;
import com.example.care_prototype_01.JavaLessonsActivity.JavaCommentFragments.JavaCommentsFragment_2;
import com.example.care_prototype_01.JavaLessonsActivity.JavaCommentFragments.JavaCommentsFragment_3;
import com.example.care_prototype_01.JavaLessonsActivity.JavaCommentFragments.ViewPagerAdapter;
import com.example.care_prototype_01.JavaLessonsActivity.JavaCommentFragments.ViewPagerUtil;
import com.example.care_prototype_01.R;
import com.example.care_prototype_01.care_languages.JavaLanguageActivity;

import java.util.ArrayList;

public class JavaComments extends AppCompatActivity {
    private ViewPager2 viewPager;
    private LinearLayout pager_dots;
    private FragmentStateAdapter pagerAdapter;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_comments);

        //this is the back button
        Button btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view -> {
            Intent OpenPythonIntroduction = new Intent(this, JavaLanguageActivity.class);
            startActivity(OpenPythonIntroduction);
        });

        viewPager = findViewById(R.id.viewpager);
        pager_dots = findViewById(R.id.pager_dots);

        fragmentArrayList.add(new JavaCommentsFragment_1());
        fragmentArrayList.add(new JavaCommentsFragment_2());
        fragmentArrayList.add(new JavaCommentsFragment_3());


        pagerAdapter = new ViewPagerAdapter(this, fragmentArrayList);
        viewPager.setAdapter(pagerAdapter);
        ViewPagerUtil.getInstance().setupIndicator(this, viewPager, pager_dots, fragmentArrayList.size());
    }
}