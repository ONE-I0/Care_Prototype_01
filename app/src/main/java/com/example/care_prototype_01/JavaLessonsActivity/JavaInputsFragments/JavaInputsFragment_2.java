package com.example.care_prototype_01.JavaLessonsActivity.JavaInputsFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.care_prototype_01.R;

public class JavaInputsFragment_2 extends Fragment {


    private static final int TEXT_SIZE_IN_DP = 20;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_java_inputs_2, container, false);
        return view;
    }
}