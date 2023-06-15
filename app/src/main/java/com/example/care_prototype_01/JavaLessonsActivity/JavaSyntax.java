package com.example.care_prototype_01.JavaLessonsActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.care_prototype_01.R;

public class JavaSyntax extends AppCompatActivity {
    Button btn_DYK_1,btn_question1, btn_question2, btn_question3;
    Button btn_ans_01;

    TextView answer;
    ImageView answer_1;
    private MediaPlayer question_sounds;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_syntax);

        //declare for the sounds
        question_sounds = MediaPlayer.create(JavaSyntax.this, R.raw.question);


        //declare R.id For the answer of syntax
        answer = (TextView) findViewById(R.id.AnswerCodeyTextView);
        answer_1 = (ImageView) findViewById(R.id.AnswerCodeyImage);

        //this will open the answer for syntax
        btn_ans_01 = findViewById(R.id.btnAnswer01);
        btn_ans_01.setOnClickListener(view ->
                openANS_1()
        );
        //this will open the did you know in syntax
        btn_DYK_1 = findViewById(R.id.btdyk1);
        btn_DYK_1.setOnClickListener(view ->
                openDYK1()
        );

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


    private void openDYK1() {


        AlertDialog.Builder builder = new AlertDialog.Builder(JavaSyntax.this);
        builder.setTitle("Did you know?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("identifiers in Java are case-sensitive? It is because Java identifies any lowercase and uppercase letters as distinct characters. This means that even though there are two identical words written in the code, the program treats it as two separate identifiers in Java!")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();



    }
    private void openANS_1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaSyntax.this);
        builder.setTitle("Answer is!")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("Output:\n" +
                        "Hello World\n")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();

        //this will let the invisible sentence and image for codey to visible
        answer.setVisibility(View.VISIBLE);
        answer_1.setVisibility(View.VISIBLE);
    }


    //program for the three questions
    private void openQuestion1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaSyntax.this);
        builder.setTitle("What will happen if I declare two variables with same spelling but different values?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("The program will give an error to the output because it cannot determine which of the two is being called out to the execution of the code.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();

    }

    private void openQuestion2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaSyntax.this);
        builder.setTitle("Can I make a program without using an identifier?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("The answer is No. Even at the start of making a program, the first thing that you will see in the code is the main method. Removing it will cause an error to the whole code.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void openQuestion3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaSyntax.this);
        builder.setTitle(" What is the difference of identifier to keyword?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("Keywords are reserved words that have a special meaning in the programming language. Therefore, using a keyword as an identifier is prohibited because it has a distinct meaning that can be interpreted by the compiler.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
}