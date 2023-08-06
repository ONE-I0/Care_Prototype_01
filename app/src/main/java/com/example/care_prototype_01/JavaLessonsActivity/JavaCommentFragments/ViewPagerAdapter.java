package com.example.care_prototype_01.JavaLessonsActivity.JavaCommentFragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.care_prototype_01.JavaLessonsActivity.JavaComments;
import com.example.care_prototype_01.JavaLessonsActivity.JavaIntroduction;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> fragmentArrayList;
    public ViewPagerAdapter(JavaComments javaComments, ArrayList<Fragment> fragmentArrayList){
        super(javaComments);
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
