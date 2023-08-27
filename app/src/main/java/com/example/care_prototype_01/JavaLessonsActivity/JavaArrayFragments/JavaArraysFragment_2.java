package com.example.care_prototype_01.JavaLessonsActivity.JavaArrayFragments;

import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.example.care_prototype_01.JavaLessonsActivity.JavaConditionalStatementFragments.JavaConditionalStatementFragment_2;
import com.example.care_prototype_01.R;

public class JavaArraysFragment_2 extends Fragment {
    private static final int TEXT_SIZE_IN_DP = 20;
    private MediaPlayer question_sounds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_java_arrays_2, container, false);

        // Example sing line comment
        WebView codeWebView_P_looping1 = view.findViewById(R.id.string_array_declaration);
        String formattedCode_P_looping1  = getString(R.string.string_array_declaration);
        String htmlContent_P_loopingl1  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping1);
        configureWebView(codeWebView_P_looping1, htmlContent_P_loopingl1);

        // Example sing line comment
        WebView codeWebView_P_looping2 = view.findViewById(R.id.string_array_initialization);
        String formattedCode_P_looping2  = getString(R.string.string_array_initialization);
        String htmlContent_P_loopingl2  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping2);
        configureWebView(codeWebView_P_looping2, htmlContent_P_loopingl2);

        WebView codeWebView_P_looping3 = view.findViewById(R.id.integer_array_initialization);
        String formattedCode_P_looping3  = getString(R.string.integer_array_initialization);
        String htmlContent_P_loopingl3  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping3);
        configureWebView(codeWebView_P_looping3, htmlContent_P_loopingl3);

        WebView codeWebView_P_looping5 = view.findViewById(R.id.integer_array_declaration);
        String formattedCode_P_looping5  = getString(R.string.integer_array_declaration);
        String htmlContent_P_loopingl5  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping5);
        configureWebView(codeWebView_P_looping5, htmlContent_P_loopingl5);

        WebView codeWebView_P_looping4 = view.findViewById(R.id.integer_array_initialization1);
        String formattedCode_P_looping4  = getString(R.string.integer_array_initialization1);
        String htmlContent_P_loopingl4  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping4);
        configureWebView(codeWebView_P_looping4, htmlContent_P_loopingl4);


        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);

        Button btnShowAlertDialog = view.findViewById(R.id.j_dyk);
        btnShowAlertDialog.setOnClickListener(v -> showDYK1());


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
        return Math.round(JavaArraysFragment_2.TEXT_SIZE_IN_DP * density);
    }

    //-----------------------DID YOU KNOW AND QUESTIONS BUTTONS-------------------------//
    private void showDYK1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_java_cut);
        alertDialogBuilder.setTitle("Did you know");
        alertDialogBuilder.setMessage("That arrays in Java is index-based? Meaning, the first element of the array is stored at the 0th index, 2nd element is stored at 1st index, and so on.");
        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> {
            // You can add some action here when the user clicks "OK"
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
}
