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

import com.example.care_prototype_01.PythonLessons.PythonOperatorFragments.PythonOperatorsFragment_1;
import com.example.care_prototype_01.PythonLessons.PythonOperatorFragments.PythonOperatorsFragment_2;
import com.example.care_prototype_01.PythonLessons.PythonOperatorFragments.PythonOperatorsFragment_3;
import com.example.care_prototype_01.PythonLessons.PythonOperatorFragments.ViewPagerAdapter;
import com.example.care_prototype_01.PythonLessons.PythonOperatorFragments.ViewPagerUtil;
import com.example.care_prototype_01.R;
import com.example.care_prototype_01.care_languages.PythonLanguageActivity;

import java.util.ArrayList;

public class PythonOperators extends AppCompatActivity {
    private ViewPager2 viewPager;
    private TextView swipeMessage;
    private LinearLayout pager_dots;
    private FragmentStateAdapter pagerAdapter;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_operators);
        swipeMessage = findViewById(R.id.swipe_message);

        // Show the swipe message and start the timer
        showSwipeMessage();
        startTimer();

        //this is the back button
        Button btn_back =findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view -> {
            Intent OpenPythonIntroduction = new Intent(this, PythonLanguageActivity.class);
            startActivity(OpenPythonIntroduction);
        });

        viewPager = findViewById(R.id.viewpager);
        pager_dots = findViewById(R.id.pager_dots);

        fragmentArrayList.add(new PythonOperatorsFragment_1());
        fragmentArrayList.add(new PythonOperatorsFragment_2());
        fragmentArrayList.add(new PythonOperatorsFragment_3());

        pagerAdapter = new ViewPagerAdapter(this,fragmentArrayList);
        viewPager.setAdapter(pagerAdapter);
        ViewPagerUtil.getInstance().setupIndicator(this,viewPager,pager_dots, fragmentArrayList.size());
    }
    private void showSwipeMessage() {
        swipeMessage.setVisibility(View.VISIBLE);

        // Opacity animation when the message appears
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(swipeMessage, "alpha", 0f, 1f);
        fadeIn.setDuration(1000); // 1 second
        fadeIn.start();
    }

    private void hideSwipeMessage() {
        // Opacity animation when the message disappears
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(swipeMessage, "alpha", 1f, 0f);
        fadeOut.setDuration(1000); // 1 second
        fadeOut.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float alpha = (float) animation.getAnimatedValue();
                swipeMessage.setAlpha(alpha);
            }
        });
        fadeOut.start();
    }

    private void startTimer() {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                hideSwipeMessage();
            }
        }, 3000); // 3 seconds
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove the handler callbacks to avoid memory leaks
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
