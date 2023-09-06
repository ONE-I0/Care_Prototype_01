package com.example.care_prototype_01.care_languages;


import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.care_prototype_01.MainActivity;
import com.example.care_prototype_01.PythonLessons.PythonArrays;
import com.example.care_prototype_01.PythonLessons.PythonComments;
import com.example.care_prototype_01.PythonLessons.PythonConditionalStatement;
import com.example.care_prototype_01.PythonLessons.PythonDataTypes;
import com.example.care_prototype_01.PythonLessons.PythonInputs;
import com.example.care_prototype_01.PythonLessons.PythonIntroduction;
import com.example.care_prototype_01.PythonLessons.PythonLoopingStatements;
import com.example.care_prototype_01.PythonLessons.PythonOOP;
import com.example.care_prototype_01.PythonLessons.PythonOperators;
import com.example.care_prototype_01.PythonLessons.PythonSyntax;
import com.example.care_prototype_01.PythonLessons.PythonVariables;
import com.example.care_prototype_01.R;


public class PythonLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_language);

        Toolbar toolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);


        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        Button btnPythonIntroduction =findViewById(R.id.btnIntroduction);
        Button btnPythonComments =findViewById(R.id.btnComments);
        Button btnPythonSyntax =findViewById(R.id.btnSyntax);
        Button btnPythonVariables =findViewById(R.id.btnVariables);
        Button btnPythonInputs =findViewById(R.id.btnInputs);
        Button btnPythonDataTypes =findViewById(R.id.btnDataTypes);
        Button btnPythonOperators =findViewById(R.id.btnOperators);
        Button btnPythonConditionalStatements =findViewById(R.id.btnConditionalStatements);
        Button btnPythonLoopingStatements =findViewById(R.id.btnLoopingStatements);
        Button btnPythonArrays =findViewById(R.id.btnArrays);
        Button btnPythonOop=findViewById(R.id.btnOop);


        btnPythonIntroduction.setOnClickListener(view -> {
            Intent OpenPythonIntroduction = new Intent(PythonLanguageActivity.this, PythonIntroduction.class);
            startActivity(OpenPythonIntroduction);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        btnPythonComments.setOnClickListener(view -> {
            Intent OpenPythonComments = new Intent(PythonLanguageActivity.this, PythonComments.class);
            startActivity(OpenPythonComments);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        btnPythonSyntax.setOnClickListener(view -> {
            Intent OpenPythonSyntax = new Intent(PythonLanguageActivity.this, PythonSyntax.class);
            startActivity(OpenPythonSyntax);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        btnPythonVariables.setOnClickListener(view -> {
            Intent OpenPythonVariables = new Intent(PythonLanguageActivity.this, PythonVariables.class);
            startActivity(OpenPythonVariables);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        btnPythonInputs.setOnClickListener(view -> {
            Intent OpenPythonInputs = new Intent(PythonLanguageActivity.this, PythonInputs.class);
            startActivity(OpenPythonInputs);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        btnPythonDataTypes.setOnClickListener(view -> {
            Intent OpenPythonDataTypes = new Intent(PythonLanguageActivity.this, PythonDataTypes.class);
            startActivity(OpenPythonDataTypes);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        btnPythonOperators.setOnClickListener(view -> {
            Intent OpenPythonOperators = new Intent(PythonLanguageActivity.this, PythonOperators.class);
            startActivity(OpenPythonOperators);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        btnPythonConditionalStatements.setOnClickListener(view -> {
            Intent OpenPythonConditionalStatements = new Intent(PythonLanguageActivity.this, PythonConditionalStatement.class);
            startActivity(OpenPythonConditionalStatements);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        btnPythonLoopingStatements.setOnClickListener(view -> {
            Intent OpenPythonLoopingStatements = new Intent(PythonLanguageActivity.this, PythonLoopingStatements.class);
            startActivity(OpenPythonLoopingStatements);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        btnPythonArrays.setOnClickListener(view -> {
            Intent OpenPythonArrays = new Intent(PythonLanguageActivity.this, PythonArrays.class);
            startActivity(OpenPythonArrays);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        btnPythonOop.setOnClickListener(view -> {
            Intent OpenPythonOop = new Intent(PythonLanguageActivity.this, PythonOOP.class);
            startActivity(OpenPythonOop);
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