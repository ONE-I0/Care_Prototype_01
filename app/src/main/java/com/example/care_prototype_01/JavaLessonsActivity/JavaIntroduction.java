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
    TextView bullet_introduction;
    TextView bullet_introduction2;
    TextView bullet_introduction3;
    TextView bullet_introduction4;
    TextView bullet_introduction5;
    TextView bullet_introduction6;
    private MediaPlayer question_sounds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_introduction);

        //declare for the sounds
        question_sounds = MediaPlayer.create(JavaIntroduction.this, R.raw.question);

        bullet_introduction = findViewById(R.id.introduction_bullet);
        String platform = "•\tPlatform Independence: Java is a \"write once, run anywhere\" language. This means that once you write a Java program, you can run it on any platform that has a Java Virtual Machine (JVM). The JVM acts as an interpreter, allowing the Java code to be executed on different operating systems.";
        SpannableString ss = new SpannableString(platform);
        StyleSpan BoldSpan = new StyleSpan(Typeface.BOLD);
        ss.setSpan(BoldSpan, 0, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        bullet_introduction.setText(ss);

        bullet_introduction2 = findViewById(R.id.introduction_bullet2);
        String OOP = "•\tObject-Oriented Programming: Java is an object-oriented programming (OOP) language. This means that it revolves around the concept of objects, which are instances of classes. Objects have attributes (variables) and behavior (methods), and they interact with each other through method calls.";
        SpannableString ss_oop = new SpannableString(OOP);
        StyleSpan BoldSpan_oop = new StyleSpan(Typeface.BOLD);
        ss_oop.setSpan(BoldSpan_oop, 0, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        bullet_introduction2.setText(ss_oop);

        bullet_introduction3 = findViewById(R.id.introduction_bullet3);
        String syntax = "•\tSyntax: Java has a syntax similar to other programming languages like C and C++. It uses semicolons to end statements and curly braces to define code blocks. The code is organized into classes, and each class can have methods and variables.";
        SpannableString ss_syntax = new SpannableString(syntax);
        StyleSpan BoldSpan_syntax = new StyleSpan(Typeface.BOLD);
        ss_syntax.setSpan(BoldSpan_syntax, 0, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        bullet_introduction3.setText(ss_syntax);

        bullet_introduction4 = findViewById(R.id.introduction_bullet4);
        String garbage = "•\tGarbage Collection: Java has automatic memory management through a process called garbage collection. It takes care of allocating and deallocating memory for objects, so developers don't have to explicitly manage memory resources. This helps in preventing memory leaks and makes Java programs more robust.";
        SpannableString ss_garbage = new SpannableString(garbage);
        StyleSpan BoldSpan_garbage = new StyleSpan(Typeface.BOLD);
        ss_garbage.setSpan(BoldSpan_garbage, 0, 21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        bullet_introduction4.setText(ss_garbage);

        bullet_introduction5 = findViewById(R.id.introduction_bullet5);
        String standard = "•\tStandard Library: Java provides a rich set of libraries and APIs (Application Programming Interfaces) that simplify common programming tasks. These libraries cover areas such as input/output, networking, data structures, graphics, and more. They save developers time and effort by providing pre-built functionality.";
        SpannableString ss_standard = new SpannableString(standard);
        StyleSpan BoldSpan_standard = new StyleSpan(Typeface.BOLD);
        ss_standard.setSpan(BoldSpan_standard, 0, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        bullet_introduction5.setText(ss_standard);

        bullet_introduction6 = findViewById(R.id.introduction_bullet6);
        String exception = "•\tException Handling: Java has a built-in exception handling mechanism that allows you to catch and handle errors and exceptional situations in your code. This helps in writing more reliable and robust programs by gracefully handling unexpected situations.";
        SpannableString ss_exception = new SpannableString(exception);
        StyleSpan BoldSpan_exception = new StyleSpan(Typeface.BOLD);
        ss_exception.setSpan(BoldSpan_exception, 0, 21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        bullet_introduction6.setText(ss_exception);


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

