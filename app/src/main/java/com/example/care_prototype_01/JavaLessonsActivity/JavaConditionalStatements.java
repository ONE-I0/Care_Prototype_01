package com.example.care_prototype_01.JavaLessonsActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.care_prototype_01.R;

public class JavaConditionalStatements extends AppCompatActivity {
    Button btn_DYK_1,btn_DYK_2,btn_question1, btn_question2, btn_question3;;
    private MediaPlayer question_sounds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_conditional_statements);

        //declare for the sounds
        question_sounds = MediaPlayer.create(JavaConditionalStatements.this, R.raw.question);

        //this will open the did you know in syntax
        btn_DYK_1 = findViewById(R.id.btndyk);
        btn_DYK_1.setOnClickListener(view ->
                openDYK1()
        );
        btn_DYK_2 = findViewById(R.id.btndyk2);
        btn_DYK_2.setOnClickListener(view ->
                openDYK1()
        );
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
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaConditionalStatements.this);
        builder.setTitle("Did you know?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("did you know That if statement is the simplest form of a conditional statement.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void openDYK2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaConditionalStatements.this);
        builder.setTitle("Did you know?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("did you know that if is in lowercase letters. Uppercase letters (If or IF) will generate an error.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void openQuestion1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaConditionalStatements.this);
        builder.setTitle("What happens if a condition in the \"else if\" statement is true?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("-\tIf a condition in the \"else if\" statement is true, the corresponding code block associated with that condition will be executed. Once a condition is true, the remaining conditions in the \"else if\" statement are not checked.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }

    private void openQuestion2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaConditionalStatements.this);
        builder.setTitle("What is the difference between \"==\" and \".equals()\" when comparing objects in Java's conditional statements?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("The \"==\" operator determines if two objects' memory instances are identically identical.\n" +
                        "The.equals() method determines whether two objects are equal by comparing their values or properties.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();

    }

    private void openQuestion3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaConditionalStatements.this);
        builder.setTitle("How can I verify many conditions with a \"if\" statement in Java?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("you can do so by using logical operators like \"&&\" (AND) and \"||\" (OR). While the \"||\" operator determines whether each condition is true, the \"&&\" operator determines whether both criteria are true.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();

    }
}