package com.example.care_prototype_01.PythonLessons.PythonOperatorFragments;

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


public class PythonOperatorsFragment_3 extends Fragment {

    private MediaPlayer question_sounds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_python_operators_3, container, false);

        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);


        Button btnP_Operator_Q1 = view.findViewById(R.id.P_Operator_btnQ1);
        Button btnP_Operator_Q2 = view.findViewById(R.id.P_Operator_btnQ2);
        Button btnP_Operator_Q3 = view.findViewById(R.id.P_Operator_btnQ3);
        btnP_Operator_Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                P_Operator_btnQ1();
            }
        });
        btnP_Operator_Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                P_Operator_btnQ2();
            }
        });
        btnP_Operator_Q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                P_Operator_btnQ3();
            }
        });
        return view;
    }
    private void P_Operator_btnQ1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("What is the arithmetic operator used for exponentiation in Python?");
        alertDialogBuilder.setMessage("The arithmetic operator used for exponentiation in Python is the double asterisk (**) operator.");
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
    private void P_Operator_btnQ2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("What is the logical operator used to perform a logical AND operation in Python?");
        alertDialogBuilder.setMessage("The logical operator used to perform a logical AND operation in Python is the \"and\" keyword.");
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
    private void P_Operator_btnQ3() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("What is the comparison operator used to check if two values are equal in Python?");
        alertDialogBuilder.setMessage("The comparison operator used to check if two values are equal in Python is the double equals sign (==) operator.");
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