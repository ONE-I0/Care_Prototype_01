package com.example.care_prototype_01.JavaLessonsActivity.JavaOperatorsFragments;

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

import com.example.care_prototype_01.JavaLessonsActivity.JavaOopFragments.JavaOopFragment_5;
import com.example.care_prototype_01.R;

public class JavaOperatorsFragment_4 extends Fragment {


    private MediaPlayer question_sounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_java_operators_4, container, false);


        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);


        Button btnP_Oop_Q1 = view.findViewById(R.id.P_Oop_btnQ1);
        Button btnP_Oop_Q2 = view.findViewById(R.id.P_Oop_btnQ2);
        Button btnP_Oop_Q3 = view.findViewById(R.id.P_Oop_btnQ3);
        btnP_Oop_Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_Oop_Q1();
            }
        });
        btnP_Oop_Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_Oop_Q2();
            }
        });
        btnP_Oop_Q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_Oop_Q3();
            }
        });
        return view;
    }

    private void btnP_Oop_Q1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_java_cut);
        alertDialogBuilder.setTitle("What is the arithmetic operator used for addition in Java?");
        alertDialogBuilder.setMessage("The arithmetic operator used for addition in Java is the plus operator (+).");
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
    private void btnP_Oop_Q2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_java_cut);
        alertDialogBuilder.setTitle("What is the assignment operator used to assign a value to a variable in Java?");
        alertDialogBuilder.setMessage("The assignment operator used to assign a value to a variable in Java is the equals operator (=).");
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
    private void btnP_Oop_Q3() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_java_cut);
        alertDialogBuilder.setTitle("What is the comparison operator used to check if two values are equal in Java?");
        alertDialogBuilder.setMessage("The comparison operator used to check if two values are equal in Java is the double equals operator (==).");
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