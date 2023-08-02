package com.example.care_prototype_01.care_languages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

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
        });

        btnJavaSyntax.setOnClickListener(view -> {
            Intent OpenJavaSyntax = new Intent(JavaLanguageActivity.this, JavaSyntax.class);
            startActivity(OpenJavaSyntax);
        });

        btnJavaComments.setOnClickListener(view -> {
            Intent OpenJavaComments = new Intent(JavaLanguageActivity.this, JavaComments.class);
            startActivity(OpenJavaComments);
        });

        btnJavaVariables.setOnClickListener(view -> {
            Intent OpenJavaVariables = new Intent(JavaLanguageActivity.this, JavaVariables.class);
            startActivity(OpenJavaVariables);
        });

        btnJavaInputs.setOnClickListener(view -> {
            Intent OpenJavaInputs = new Intent(JavaLanguageActivity.this, JavaInputs.class);
            startActivity(OpenJavaInputs);
        });

        btnJavaDataTypes.setOnClickListener(view -> {
            Intent OpenJavaDataTypes = new Intent(JavaLanguageActivity.this, JavaDataTypes.class);
            startActivity(OpenJavaDataTypes);
        });

        btnJavaOperators.setOnClickListener(view -> {
            Intent OpenJavaOperators = new Intent(JavaLanguageActivity.this, JavaOperators.class);
            startActivity(OpenJavaOperators);
        });

        btnJavaConditionalStatements.setOnClickListener(view -> {
            Intent OpenJavaConditionalStatements = new Intent(JavaLanguageActivity.this, JavaConditionalStatements.class);
            startActivity(OpenJavaConditionalStatements);
        });

        btnJavaLoopingStatements.setOnClickListener(view -> {
            Intent OpenJavaLoopingStatements = new Intent(JavaLanguageActivity.this, JavaLoopingStatements.class);
            startActivity(OpenJavaLoopingStatements);
        });

        btnJavaArrays.setOnClickListener(view -> {
            Intent OpenJavaArrays = new Intent(JavaLanguageActivity.this, JavaArray.class);
            startActivity(OpenJavaArrays);
        });
        btnJavaOop.setOnClickListener(view -> {
            Intent OpenJavaOop = new Intent(JavaLanguageActivity.this, JavaOop.class);
            startActivity(OpenJavaOop);
        });
    }
    @Override
    public void onBackPressed() {
        // Create an intent to navigate to MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        // Clear the back stack so that the user cannot navigate back to JavaLanguageActivity
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        // Finish the current activity so that it's removed from the back stack
        finish();
    }
}