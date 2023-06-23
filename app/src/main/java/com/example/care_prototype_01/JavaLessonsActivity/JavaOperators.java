package com.example.care_prototype_01.JavaLessonsActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.care_prototype_01.R;

public class JavaOperators extends AppCompatActivity {
    Button btn_DYK_1,btn_DYK_2,btn_question1, btn_question2, btn_question3;
    private MediaPlayer question_sounds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_operators);


        //declare for the sounds
        question_sounds = MediaPlayer.create(JavaOperators.this, R.raw.question);

        //this will open the did you know in syntax
        btn_DYK_1 = findViewById(R.id.btndyk1);
        btn_DYK_1.setOnClickListener(view ->
                openDYK1()
        );
        btn_question1 = findViewById(R.id.btnquestion1);
        btn_question1.setOnClickListener(view ->
                OpenQuestion1()
        );
        btn_question2 = findViewById(R.id.btnquestion2);
        btn_question2.setOnClickListener(view ->
                OpenQuestion2()
        );
        btn_question3 = findViewById(R.id.btnquestion3);
        btn_question3.setOnClickListener(view ->
                OpenQuestion3()
        );
    }
    private void openDYK1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaOperators.this);
        builder.setTitle("Did you know?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("ava has a variety of operators you may use to perform different operations on variables and values? Here are a few illustrations of Java operators:  ")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void OpenQuestion1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaOperators.this);
        builder.setTitle("What is the arithmetic operator used for addition in Java?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("The arithmetic operator used for addition in Java is the plus operator (+).")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void OpenQuestion2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaOperators.this);
        builder.setTitle("What is the assignment operator used to assign a value to a variable in Java?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("The assignment operator used to assign a value to a variable in Java is the equals operator (=).")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void OpenQuestion3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaOperators.this);
        builder.setTitle("What is the comparison operator used to check if two values are equal in Java?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("The comparison operator used to check if two values are equal in Java is the double equals operator (==).")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
}