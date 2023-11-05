package com.example.care_prototype_01.CSharpLessons.CSharpSyntaxFragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.care_prototype_01.R;


public class CSharpSyntaxFragment_3 extends Fragment {
    private MediaPlayer question_sounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c_sharp_syntax_3, container, false);

        return view;
    }
}