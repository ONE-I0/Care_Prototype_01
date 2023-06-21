package com.example.care_prototype_01.JavaLessonsActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.care_prototype_01.R;

public class JavaDataTypes extends AppCompatActivity {
    Button btn_DYK_1,btn_DYK_2,btn_question1, btn_question2, btn_question3;
    private MediaPlayer question_sounds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_data_types);

        //declare for the sounds
        question_sounds = MediaPlayer.create(JavaDataTypes.this, R.raw.question);

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
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaDataTypes.this);
        builder.setTitle("Did you know?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("Did you know that in Java, there are several built-in data types that you can use to store different kinds of values. ")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void OpenQuestion1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaDataTypes.this);
        builder.setTitle("What is the data type used to store whole numbers in Java?\n")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("The data type used to store whole numbers in Java is the \"int\" data type.\n")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void OpenQuestion2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaDataTypes.this);
        builder.setTitle("What is the data type used to store decimal numbers with single precision in Java?\n")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("The data type used to store decimal numbers with single precision in Java is the \"float\" data type.\n")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void OpenQuestion3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaDataTypes.this);
        builder.setTitle("What is the data type used to store a single character in Java?\n")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("The data type used to store a single character in Java is the \"char\" data type.\n")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
}