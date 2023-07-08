package com.example.care_prototype_01.PythonLessons.PythonConditionalStatementsFragments;

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

public class PythonConditionalStatementFragment_7 extends Fragment {

    private MediaPlayer question_sounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_python_conditional_statement_7, container, false);

        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);


        Button btnP_conditional_Q1 = view.findViewById(R.id.P_condition_btnQ1);
        Button btnP_conditional_Q2 = view.findViewById(R.id.P_condition_btnQ2);
        Button btnP_conditional_Q3 = view.findViewById(R.id.P_condition_btnQ3);
        btnP_conditional_Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_conditional_Q1();
            }
        });
        btnP_conditional_Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_conditional_Q2();
            }
        });
        btnP_conditional_Q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_conditional_Q3();
            }
        });
        return view;
    }
    private void btnP_conditional_Q1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle(" Can an \"if\" statement have multiple conditions in Python?");
        alertDialogBuilder.setMessage("Yes, you can have multiple conditions in an \"if\" statement using logical operators such as \"and\" and \"or.\"");
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
    private void btnP_conditional_Q2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("How do I handle multiple conditions using the \"if-elif-else\" statement in Python?");
        alertDialogBuilder.setMessage("The \"if-elif-else\" sentence in Python allows you to handle several situations. You can assess many conditions in a cascading fashion using the \"if-elif-else\" expression, and you can then run various blocks of code depending on the first condition that evaluates to true. Here is how to use it:\n" +
                "if condition1:\n" +
                "    # Code to execute if condition1 is true\n" +
                "elif condition2:\n" +
                "    # Code to execute if condition1 is false and condition2 is true\n" +
                "elif condition3:\n" +
                "    # Code to execute if condition1 and condition2 are false and condition3 is true\n" +
                "else:\n" +
                "    # Code to execute if all conditions are false\n");
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
    private void btnP_conditional_Q3() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("How do I write an \"if-else\" statement in Python?");
        alertDialogBuilder.setMessage("The following syntax can be used to create a \"if-else\" statement in Python:\n" +
                "if condition:\n" +
                "    # Code to execute if the condition is true\n" +
                "else:\n" +
                "    # Code to execute if the condition is false\n");
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