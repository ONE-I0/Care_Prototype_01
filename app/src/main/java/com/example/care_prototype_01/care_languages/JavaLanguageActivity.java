package com.example.care_prototype_01.care_languages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.care_prototype_01.JavaLessonsActivity.JavaArray;
import com.example.care_prototype_01.JavaLessonsActivity.JavaComments;
import com.example.care_prototype_01.JavaLessonsActivity.JavaConditionalStatements;
import com.example.care_prototype_01.JavaLessonsActivity.JavaDataTypes;
import com.example.care_prototype_01.JavaLessonsActivity.JavaInputs;
import com.example.care_prototype_01.JavaLessonsActivity.JavaIntroduction;
import com.example.care_prototype_01.JavaLessonsActivity.JavaLoopingStatements;
import com.example.care_prototype_01.JavaLessonsActivity.JavaOop;
import com.example.care_prototype_01.JavaLessonsActivity.JavaOperators;
import com.example.care_prototype_01.JavaLessonsActivity.JavaSyntax;
import com.example.care_prototype_01.JavaLessonsActivity.JavaVariables;
import com.example.care_prototype_01.MainActivity;
import com.example.care_prototype_01.R;

public class JavaLanguageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_language);

        Toolbar toolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);


        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        Button btnJavaIntroduction =findViewById(R.id.btnIntroduction);
        Button btnJavaSyntax =  findViewById(R.id.btnSyntax);
        Button btnJavaComments =  findViewById(R.id.btnComments);
        Button btnJavaVariables =  findViewById(R.id.btnVariables);
        Button btnJavaInputs =  findViewById(R.id.btnInputs);
        Button btnJavaDataTypes =  findViewById(R.id.btnDataTypes);
        Button btnJavaOperators = findViewById(R.id.btnOperators);
        Button btnJavaConditionalStatements =  findViewById(R.id.btnConditionalStatements);
        Button btnJavaLoopingStatements =  findViewById(R.id.btnLoopingStatements);
        Button btnJavaArrays =  findViewById(R.id.btnArrays);
        Button btnJavaOop =  findViewById(R.id.btnOop);

        btnJavaIntroduction.setOnClickListener(view -> {
            Intent OpenJavaIntroduction = new Intent(JavaLanguageActivity.this, JavaIntroduction.class);
            startActivity(OpenJavaIntroduction);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });

        btnJavaSyntax.setOnClickListener(view -> {
            Intent OpenJavaSyntax = new Intent(JavaLanguageActivity.this, JavaSyntax.class);
            startActivity(OpenJavaSyntax);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });

        btnJavaComments.setOnClickListener(view -> {
            Intent OpenJavaComments = new Intent(JavaLanguageActivity.this, JavaComments.class);
            startActivity(OpenJavaComments);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });

        btnJavaVariables.setOnClickListener(view -> {
            Intent OpenJavaVariables = new Intent(JavaLanguageActivity.this, JavaVariables.class);
            startActivity(OpenJavaVariables);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });

        btnJavaInputs.setOnClickListener(view -> {
            Intent OpenJavaInputs = new Intent(JavaLanguageActivity.this, JavaInputs.class);
            startActivity(OpenJavaInputs);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });

        btnJavaDataTypes.setOnClickListener(view -> {
            Intent OpenJavaDataTypes = new Intent(JavaLanguageActivity.this, JavaDataTypes.class);
            startActivity(OpenJavaDataTypes);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });

        btnJavaOperators.setOnClickListener(view -> {
            Intent OpenJavaOperators = new Intent(JavaLanguageActivity.this, JavaOperators.class);
            startActivity(OpenJavaOperators);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });

        btnJavaConditionalStatements.setOnClickListener(view -> {
            Intent OpenJavaConditionalStatements = new Intent(JavaLanguageActivity.this, JavaConditionalStatements.class);
            startActivity(OpenJavaConditionalStatements);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });

        btnJavaLoopingStatements.setOnClickListener(view -> {
            Intent OpenJavaLoopingStatements = new Intent(JavaLanguageActivity.this, JavaLoopingStatements.class);
            startActivity(OpenJavaLoopingStatements);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });

        btnJavaArrays.setOnClickListener(view -> {
            Intent OpenJavaArrays = new Intent(JavaLanguageActivity.this, JavaArray.class);
            startActivity(OpenJavaArrays);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        btnJavaOop.setOnClickListener(view -> {
            Intent OpenJavaOop = new Intent(JavaLanguageActivity.this, JavaOop.class);
            startActivity(OpenJavaOop);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
    }
    @Override
    public void onBackPressed() {
        // Create an intent to start the MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        // Set custom animations for entering and exiting activities
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        // Finish the current activity (JavaLanguageActivity)
        finish();
    }
}