package com.example.care_prototype_01.PythonLessons.PythonOopFragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.example.care_prototype_01.PythonLessons.PythonLoopingStatementsFragments.PythonLoopingStatementFragment_5;
import com.example.care_prototype_01.R;

public class PythonOopFragment_5 extends Fragment {

    private static final int TEXT_SIZE_IN_DP = 20;
    private MediaPlayer question_sounds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_python_oop_5, container, false);

        // Example sing line comment
        WebView codeWebView_P_looping1 = view.findViewById(R.id.python_car_class_example);
        String formattedCode_P_looping1  = getString(R.string.python_car_class_example);
        String htmlContent_P_loopingl1  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping1);
        configureWebView(codeWebView_P_looping1, htmlContent_P_loopingl1);
//declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);


        Button btnP_Oop_Q1 = view.findViewById(R.id.P_Oop_btnQ1);
        Button btnP_Oop_Q2 = view.findViewById(R.id.P_Oop_btnQ2);
        Button btnP_Oop_Q3 = view.findViewById(R.id.P_Oop_btnQ3);
        btnP_Oop_Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_Oop_Q1();
            }
        });
        btnP_Oop_Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_Oop_Q2();
            }
        });
        btnP_Oop_Q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_Oop_Q3();
            }
        });
        return view;
    }

    // This is the setting for the actual code view
    private void configureWebView(WebView webView, String htmlContent) {
        webView.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null);
        webView.setBackgroundColor(0xd3d3d3); // Set the background color
        webView.setBackgroundResource(R.drawable.callout_background); // Set rounded corners
        WebSettings webSettings = webView.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
    }

    private int dpToPx() {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(PythonOopFragment_5.TEXT_SIZE_IN_DP * density);
    }

    private void btnP_Oop_Q1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Does Python support multiple inheritance?");
        alertDialogBuilder.setMessage("Yes, Python supports multiple inheritance, which means a class can inherit from multiple base classes. This allows the subclass to inherit attributes and methods from multiple parent classes.");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // You can add some action here when the user clicks "OK"
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void btnP_Oop_Q2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Can you achieve method overloading in Python?");
        alertDialogBuilder.setMessage("Python does not directly support method overloading as seen in some other languages. However, you can achieve similar functionality by using default arguments or variable-length argument lists in a single method.");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // You can add some action here when the user clicks "OK"
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void btnP_Oop_Q3() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Why is abstraction achieved using abstract classes in Python?");
        alertDialogBuilder.setMessage("Abstraction is achieved using abstract classes in Python because they provide a way to define common properties and behaviors without specifying implementation details. Abstract classes cannot be instantiated and serve as blueprints for subclasses to implement specific functionality. They enable code organization, promote code reuse, and establish a contract for implementing classes.");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // You can add some action here when the user clicks "OK"
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
}