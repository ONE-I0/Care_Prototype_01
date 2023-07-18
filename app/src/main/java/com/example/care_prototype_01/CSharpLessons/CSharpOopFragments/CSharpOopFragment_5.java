package com.example.care_prototype_01.CSharpLessons.CSharpOopFragments;

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

import com.example.care_prototype_01.PythonLessons.PythonOopFragments.PythonOopFragment_5;
import com.example.care_prototype_01.R;


public class CSharpOopFragment_5 extends Fragment {

    private static final int TEXT_SIZE_IN_DP = 25;
    private MediaPlayer question_sounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c_sharp_oop_5, container, false);

        // Example sing line comment
        WebView codeWebView_P_looping1 = view.findViewById(R.id.car_code);
        String formattedCode_P_looping1  = getString(R.string.car_code);
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
        return Math.round(CSharpOopFragment_5.TEXT_SIZE_IN_DP * density);
    }

    private void btnP_Oop_Q1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_c_cut);
        alertDialogBuilder.setTitle("Can you achieve method overloading in C#?");
        alertDialogBuilder.setMessage("Yes, C# supports method overloading, which allows you to define multiple methods with the same name but different parameters in a class. The compiler determines which method to call based on the arguments provided.");
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
        alertDialogBuilder.setIcon(R.drawable.codey_c_cut);
        alertDialogBuilder.setTitle("Can C# classes support multiple inheritance?");
        alertDialogBuilder.setMessage("No, C# does not support multiple inheritance for classes. However, you can achieve similar functionality using interfaces, which allow a class to implement multiple interfaces.");
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
        alertDialogBuilder.setIcon(R.drawable.codey_c_cut);
        alertDialogBuilder.setTitle("Why is polymorphism beneficial in C#?");
        alertDialogBuilder.setMessage("Polymorphism in C# allows objects of different classes to be treated as objects of a common base class or interface. It promotes flexibility and extensibility in the code, enables method overriding, and facilitates writing generalized code that can work with objects of different types.");
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