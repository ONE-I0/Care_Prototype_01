package com.example.care_prototype_01.PythonLessons;

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

import com.example.care_prototype_01.PythonLessons.PythonConditionalStatementsFragments.PythonConditionalStatementFragment_1;
import com.example.care_prototype_01.PythonLessons.PythonConditionalStatementsFragments.PythonConditionalStatementFragment_2;
import com.example.care_prototype_01.PythonLessons.PythonConditionalStatementsFragments.PythonConditionalStatementFragment_3;
import com.example.care_prototype_01.PythonLessons.PythonConditionalStatementsFragments.PythonConditionalStatementFragment_4;
import com.example.care_prototype_01.PythonLessons.PythonConditionalStatementsFragments.PythonConditionalStatementFragment_5;
import com.example.care_prototype_01.PythonLessons.PythonConditionalStatementsFragments.PythonConditionalStatementFragment_6;
import com.example.care_prototype_01.PythonLessons.PythonConditionalStatementsFragments.PythonConditionalStatementFragment_7;
import com.example.care_prototype_01.PythonLessons.PythonConditionalStatementsFragments.ViewPagerAdapter;
import com.example.care_prototype_01.PythonLessons.PythonConditionalStatementsFragments.ViewPagerUtil;
import com.example.care_prototype_01.R;
import com.example.care_prototype_01.care_languages.PythonLanguageActivity;

import java.util.ArrayList;

public class PythonConditionalStatement extends AppCompatActivity {
    private ViewPager2 viewPager;

    private LinearLayout pager_dots;
    private FragmentStateAdapter pagerAdapter;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_conditional_statement);
        Toast.makeText(getApplicationContext(), "Swipe right and left", Toast.LENGTH_SHORT).show();

        //this is the back button
        Button btn_back =findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view -> {
            Intent OpenPythonIntroduction = new Intent(this, PythonLanguageActivity.class);
            startActivity(OpenPythonIntroduction);
        });

        viewPager = findViewById(R.id.viewpager);
        pager_dots = findViewById(R.id.pager_dots);

        fragmentArrayList.add(new PythonConditionalStatementFragment_1());
        fragmentArrayList.add(new PythonConditionalStatementFragment_2());
        fragmentArrayList.add(new PythonConditionalStatementFragment_3());
        fragmentArrayList.add(new PythonConditionalStatementFragment_4());
        fragmentArrayList.add(new PythonConditionalStatementFragment_5());
        fragmentArrayList.add(new PythonConditionalStatementFragment_6());
        fragmentArrayList.add(new PythonConditionalStatementFragment_7());

        pagerAdapter = new ViewPagerAdapter(this,fragmentArrayList);
        viewPager.setAdapter(pagerAdapter);
        ViewPagerUtil.getInstance().setupIndicator(this,viewPager,pager_dots, fragmentArrayList.size());
    }

}