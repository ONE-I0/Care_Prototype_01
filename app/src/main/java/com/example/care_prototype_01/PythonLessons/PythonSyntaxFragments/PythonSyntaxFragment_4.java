package com.example.care_prototype_01.PythonLessons.PythonSyntaxFragments;

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

public class PythonSyntaxFragment_4 extends Fragment {

    private MediaPlayer question_sounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_python_syntax_4, container, false);
        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);

        //button for the questions
        Button btnP_Syntax_Q1 = view.findViewById(R.id.P_Syntax_btnQ1);
        Button btnP_Syntax_Q2 = view.findViewById(R.id.P_Syntax_btnQ2);
        Button btnP_Syntax_Q3 = view.findViewById(R.id.P_Syntax_btnQ3);
        btnP_Syntax_Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                P_Syntax_btnQ1();
            }
        });
        btnP_Syntax_Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                P_Syntax_btnQ2();
            }
        });
        btnP_Syntax_Q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                P_Syntax_btnQ3();
            }
        });
        return view;
    }
    private void P_Syntax_btnQ1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("How do Python recognize the code and execute it?");
        alertDialogBuilder.setMessage("Python uses indentations to recognize where does a specific line of code will be executed. Without using it, the compiler may be confused and interpret a wrong line of code.");
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
    private void P_Syntax_btnQ2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("What will happen if you use a single line of quote in multiple lines?");
        alertDialogBuilder.setMessage("It will generate an error as the quotation only applies to a single word only.");
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
    private void P_Syntax_btnQ3() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("When does an invalid identifier usually occur?");
        alertDialogBuilder.setMessage("There are three ways to identify a wrong identifier: it starts with a digit word; a reserved keyword used for functions; or usually when a word contains a hyphen.");
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