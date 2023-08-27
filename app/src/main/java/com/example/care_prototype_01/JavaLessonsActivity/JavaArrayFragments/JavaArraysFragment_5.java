package com.example.care_prototype_01.JavaLessonsActivity.JavaArrayFragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.care_prototype_01.R;

public class JavaArraysFragment_5 extends Fragment {


    private static final int TEXT_SIZE_IN_DP = 20;
    private MediaPlayer question_sounds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_java_arrays_5, container, false);

        // Example sing line comment
        WebView codeWebView_P_looping1 = view.findViewById(R.id.integer_array_example);
        String formattedCode_P_looping1  = getString(R.string.integer_array_example);
        String htmlContent_P_loopingl1  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping1);
        configureWebView(codeWebView_P_looping1, htmlContent_P_loopingl1);

        WebView codeWebView_P_looping2 = view.findViewById(R.id.integer_array_access);
        String formattedCode_P_looping2  = getString(R.string.integer_array_access);
        String htmlContent_P_loopingl2  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping2);
        configureWebView(codeWebView_P_looping2, htmlContent_P_loopingl2);


        // Example sing line comment
        WebView codeWebView_P_looping3 = view.findViewById(R.id.two_dimensional_array_example);
        String formattedCode_P_looping3  = getString(R.string.two_dimensional_array_example);
        String htmlContent_P_loopingl3  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping3);
        configureWebView(codeWebView_P_looping3, htmlContent_P_loopingl3);

        WebView codeWebView_P_looping4 = view.findViewById(R.id.two_dimensional_array_access);
        String formattedCode_P_looping4  = getString(R.string.two_dimensional_array_access);
        String htmlContent_P_loopingl4  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping4);
        configureWebView(codeWebView_P_looping4, htmlContent_P_loopingl4);
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
        return Math.round(JavaArraysFragment_5.TEXT_SIZE_IN_DP * density);
    }

}