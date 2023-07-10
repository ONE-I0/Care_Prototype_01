package com.example.care_prototype_01.PythonLessons.PythonOopFragments;

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

public class PythonOopFragment_1 extends Fragment {

    private MediaPlayer question_sounds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_python_oop_1, container, false);

        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);

        Button btnShowAlertDialog = view.findViewById(R.id.python_Oop_DYK);
        btnShowAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDYK1();
            }
        });

        Button btnShowAlertDialog1 = view.findViewById(R.id.python_Oop_NOTE);
        btnShowAlertDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNOTE1();
            }
        });

        Button btnShowAlertDialog2 = view.findViewById(R.id.python_Oop_TIP);
        btnShowAlertDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTIP1();
            }
        });

        Button btnShowAlertDialog3 = view.findViewById(R.id.python_Oop_NOTE2);
        btnShowAlertDialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNote2();
            }
        });

        return view;
    }

    private void showDYK1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Did you know!");
        alertDialogBuilder.setMessage("Did you know that Object-oriented programming (OOP) offers numerous advantages over procedural programming. Firstly, it provides a clear and organized structure for programs, making them easier to understand and maintain. Additionally, OOP helps to uphold the principle of \"Don't Repeat Yourself\" (DRY) in Python code, reducing redundancy and enhancing efficiency. Moreover, OOP simplifies the process of debugging and modifying code, thereby increasing its overall maintainability.");
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

    private void showNOTE1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Take Note!");
        alertDialogBuilder.setMessage("Take note the performance of object-oriented programming (OOP) in Python may not always be faster");
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

    private void showTIP1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Tip!");
        alertDialogBuilder.setMessage("The \"Don't Repeat Yourself\" (DRY) principle is about reducing the repetition of code. You should extract out the codes that are common for the application, and place them at a single place and reuse them instead of repeating it.");
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

    private void showNote2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Take Note!");
        alertDialogBuilder.setMessage("take note: To create a class, use the keyword class.");
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