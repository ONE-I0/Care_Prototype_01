package com.example.care_prototype_01.PythonLessons.PythonIntroductionFragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.care_prototype_01.JavaLessonsActivity.JavaArray;
import com.example.care_prototype_01.R;

public class  PythonIntroductionFragment_1 extends Fragment {

    Button btn_DYK_1,btn_DYK_2,btn_question1, btn_question2, btn_question3;;
    private MediaPlayer question_sounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_python_introduction_1, container, false);

        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);

        Button btnShowAlertDialog = view.findViewById(R.id.python_introduction_DYK1);
        btnShowAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDYK1();
            }
        });

        return view;
    }

    private void showDYK1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Alert");
        alertDialogBuilder.setMessage("Did you know that Python is not originally named after a snake? In fact, Guido van Rossum, the creator, was fan of a comedy group “Monty Python” and he chose the name to bring a sense of fun while using the programming language\n");
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
