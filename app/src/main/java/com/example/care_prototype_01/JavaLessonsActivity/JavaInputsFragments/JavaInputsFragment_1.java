package com.example.care_prototype_01.JavaLessonsActivity.JavaInputsFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.care_prototype_01.JavaLessonsActivity.JavaSyntaxFragments.JavaSyntaxFragment_2;
import com.example.care_prototype_01.R;

public class JavaInputsFragment_1 extends Fragment {


    private static final int TEXT_SIZE_IN_DP = 25;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_java_syntax_2, container, false);

        // Example syntax print
        WebView codeWebView_J_Syntax_1_1= view.findViewById(R.id.java_example8);
        String formattedCode_J_Syntax_1_1 = getString(R.string.java_example8);
        String htmlContent_J_Syntax_1_1 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_J_Syntax_1_1);
        configureWebView(codeWebView_J_Syntax_1_1, htmlContent_J_Syntax_1_1);
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
        return Math.round(JavaInputsFragment_1.TEXT_SIZE_IN_DP * density);
    }
}