package com.example.care_prototype_01.JavaLessonsActivity.JavaCommentFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.care_prototype_01.R;

public class JavaCommentsFragment_2 extends Fragment {

    private static final int TEXT_SIZE_IN_DP = 20;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_java_comments_2, container, false);

        // Example syntax print
        WebView codeWebView_J_Comment2 = view.findViewById(R.id.java_code_multi_line_comment);
        String formattedCode_J_Comment2 = getString(R.string.java_code_multi_line_comment);
        String htmlContent_J_Comment2 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_J_Comment2);
        configureWebView(codeWebView_J_Comment2, htmlContent_J_Comment2);

        WebView codeWebView_J_Comment3 = view.findViewById(R.id.java_code_square_function);
        String formattedCode_J_Comment3 = getString(R.string.java_code_square_function);
        String htmlContent_J_Comment3 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_J_Comment3);
        configureWebView(codeWebView_J_Comment3, htmlContent_J_Comment3);
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
        return Math.round(JavaCommentsFragment_2.TEXT_SIZE_IN_DP * density);
    }
}