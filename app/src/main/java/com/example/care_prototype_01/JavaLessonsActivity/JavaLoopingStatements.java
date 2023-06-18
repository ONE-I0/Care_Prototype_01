package com.example.care_prototype_01.JavaLessonsActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.care_prototype_01.R;

public class JavaLoopingStatements extends AppCompatActivity {
    Button btn_dyk1, btn_dyk2, btn_dyk3;
    private MediaPlayer question_sounds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_looping_statements);

        //declare for the sounds
        question_sounds = MediaPlayer.create(JavaLoopingStatements.this, R.raw.question);

        btn_dyk1 = findViewById(R.id.javaloopdyk1);
        btn_dyk1.setOnClickListener(view ->
                openDYK1()
        );
        btn_dyk1 = findViewById(R.id.javaloopdyk2);
        btn_dyk1.setOnClickListener(view ->
                openDYK2()
        );
        btn_dyk3 = findViewById(R.id.javaloopdyk3);
        btn_dyk3.setOnClickListener(view ->
                openDYK3()
        );

    }
    private void openDYK1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaLoopingStatements.this);
        builder.setTitle("Did you know?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("did you know the loop body is executed repeatedly as long as the condition is true.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void openDYK2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaLoopingStatements.this);
        builder.setTitle("Did you know?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("did you know the condition is checked at the end of each iteration. If the condition is true, the loop continues.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void openDYK3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaLoopingStatements.this);
        builder.setTitle("Did you know?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("did you know the correct syntax for the foreach loop (also known as the enhanced for loop)")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }



}