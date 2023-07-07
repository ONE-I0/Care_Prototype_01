package com.example.care_prototype_01.CSharpLessons.CSharpIntroductionFragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.care_prototype_01.CSharpLessons.CSharpIntroduction;
import com.example.care_prototype_01.PythonLessons.PythonIntroduction;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> fragmentArrayList;
    public ViewPagerAdapter(CSharpIntroduction cSharpIntroduction, ArrayList<Fragment> fragmentArrayList){
        super(cSharpIntroduction);
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
