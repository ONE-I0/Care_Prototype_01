package com.example.care_prototype_01.JavaLessonsActivity.JavaIntroductionFragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.care_prototype_01.JavaLessonsActivity.JavaIntroduction;


import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> fragmentArrayList;
    public ViewPagerAdapter(JavaIntroduction javaIntroduction, ArrayList<Fragment> fragmentArrayList){
        super(javaIntroduction);
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
