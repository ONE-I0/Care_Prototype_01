package com.example.care_prototype_01.JavaLessonsActivity.JavaIntroductionFragments;

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


public class JavaIntroductionFragment_1 extends Fragment {
    private MediaPlayer question_sounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_java_introduction_1, container, false);

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
        alertDialogBuilder.setIcon(R.drawable.codey_java_cut);
        alertDialogBuilder.setTitle("Did you know!");
        alertDialogBuilder.setMessage("Java’s original name was “Oak”? However, the team developers of this programming language found out that the word was already used and trademarked so they had to come up with a new brand name. Since the team loves coffee, they eventually settled with “Java” that refers to coffee that comes from the Indonesian island of Java. Therefore, one of the most popular programming languages that is being used by today’s generation was named after a type of coffee!");
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