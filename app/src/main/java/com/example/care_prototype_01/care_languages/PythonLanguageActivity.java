package com.example.care_prototype_01.care_languages;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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
        });
        btnPythonComments.setOnClickListener(view -> {
            Intent OpenPythonComments = new Intent(PythonLanguageActivity.this, PythonComments.class);
            startActivity(OpenPythonComments);
        });
        btnPythonSyntax.setOnClickListener(view -> {
            Intent OpenPythonSyntax = new Intent(PythonLanguageActivity.this, PythonSyntax.class);
            startActivity(OpenPythonSyntax);
        });
        btnPythonVariables.setOnClickListener(view -> {
            Intent OpenPythonVariables = new Intent(PythonLanguageActivity.this, PythonVariables.class);
            startActivity(OpenPythonVariables);
        });
        btnPythonInputs.setOnClickListener(view -> {
            Intent OpenPythonInputs = new Intent(PythonLanguageActivity.this, PythonInputs.class);
            startActivity(OpenPythonInputs);
        });
        btnPythonDataTypes.setOnClickListener(view -> {
            Intent OpenPythonDataTypes = new Intent(PythonLanguageActivity.this, PythonDataTypes.class);
            startActivity(OpenPythonDataTypes);
        });
        btnPythonOperators.setOnClickListener(view -> {
            Intent OpenPythonOperators = new Intent(PythonLanguageActivity.this, PythonOperators.class);
            startActivity(OpenPythonOperators);
        });
        btnPythonConditionalStatements.setOnClickListener(view -> {
            Intent OpenPythonConditionalStatements = new Intent(PythonLanguageActivity.this, PythonConditionalStatement.class);
            startActivity(OpenPythonConditionalStatements);
        });
        btnPythonLoopingStatements.setOnClickListener(view -> {
            Intent OpenPythonLoopingStatements = new Intent(PythonLanguageActivity.this, PythonLoopingStatements.class);
            startActivity(OpenPythonLoopingStatements);
        });
        btnPythonArrays.setOnClickListener(view -> {
            Intent OpenPythonArrays = new Intent(PythonLanguageActivity.this, PythonArrays.class);
            startActivity(OpenPythonArrays);
        });
        btnPythonOop.setOnClickListener(view -> {
            Intent OpenPythonOop = new Intent(PythonLanguageActivity.this, PythonOOP.class);
            startActivity(OpenPythonOop);
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