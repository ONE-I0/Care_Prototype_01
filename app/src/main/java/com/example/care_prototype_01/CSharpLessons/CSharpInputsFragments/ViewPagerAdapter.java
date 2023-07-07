package com.example.care_prototype_01.CSharpLessons.CSharpInputsFragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.care_prototype_01.CSharpLessons.CSharpInputs;
import com.example.care_prototype_01.PythonLessons.PythonInputs;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> fragmentArrayList;
    public ViewPagerAdapter(CSharpInputs cSharpInputs, ArrayList<Fragment> fragmentArrayList){
        super(cSharpInputs);
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
