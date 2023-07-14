package com.example.care_prototype_01.JavaLessonsActivity.JavaOopFragments;

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

import com.example.care_prototype_01.CSharpLessons.CSharpOopFragments.CSharpOopFragment_5;
import com.example.care_prototype_01.R;


public class JavaOopFragment_5 extends Fragment {

    private static final int TEXT_SIZE_IN_DP = 25;
    private MediaPlayer question_sounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_java_oop_5, container, false);

        // Example sing line comment
        WebView codeWebView_P_looping1 = view.findViewById(R.id.car_code_java);
        String formattedCode_P_looping1  = getString(R.string.car_code_java);
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
        return Math.round(JavaOopFragment_5.TEXT_SIZE_IN_DP * density);
    }

    private void btnP_Oop_Q1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Why are classes and objects fundamental in Java?");
        alertDialogBuilder.setMessage("Classes and objects are fundamental in Java as they form the basis of OOP. Classes define the attributes and behaviors that objects of that class will have. Objects are instances of classes and represent real-world entities, allowing manipulation of data and execution of methods.");
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
        alertDialogBuilder.setTitle("How does Java support the concept of \"has-a\" relationship in OOP?");
        alertDialogBuilder.setMessage("In Java, the \"has-a\" relationship can be represented using composition or aggregation. Composition involves creating an instance of one class within another class, indicating a strong ownership relationship where the child object cannot exist without the parent object. Aggregation represents a looser relationship where an object can exist independently but is associated with another object.");
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
        alertDialogBuilder.setTitle("Can multiple inheritance be achieved in Java?");
        alertDialogBuilder.setMessage("No, Java does not support multiple inheritance of classes. However, it supports multiple inheritance of interfaces. This means that a class can implement multiple interfaces, allowing it to define and provide the implementation for multiple sets of behaviors.");
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