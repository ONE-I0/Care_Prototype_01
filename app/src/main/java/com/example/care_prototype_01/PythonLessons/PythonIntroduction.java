package com.example.care_prototype_01.PythonLessons;

import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
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

public class   PythonIntroduction extends AppCompatActivity {
    private ViewPager2 viewPager;
    private LinearLayout pager_dots;
    private FragmentStateAdapter pagerAdapter;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_introduction);

        viewPager = findViewById(R.id.viewpager);
        pager_dots = findViewById(R.id.pager_dots);

        fragmentArrayList.add(new PythonIntroductionFragment_1());
        fragmentArrayList.add(new PythonIntroductionFragment_2());
        fragmentArrayList.add(new PythonIntroductionFragment_3());

        pagerAdapter = new ViewPagerAdapter(this,fragmentArrayList);
        viewPager.setAdapter(pagerAdapter);
        ViewPagerUtil.getInstance().setupIndicator(this,viewPager,pager_dots, fragmentArrayList.size());
        ViewPagerUtil.getInstance().onBackPressed(viewPager,getSupportFragmentManager());
    }
    @Override
    public void onBackPressed(){
        setViewPagerBackPress();
    }
    private void setViewPagerBackPress(){
        if(viewPager.getCurrentItem()==0){
            super.onBackPressed();
        }else {
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
        }
    }
}