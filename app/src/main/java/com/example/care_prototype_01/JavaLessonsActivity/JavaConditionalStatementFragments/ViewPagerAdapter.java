package com.example.care_prototype_01.JavaLessonsActivity.JavaConditionalStatementFragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.care_prototype_01.JavaLessonsActivity.JavaConditionalStatements;
import com.example.care_prototype_01.JavaLessonsActivity.JavaLoopingStatements;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> fragmentArrayList;
    public ViewPagerAdapter(JavaConditionalStatements javaConditionalStatements, ArrayList<Fragment> fragmentArrayList){
        super(javaConditionalStatements);
        this.fragmentArrayList = fragmentArrayList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentArrayList.size();
    }
}
