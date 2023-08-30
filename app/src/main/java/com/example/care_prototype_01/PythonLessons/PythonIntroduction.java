package com.example.care_prototype_01.PythonLessons;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import com.example.care_prototype_01.PythonLessons.PythonIntroductionFragments.PythonIntroductionFragment_1;
import com.example.care_prototype_01.PythonLessons.PythonIntroductionFragments.PythonIntroductionFragment_2;
import com.example.care_prototype_01.PythonLessons.PythonIntroductionFragments.PythonIntroductionFragment_3;
import com.example.care_prototype_01.PythonLessons.PythonIntroductionFragments.ViewPagerAdapter;
import com.example.care_prototype_01.PythonLessons.PythonIntroductionFragments.ViewPagerUtil;
import com.example.care_prototype_01.R;
import com.example.care_prototype_01.care_languages.PythonLanguageActivity;

public class   PythonIntroduction extends AppCompatActivity {
    private ViewPager2 viewPager;

    private LinearLayout pager_dots;
    private FragmentStateAdapter pagerAdapter;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_introduction);

        Toolbar toolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);

        Toast.makeText(getApplicationContext(), "Swipe right and left", Toast.LENGTH_SHORT).show();
        //this is the back button
        ImageButton btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view -> {
            Intent back = new Intent(this, PythonLanguageActivity.class);
            startActivity(back);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });

        //for view pager and dots
        viewPager = findViewById(R.id.viewpager);
        pager_dots = findViewById(R.id.pager_dots);

        fragmentArrayList.add(new PythonIntroductionFragment_1());
        fragmentArrayList.add(new PythonIntroductionFragment_2());
        fragmentArrayList.add(new PythonIntroductionFragment_3());

        pagerAdapter = new ViewPagerAdapter(this,fragmentArrayList);
        viewPager.setAdapter(pagerAdapter);
        ViewPagerUtil.getInstance().setupIndicator(this,viewPager,pager_dots, fragmentArrayList.size());

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish(); // Finish the current activity
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out); // Apply cross-fade animation
    }

}