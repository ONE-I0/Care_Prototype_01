package com.example.care_prototype_01.PythonLessons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.care_prototype_01.PythonLessons.PythonCommentsFragments.PythonCommentsFragment_1;
import com.example.care_prototype_01.PythonLessons.PythonCommentsFragments.PythonCommentsFragment_2;
import com.example.care_prototype_01.PythonLessons.PythonCommentsFragments.ViewPagerAdapter;
import com.example.care_prototype_01.PythonLessons.PythonCommentsFragments.ViewPagerUtil;
import com.example.care_prototype_01.R;

import java.util.ArrayList;

public class PythonComments extends AppCompatActivity {
    private ViewPager2 viewPager;
    private LinearLayout pager_dots;
    private FragmentStateAdapter pagerAdapter;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_comments);

        viewPager = findViewById(R.id.viewpager);
        pager_dots = findViewById(R.id.pager_dots);

        fragmentArrayList.add(new PythonCommentsFragment_1());
        fragmentArrayList.add(new PythonCommentsFragment_2());

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