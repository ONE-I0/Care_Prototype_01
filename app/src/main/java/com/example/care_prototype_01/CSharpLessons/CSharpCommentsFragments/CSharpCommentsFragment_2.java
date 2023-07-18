package com.example.care_prototype_01.CSharpLessons.CSharpCommentsFragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.example.care_prototype_01.PythonLessons.PythonCommentsFragments.PythonCommentsFragment_2;
import com.example.care_prototype_01.R;


public class CSharpCommentsFragment_2 extends Fragment {
    private MediaPlayer question_sounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c_sharp_comments_2, container, false);
        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);


        Button btnP_Comments_Q1 = view.findViewById(R.id.P_Comments_btnQ1);
        Button btnP_Comments_Q2 = view.findViewById(R.id.P_Comments_btnQ2);
        Button btnP_Comments_Q3 = view.findViewById(R.id.P_Comments_btnQ3);
        btnP_Comments_Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_Comments_Q1();
            }
        });
        btnP_Comments_Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_Comments_Q2();
            }
        });
        btnP_Comments_Q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_Comments_Q3();
            }
        });

        return view;
    }
    private void btnP_Comments_Q1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_c_cut);
        alertDialogBuilder.setTitle("How do you write comments in C#?");
        alertDialogBuilder.setMessage("Always start with two forward slashes ( // ) to create a comment.");
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
    private void btnP_Comments_Q2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_c_cut);
        alertDialogBuilder.setTitle("How many types of comments are supported by C#?");
        alertDialogBuilder.setMessage("There are three types of comments being used in C#. These are: Single Line Comments ( // ); Multi Line Comments ( /* */ ); and XML Comments ( /// ).");
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
    private void btnP_Comments_Q3() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_c_cut);
        alertDialogBuilder.setTitle("What is the importance of having comments in C# codes?");
        alertDialogBuilder.setMessage("It is important for a developer to provide a comment every time a function is being developed in order to easily identify and locate errors. It is always a good practice to put comments for readability and consistency.");
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