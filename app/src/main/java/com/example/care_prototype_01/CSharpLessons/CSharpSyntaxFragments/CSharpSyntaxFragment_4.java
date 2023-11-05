package com.example.care_prototype_01.CSharpLessons.CSharpSyntaxFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.care_prototype_01.R;


public class CSharpSyntaxFragment_4 extends Fragment {
    private static final int TEXT_SIZE_IN_DP = 20;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c_sharp_syntax_4, container, false);


        WebView codeWebView_P_Syntax_1= view.findViewById(R.id.c_syn1);
        String formattedCode_P_Syntax_1 = getString(R.string.c_syn1);
        String htmlContent_P_Syntax_1 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_Syntax_1);
        configureWebView(codeWebView_P_Syntax_1, htmlContent_P_Syntax_1);


        WebView codeWebView_P_Syntax_2= view.findViewById(R.id.c_syn2);
        String formattedCode_P_Syntax_2 = getString(R.string.c_syn2);
        String htmlContent_P_Syntax_2 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_Syntax_2);
        configureWebView(codeWebView_P_Syntax_2, htmlContent_P_Syntax_2);


        WebView codeWebView_P_Syntax_3= view.findViewById(R.id.c_syn3);
        String formattedCode_P_Syntax_3 = getString(R.string.c_syn3);
        String htmlContent_P_Syntax_3 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_Syntax_3);
        configureWebView(codeWebView_P_Syntax_3, htmlContent_P_Syntax_3);

        WebView codeWebView_P_Syntax_4= view.findViewById(R.id.c_syn4);
        String formattedCode_P_Syntax_4 = getString(R.string.c_syn4);
        String htmlContent_P_Syntax_4 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_Syntax_4);
        configureWebView(codeWebView_P_Syntax_4, htmlContent_P_Syntax_4);

        WebView codeWebView_P_Syntax_5= view.findViewById(R.id.c_syn5);
        String formattedCode_P_Syntax_5 = getString(R.string.c_syn5);
        String htmlContent_P_Syntax_5 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_Syntax_5);
        configureWebView(codeWebView_P_Syntax_5, htmlContent_P_Syntax_5);



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
        return Math.round(CSharpSyntaxFragment_4.TEXT_SIZE_IN_DP * density);
    }
}