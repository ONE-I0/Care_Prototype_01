package com.example.care_prototype_01.JavaLessonsActivity.JavaLoopingStatement;

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


public class JavaLoopingStatementFragment_6 extends Fragment {


    private MediaPlayer question_sounds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_java_looping_statement_6, container, false);

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
        alertDialogBuilder.setTitle("Can I create an infinite loop using a \"while\" loop in Java? How do I break out of it?");
        alertDialogBuilder.setMessage("Yes, a Java \"while\" loop can be used to build an infinite loop. An endless loop is a loop that never ends on its own and continues forever.\n" +
                "You can omit the condition or give an always true condition when using Java's \"while\" loop to construct an infinite loop. Here's an illustration:\n" +
                "while (true) {\n" +
                "    // Code statements\n" +
                "}\n" +
                "\tIn this case, the loop will run forever because the criterion true is always true.\n" +
                "-The \"break\" statement in Java can be used to exit an endless loop. You can break the loop early and leave it by using the \"break\" statement. Here's an illustration:\n" +
                "\twhile (true) {\n" +
                "   \t // Code statements\n" +
                "\n" +
                " \tif (condition) {\n" +
                "        \tbreak; // Exit the loop\n" +
                "    }\n" +
                "}\n" +
                "To determine whether a specific condition has been met in this example, a \"if\" statement with the provided condition is used. The \"break\" statement is invoked, ending the loop if the condition evaluates to true, and the program continues running after the loop.\n" +
                "\n" +
                "You can successfully get out of an infinite loop and manage the flow of your program by utilizing the \"break\" statement inside the loop.\n");
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
        alertDialogBuilder.setTitle("add here");
        alertDialogBuilder.setMessage("add here");
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
        alertDialogBuilder.setTitle("add here");
        alertDialogBuilder.setMessage("add here");
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