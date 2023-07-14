package com.example.care_prototype_01.CSharpLessons.CSharpOopFragments;

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


public class CSharpOopFragment_1 extends Fragment {
    private MediaPlayer question_sounds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c_sharp_oop_1, container, false);

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
        alertDialogBuilder.setMessage("did you know that Object-oriented programming has several advantages over procedural programming: \n" +
                "• C# has a clean and expressive syntax that is easy to read and understand. And it was designed to resemble natural language constructs, making it accessible to beginners and comfortable for experienced developers.\n" +
                "• C# is considered a user-friendly programming language\n" +
                "• OOP provides a clear structure for the programs. \n" +
                "• OOP helps to keep the c# code DRY \"Don't Repeat Yourself\", and makes the code easier to maintain, modify and debug. \n" +
                "• OOP makes it possible to create full reusable applications with less code and shorter development time. \n");
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
        alertDialogBuilder.setMessage("The performance of object-oriented programming (OOP) in c# may not always be faster");
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
        alertDialogBuilder.setMessage("Take note: To create a class, use the keyword class.");
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