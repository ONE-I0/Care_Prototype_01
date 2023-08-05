package com.example.care_prototype_01.JavaLessonsActivity.JavaSyntaxFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.care_prototype_01.R;

public class JavaSyntaxFragment_2 extends Fragment {


    private static final int TEXT_SIZE_IN_DP = 25;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_java_syntax_2, container, false);

        // Example syntax print
        WebView codeWebView_J_Syntax_1_1= view.findViewById(R.id.java_code_syn1);
        String formattedCode_J_Syntax_1_1 = getString(R.string.java_code_syn1);
        String htmlContent_J_Syntax_1_1 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_J_Syntax_1_1);
        configureWebView(codeWebView_J_Syntax_1_1, htmlContent_J_Syntax_1_1);

        // Example syntax print
        WebView codeWebView_J_Syntax_2= view.findViewById(R.id.java_code_syn2);
        String formattedCode_J_Syntax_2 = getString(R.string.java_code_syn2);
        String htmlContent_J_Syntax_2 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_J_Syntax_2);
        configureWebView(codeWebView_J_Syntax_2, htmlContent_J_Syntax_2);

        WebView codeWebView_J_Syntax_3= view.findViewById(R.id.java_code_syn3);
        String formattedCode_J_Syntax_3 = getString(R.string.java_code_syn3);
        String htmlContent_J_Syntax_3 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_J_Syntax_3);
        configureWebView(codeWebView_J_Syntax_3, htmlContent_J_Syntax_3);

        // Example syntax print
        WebView codeWebView_J_Syntax_4= view.findViewById(R.id.java_code_syn4);
        String formattedCode_J_Syntax_4 = getString(R.string.java_code_syn4);
        String htmlContent_J_Syntax_4 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_J_Syntax_4);
        configureWebView(codeWebView_J_Syntax_4, htmlContent_J_Syntax_4);


        WebView codeWebView_J_Syntax_5= view.findViewById(R.id.java_code_syn5);
        String formattedCode_J_Syntax_5 = getString(R.string.java_code_syn5);
        String htmlContent_J_Syntax_5 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_J_Syntax_5);
        configureWebView(codeWebView_J_Syntax_5, htmlContent_J_Syntax_5);

        WebView codeWebView_J_Syntax_6= view.findViewById(R.id.java_code_syn6);
        String formattedCode_J_Syntax_6 = getString(R.string.java_code_syn6);
        String htmlContent_J_Syntax_6 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_J_Syntax_6);
        configureWebView(codeWebView_J_Syntax_6, htmlContent_J_Syntax_6);

        WebView codeWebView_J_Syntax_7= view.findViewById(R.id.java_code_syn7);
        String formattedCode_J_Syntax_7 = getString(R.string.java_code_syn7);
        String htmlContent_J_Syntax_7 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_J_Syntax_7);
        configureWebView(codeWebView_J_Syntax_7, htmlContent_J_Syntax_7);
        return view;
    }

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
        return Math.round(JavaSyntaxFragment_2.TEXT_SIZE_IN_DP * density);
    }
}