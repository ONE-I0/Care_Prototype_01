package com.example.care_prototype_01.JavaLessonsActivity.JavaOopFragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.care_prototype_01.JavaLessonsActivity.JavaOop;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> fragmentArrayList;
    public ViewPagerAdapter(JavaOop javaOop, ArrayList<Fragment> fragmentArrayList){
        super(javaOop);
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
