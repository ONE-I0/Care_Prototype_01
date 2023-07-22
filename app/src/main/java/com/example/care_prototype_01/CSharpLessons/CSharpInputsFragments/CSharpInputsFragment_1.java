package com.example.care_prototype_01.CSharpLessons.CSharpInputsFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.care_prototype_01.CSharpLessons.CSharpSyntaxFragments.CSharpSyntaxFragment_1;
import com.example.care_prototype_01.R;

public class CSharpInputsFragment_1 extends Fragment {

    private static final int TEXT_SIZE_IN_DP = 20;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c_sharp_inputs_1, container, false);

        // Example syntax print
        WebView codeWebView_P_Syntax_1_1= view.findViewById(R.id.c_input_code_example);
        String formattedCode_P_Syntax_1_1 = getString(R.string.c_input_code_example);
        String htmlContent_P_Syntax_1_1 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_Syntax_1_1);
        configureWebView(codeWebView_P_Syntax_1_1, htmlContent_P_Syntax_1_1);

        // Example syntax print
        WebView codeWebView_P_Syntax_2= view.findViewById(R.id.c_input_code_example1);
        String formattedCode_P_Syntax_2 = getString(R.string.c_input_code_example1);
        String htmlContent_P_Syntax_2 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_Syntax_2);
        configureWebView(codeWebView_P_Syntax_2, htmlContent_P_Syntax_2);

        // Example syntax print
        WebView codeWebView_P_Syntax_3= view.findViewById(R.id.c_input_code_example2);
        String formattedCode_P_Syntax_3 = getString(R.string.c_input_code_example2);
        String htmlContent_P_Syntax_3 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_Syntax_3);
        configureWebView(codeWebView_P_Syntax_3, htmlContent_P_Syntax_3);
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
        return Math.round(CSharpInputsFragment_1.TEXT_SIZE_IN_DP * density);
    }
}