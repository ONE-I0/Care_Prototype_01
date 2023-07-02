package com.example.care_prototype_01.PythonLessons.PythonIntroductionFragments;

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


public class PythonIntroductionFragment_3 extends Fragment {

    Button btn_DYK_1,btn_DYK_2,btn_question1, btn_question2, btn_question3;;
    private MediaPlayer question_sounds;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_python_introduction_3, container, false);

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
        alertDialogBuilder.setTitle("What is Python known for?\n");
        alertDialogBuilder.setMessage("Python is known as the easiest programming language. Because of its syntax that is very close to the language of human, everyone can easily understand the flow of sequence in its codes!\n");
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
        alertDialogBuilder.setTitle("What is the edge of Python compared to other programming languages?\n");
        alertDialogBuilder.setMessage("Python is vert well known that emphasizes code readability and simplicity. Compared to other languages, Python has a clean and intuitive syntax that allows, not only developers but also beginners, to express any concepts in a more concise and natural way that makes it easier to learn, understand, and maintain codes.\n");
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
        alertDialogBuilder.setTitle("What type of language does Python belong?\n");
        alertDialogBuilder.setMessage("Python is considered an interpreted language. When writing a Python code, it is executed by the interpreter line by line without the need for explicit compilation. The interpreter reads the code then interprets it, and executes it directly, translating the code into machine instructions and prints it out into human-readable output.\n");
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