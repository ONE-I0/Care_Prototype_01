package com.example.care_prototype_01.JavaLessonsActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.care_prototype_01.R;

public class JavaComments extends AppCompatActivity {
    Button btn_question1, btn_question2, btn_question3;
    private MediaPlayer question_sounds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_comments);

        //declare for the sounds
        question_sounds = MediaPlayer.create(JavaComments.this, R.raw.question);

        //this will open the three questions
        btn_question1 = findViewById(R.id.btnquestion1);
        btn_question1.setOnClickListener(view ->
                openQuestion1()
        );

        btn_question2 = findViewById(R.id.btnquestion2);
        btn_question2.setOnClickListener(view ->
                openQuestion2()
        );

        btn_question3 = findViewById(R.id.btnquestion3);
        btn_question3.setOnClickListener(view ->
                openQuestion3()
        );
    }

    private void openQuestion1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaComments.this);
        builder.setTitle("What is the purpose of comments in Java?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("The Comments in Java is not just a decorative text written in the code, rather, it serves its own purpose by adding explanatory or descriptive text that helps everyone who will read the code easily understand the meaning of its function.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }

    private void openQuestion2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaComments.this);
        builder.setTitle("What is the difference of a single-line vs multi-line comment?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("Single-line comments (‘//’) are suitable for short explanations that usually takes up on a single line only and these are used to clarify variable declarations, providing context, or briefly describing the code. Multi-line comments (‘/* … */’), on the other hand, are useful for long explanations, disabling blocks of code temporarily, or putting out a large section of comment into the code.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();

    }

    private void openQuestion3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaComments.this);
        builder.setTitle("Can comments slow down a program’s execution?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("The answer is No. Comments have no impact on the performance of the program and it does not slow execution speed of compiled bytecodes because it is not included when being interpreted by the compiler.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();

    }
}