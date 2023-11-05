package com.example.care_prototype_01.CSharpLessons.CSharpSyntaxFragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.example.care_prototype_01.PythonLessons.PythonSyntaxFragments.PythonSyntaxFragment_2;
import com.example.care_prototype_01.R;


public class CSharpSyntaxFragment_2 extends Fragment {

    private static final int TEXT_SIZE_IN_DP = 20;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c_sharp_syntax_2, container, false);

        // Example syntax if else statement
        WebView codeWebView_P_Syntax_1 = view.findViewById(R.id.c_using_code_example);
        String formattedCode_P_Syntax_1 = getString(R.string.c_using_code_example);
        String htmlContent_P_Syntax_1 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_Syntax_1);
        configureWebView(codeWebView_P_Syntax_1, htmlContent_P_Syntax_1);

        // Example syntax total 1
        WebView codeWebView_P_Syntax_2 = view.findViewById(R.id.c_class_code_example1);
        String formattedCode_P_Syntax_2 = getString(R.string.c_class_code_example1);
        String htmlContentP_Syntax_2 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_Syntax_2);
        configureWebView(codeWebView_P_Syntax_2, htmlContentP_Syntax_2);

        // Example syntax quotations 1
        WebView codeWebView_P_Syntax_3 = view.findViewById(R.id.c_variable_code_example);
        String formattedCode_P_Syntax_3 = getString(R.string.c_variable_code_example);
        String htmlContentP_Syntax_3 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_Syntax_3);
        configureWebView(codeWebView_P_Syntax_3, htmlContentP_Syntax_3);

        // Example syntax quotations 1
        WebView codeWebView_P_Syntax_4 = view.findViewById(R.id.c_var_func_code_example);
        String formattedCode_P_Syntax_4 = getString(R.string.c_var_func_code_example);
        String htmlContentP_Syntax_4 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_Syntax_4);
        configureWebView(codeWebView_P_Syntax_4, htmlContentP_Syntax_4);

        // Example syntax quotations 1
        WebView codeWebView_P_Syntax_5 = view.findViewById(R.id.c_class_2_code_example);
        String formattedCode_P_Syntax_5 = getString(R.string.c_class_2_code_example);
        String htmlContentP_Syntax_5 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_Syntax_5);
        configureWebView(codeWebView_P_Syntax_5, htmlContentP_Syntax_5);



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
        return Math.round(CSharpSyntaxFragment_2.TEXT_SIZE_IN_DP * density);
    }
}