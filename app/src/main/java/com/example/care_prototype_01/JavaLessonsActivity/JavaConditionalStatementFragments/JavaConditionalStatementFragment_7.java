package com.example.care_prototype_01.JavaLessonsActivity.JavaConditionalStatementFragments;

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


public class JavaConditionalStatementFragment_7 extends Fragment {

    private MediaPlayer question_sounds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_java_conditional_statement_7, container, false);

        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);


        Button btnP_loop_Q1 = view.findViewById(R.id.P_loop_btnQ1);
        Button btnP_loop_Q2 = view.findViewById(R.id.P_loop_btnQ2);
        Button btnP_loop_Q3 = view.findViewById(R.id.P_loop_btnQ3);
        btnP_loop_Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_loop_Q1();
            }
        });
        btnP_loop_Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_loop_Q2();
            }
        });
        btnP_loop_Q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_loop_Q3();
            }
        });
        return view;
    }
    private void btnP_loop_Q1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_java_cut);
        alertDialogBuilder.setTitle("What happens if a condition in the \"else if\" statement is true?");
        alertDialogBuilder.setMessage("If a condition in the \"else if\" statement is true, the corresponding code block associated with that condition will be executed. Once a condition is true, the remaining conditions in the \"else if\" statement are not checked.");
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
    private void btnP_loop_Q2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_java_cut);
        alertDialogBuilder.setTitle("What is the difference between \"==\" and \".equals()\" when comparing objects in Java's conditional statements?");
        alertDialogBuilder.setMessage("The \"==\" operator determines if two objects' memory instances are identically identical.\n" +
                "The .equals() method determines whether two objects are equal by comparing their values or properties.\n");
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
    private void btnP_loop_Q3() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_java_cut);
        alertDialogBuilder.setTitle("How can I verify many conditions with a\"if\" statement in java?");
        alertDialogBuilder.setMessage("You can do so by using logical operators like \"&&\" (AND) and \"||\" (OR). While the \"||\" operator determines whether each condition is true, the \"&&\" operator determines whether both criteria are true.");
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