package com.example.care_prototype_01.CSharpLessons.CSharpVariablesFragments;

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


public class CSharpVariablesFragment_3 extends Fragment {


    private MediaPlayer question_sounds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c_sharp_variables_3, container, false);

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
        alertDialogBuilder.setIcon(R.drawable.codey_c_cut);
        alertDialogBuilder.setTitle("What does a question mark after a variable mean in C#?");
        alertDialogBuilder.setMessage("It means that the value type in question is a nullable type. Nullable types are instances of the System. Nullable struct. A nullable type can represent the correct range of values for its underlying value type, plus an additional null value.");
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
        alertDialogBuilder.setIcon(R.drawable.codey_c_cut);
        alertDialogBuilder.setTitle("Can I have multiple conditions in an if statement in C#?");
        alertDialogBuilder.setMessage("The C# var keyword is used to declare implicit type variables in C#.\n" +
                "var name = \"C# Corner\"; // Implicitly typed.\n" +
                "string name = \"C# Corner\"; // Explicitly typed.\n" +
                "var age = 30;");
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
        alertDialogBuilder.setIcon(R.drawable.codey_c_cut);
        alertDialogBuilder.setTitle("How do I write nested conditional statements in C#?");
        alertDialogBuilder.setMessage("Variable names can contain letters, digits, and the underscore _ only. Variable names must start with a letter. Variable names are case-sensitive, num and Num are considered different names. Variable names cannot contain reserved keywords.");
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