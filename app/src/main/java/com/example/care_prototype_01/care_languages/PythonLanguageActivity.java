package com.example.care_prototype_01.care_languages;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.care_prototype_01.PythonLessons.PythonIntroduction;
import com.example.care_prototype_01.R;

public class PythonLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_language);

        Button btnPythonIntroduction =findViewById(R.id.btnIntroduction);

        btnPythonIntroduction.setOnClickListener(view -> {
            Intent OpenJavaIntroduction = new Intent(PythonLanguageActivity.this, PythonIntroduction.class);
            startActivity(OpenJavaIntroduction);
        });
    }
}