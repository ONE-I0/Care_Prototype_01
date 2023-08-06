package com.example.care_prototype_01.JavaLessonsActivity.JavaCommentFragments;

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

public class JavaCommentsFragment_3 extends Fragment {
    private MediaPlayer question_sounds;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_java_comments_3, container, false);

        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);


        Button btnP_Intro_Q1 = view.findViewById(R.id.P_Intro_btnQ1);
        Button btnP_Intro_Q2 = view.findViewById(R.id.P_Intro_btnQ2);
        Button btnP_Intro_Q3 = view.findViewById(R.id.P_Intro_btnQ3);
        btnP_Intro_Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_Intro_Q1();
            }
        });
        btnP_Intro_Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_Intro_Q2();
            }
        });
        btnP_Intro_Q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_Intro_Q3();
            }
        });
        return view;
    }
    private void btnP_Intro_Q1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("What is the purpose of comments in Java?");
        alertDialogBuilder.setMessage("The Comments in Java is not just a decorative text written in the code, rather, it serves its own purpose by adding explanatory or descriptive text that helps everyone who will read the code easily understand the meaning of its function.");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // You can add some action here when the user clicks "OK"
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void btnP_Intro_Q2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("What is the difference of a single-line vs multi-line comment?");
        alertDialogBuilder.setMessage("Single-line comments (‘//’) are suitable for short explanations that usually takes up on a single line only and these are used to clarify variable declarations, providing context, or briefly describing the code. Multi-line comments (‘/* … */’), on the other hand, are useful for long explanations, disabling blocks of code temporarily, or putting out a large section of comment into the code.");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // You can add some action here when the user clicks "OK"
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void btnP_Intro_Q3() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Can comments slow down a program’s execution?");
        alertDialogBuilder.setMessage("The answer is No. Comments have no impact on the performance of the program and it does not slow execution speed of compiled bytecodes because it is not included when being interpreted by the compiler.");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // You can add some action here when the user clicks "OK"
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
}