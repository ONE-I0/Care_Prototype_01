package com.example.care_prototype_01.CSharpLessons;

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
import android.widget.Toast;

import com.example.care_prototype_01.CSharpLessons.CSharpLoopingStatementsFragments.CSharpLoopingStatementsFragment_1;
import com.example.care_prototype_01.CSharpLessons.CSharpLoopingStatementsFragments.CSharpLoopingStatementsFragment_2;
import com.example.care_prototype_01.CSharpLessons.CSharpLoopingStatementsFragments.CSharpLoopingStatementsFragment_3;
import com.example.care_prototype_01.CSharpLessons.CSharpLoopingStatementsFragments.CSharpLoopingStatementsFragment_4;
import com.example.care_prototype_01.CSharpLessons.CSharpLoopingStatementsFragments.CSharpLoopingStatementsFragment_5;
import com.example.care_prototype_01.CSharpLessons.CSharpLoopingStatementsFragments.ViewPagerAdapter;
import com.example.care_prototype_01.CSharpLessons.CSharpLoopingStatementsFragments.ViewPagerUtil;
import com.example.care_prototype_01.R;
import com.example.care_prototype_01.care_languages.CSharpLanguageActivity;

import java.util.ArrayList;

public class CSharpLoopingStatements extends AppCompatActivity {
    private ViewPager2 viewPager;
    private LinearLayout pager_dots;
    private FragmentStateAdapter pagerAdapter;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csharp_looping_statements);

        Toast.makeText(getApplicationContext(), "Swipe right and left", Toast.LENGTH_SHORT).show();

        //this is the back button
        Button btn_back =findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view -> {
            Intent OpenCLoop = new Intent(this, CSharpLanguageActivity.class);
            startActivity(OpenCLoop);
        });

        viewPager = findViewById(R.id.viewpager);
        pager_dots = findViewById(R.id.pager_dots);

        fragmentArrayList.add(new CSharpLoopingStatementsFragment_1());
        fragmentArrayList.add(new CSharpLoopingStatementsFragment_2());
        fragmentArrayList.add(new CSharpLoopingStatementsFragment_3());
        fragmentArrayList.add(new CSharpLoopingStatementsFragment_4());
        fragmentArrayList.add(new CSharpLoopingStatementsFragment_5());


        pagerAdapter = new ViewPagerAdapter(this,fragmentArrayList);
        viewPager.setAdapter(pagerAdapter);
        ViewPagerUtil.getInstance().setupIndicator(this,viewPager,pager_dots, fragmentArrayList.size());
    }

}