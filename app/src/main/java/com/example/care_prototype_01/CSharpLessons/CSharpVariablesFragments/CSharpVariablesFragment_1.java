package com.example.care_prototype_01.CSharpLessons.CSharpVariablesFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.care_prototype_01.PythonLessons.PythonVariablesFragments.PythonVariablesFragment_1;
import com.example.care_prototype_01.R;

public class CSharpVariablesFragment_1 extends Fragment {

    private static final int TEXT_SIZE_IN_DP = 20;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c_sharp_variables_1, container, false);

        // Example variable 1
        WebView codeWebView_P_variables1 = view.findViewById(R.id.c_syn_code_example);
        String formattedCode_P_variables1 = getString(R.string.c_syn_code_example);
        String htmlContent_P_variables1 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_variables1);
        configureWebView(codeWebView_P_variables1, htmlContent_P_variables1);


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
        return Math.round(CSharpVariablesFragment_1.TEXT_SIZE_IN_DP * density);
    }

}