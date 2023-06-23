package com.example.care_prototype_01.JavaLessonsActivity;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.care_prototype_01.R;

public class JavaIntroduction extends AppCompatActivity {

    Button btn_trivia, btn_question1, btn_question2, btn_question3;
    private MediaPlayer question_sounds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_introduction);

        //declare for the sounds
        question_sounds = MediaPlayer.create(JavaIntroduction.this, R.raw.question);


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

        btn_trivia = findViewById(R.id.btnTrivia);
        btn_trivia.setOnClickListener(view ->
                OpenAlertBox()
        );
    }

    private void OpenAlertBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaIntroduction.this);
        builder.setTitle("Codey's Trivia Sentence")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("Did you know that Java was originally named \"Oak\"? The language was initially developed by James Gosling and his team at Sun Microsystems in the early 1990s. However, they discovered that the name \"Oak\" was already trademarked, so they had to come up with a new name. They brainstormed various alternatives and eventually settled on \"Java\" inspired by their love for coffee. The name \"Java\" refers to the coffee that comes from the Indonesian island of Java. So, the programming language we know today as Java was named after a type of coffee!")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }

    private void openQuestion1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaIntroduction.this);
        builder.setTitle("Is Java a programming or scripting language?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("Java is primarily considered a programming language rather than a scripting language. In Java, the source code is compiled into bytecode, which is then executed by a Java Virtual Machine (JVM). This compilation step helps to optimize performance and allows the code to be run on any platform with a compatible JVM.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }

    private void openQuestion2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaIntroduction.this);
        builder.setTitle("What makes JAVA different to other languages?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("Compared to other programming languages, Java is fast, reliable and secure. From desktop to web applications, scientific supercomputers to gaming consoles, cell phones to the Internet, Java is used in every nook and corner.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void openQuestion3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaIntroduction.this);
        builder.setTitle("What makes Java so unique?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("Because it is one of the main programming languages, Java has a vast and thriving developer community worldwide. The community contributes to the continuous growth and improvement of Java by sharing knowledge, developing frameworks, tools, and libraries, and providing support to fellow developers. The active community ensures that Java remains relevant and up-to-date with emerging trends and technologies. Thus, it is easy to learn Java and there are so many resources available that can be searched online.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
}

