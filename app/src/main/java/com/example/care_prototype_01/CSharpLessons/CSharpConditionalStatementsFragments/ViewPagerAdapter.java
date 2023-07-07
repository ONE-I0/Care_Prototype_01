package com.example.care_prototype_01.CSharpLessons.CSharpConditionalStatementsFragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.care_prototype_01.CSharpLessons.CSharpConditionalStatements;
import com.example.care_prototype_01.PythonLessons.PythonConditionalStatement;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> fragmentArrayList;
    public ViewPagerAdapter(CSharpConditionalStatements cSharpConditionalStatements, ArrayList<Fragment> fragmentArrayList){
        super(cSharpConditionalStatements);
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
