package com.example.care_prototype_01.care_languages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.care_prototype_01.CSharpLessons.CSharpArrays;
import com.example.care_prototype_01.CSharpLessons.CSharpComments;
import com.example.care_prototype_01.CSharpLessons.CSharpConditionalStatements;
import com.example.care_prototype_01.CSharpLessons.CSharpDataTypes;
import com.example.care_prototype_01.CSharpLessons.CSharpInputs;
import com.example.care_prototype_01.CSharpLessons.CSharpIntroduction;
import com.example.care_prototype_01.CSharpLessons.CSharpLoopingStatements;
import com.example.care_prototype_01.CSharpLessons.CSharpOop;
import com.example.care_prototype_01.CSharpLessons.CSharpOperator;
import com.example.care_prototype_01.CSharpLessons.CSharpSyntax;
import com.example.care_prototype_01.CSharpLessons.CSharpVariables;
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

public class CSharpLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csharp_language);

        Button btnCIntroduction =findViewById(R.id.btnIntroduction);
        Button btnCComments =findViewById(R.id.btnComments);
        Button btnCSyntax =findViewById(R.id.btnSyntax);
        Button btnCVariables =findViewById(R.id.btnVariables);
        Button btnCInputs =findViewById(R.id.btnInputs);
        Button btnCDataTypes =findViewById(R.id.btnDataTypes);
        Button btnCOperators =findViewById(R.id.btnOperators);
        Button btnCConditionalStatements =findViewById(R.id.btnConditionalStatements);
        Button btnCLoopingStatements =findViewById(R.id.btnLoopingStatements);
        Button btnCArrays =findViewById(R.id.btnArrays);
        Button btnCOop=findViewById(R.id.btnOop);

        btnCIntroduction.setOnClickListener(view -> {
            Intent OpenCIntroduction = new Intent(CSharpLanguageActivity.this, CSharpIntroduction.class);
            startActivity(OpenCIntroduction);
        });
        btnCComments.setOnClickListener(view -> {
            Intent OpenCComments = new Intent(CSharpLanguageActivity.this, CSharpComments.class);
            startActivity(OpenCComments);
        });
        btnCSyntax.setOnClickListener(view -> {
            Intent OpenCSyntax = new Intent(CSharpLanguageActivity.this, CSharpSyntax.class);
            startActivity(OpenCSyntax);
        });
        btnCVariables.setOnClickListener(view -> {
            Intent OpenCVariables = new Intent(CSharpLanguageActivity.this, CSharpVariables.class);
            startActivity(OpenCVariables);
        });
        btnCInputs.setOnClickListener(view -> {
            Intent OpenCInputs = new Intent(CSharpLanguageActivity.this, CSharpInputs.class);
            startActivity(OpenCInputs);
        });
        btnCDataTypes.setOnClickListener(view -> {
            Intent OpenCDataTypes = new Intent(CSharpLanguageActivity.this, CSharpDataTypes.class);
            startActivity(OpenCDataTypes);
        });
        btnCOperators.setOnClickListener(view -> {
            Intent OpenCOperators = new Intent(CSharpLanguageActivity.this, CSharpOperator.class);
            startActivity(OpenCOperators);
        });
        btnCConditionalStatements.setOnClickListener(view -> {
            Intent OpenCConditionalStatements = new Intent(CSharpLanguageActivity.this, CSharpConditionalStatements.class);
            startActivity(OpenCConditionalStatements);
        });
        btnCLoopingStatements.setOnClickListener(view -> {
            Intent OpenCLoopingStatements = new Intent(CSharpLanguageActivity.this, CSharpLoopingStatements.class);
            startActivity(OpenCLoopingStatements);
        });
        btnCArrays.setOnClickListener(view -> {
            Intent OpenCArrays = new Intent(CSharpLanguageActivity.this, CSharpArrays.class);
            startActivity(OpenCArrays);
        });
        btnCOop.setOnClickListener(view -> {
            Intent OpenCOop = new Intent(CSharpLanguageActivity.this, CSharpOop.class);
            startActivity(OpenCOop);
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