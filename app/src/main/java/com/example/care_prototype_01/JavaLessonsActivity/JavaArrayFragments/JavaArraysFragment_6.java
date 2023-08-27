package com.example.care_prototype_01.JavaLessonsActivity.JavaArrayFragments;

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

import com.example.care_prototype_01.R;

public class JavaArraysFragment_6 extends Fragment {

    private static final int TEXT_SIZE_IN_DP = 20;
    private MediaPlayer question_sounds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_java_arrays_6, container, false);

        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);

        Button btnShowAlertDialog = view.findViewById(R.id.j_array_dyk);
        btnShowAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDYK1();
            }
        });



        // Example sing line comment
        WebView codeWebView_P_looping1 = view.findViewById(R.id.java_program_output);
        String formattedCode_P_looping1  = getString(R.string.java_program_output);
        String htmlContent_P_loopingl1  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping1);
        configureWebView(codeWebView_P_looping1, htmlContent_P_loopingl1);

        // Example sing line comment
        WebView codeWebView_P_looping2 = view.findViewById(R.id.java_program_output1);
        String formattedCode_P_looping2  = getString(R.string.java_program_output1);
        String htmlContent_P_loopingl2  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping2);
        configureWebView(codeWebView_P_looping2, htmlContent_P_loopingl2);


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
        return Math.round(JavaArraysFragment_6.TEXT_SIZE_IN_DP * density);
    }
    private void showDYK1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_java_cut);
        alertDialogBuilder.setTitle("Did you know!");
        alertDialogBuilder.setMessage("You can use a loop statement in an array? We can actually use for-each loop to print out Java array elements one by one. It holds an array element in a variable, then executes the body of the loop.");
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