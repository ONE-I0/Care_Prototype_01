package com.example.care_prototype_01.PythonLessons.PythonConditionalStatementsFragments;

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

import com.example.care_prototype_01.PythonLessons.PythonCommentsFragments.PythonCommentsFragment_1;
import com.example.care_prototype_01.R;


public class PythonConditionalStatementFragment_2 extends Fragment {

    private static final int TEXT_SIZE_IN_DP = 20;
    private MediaPlayer question_sounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_python_conditional_statement_2, container, false);

        // Example sing line comment
        WebView codeWebView_P_conditional1 = view.findViewById(R.id.p_if_condition);
        String formattedCode_P_conditional1  = getString(R.string.p_if_condition);
        String htmlContent_P_conditional1  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_conditional1);
        configureWebView(codeWebView_P_conditional1, htmlContent_P_conditional1);


        // Example sing line comment
        WebView codeWebView_P_conditional2 = view.findViewById(R.id.p_if_condition1);
        String formattedCode_P_conditional2  = getString(R.string.p_if_condition1);
        String htmlContent_P_conditional2  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_conditional2);
        configureWebView(codeWebView_P_conditional2, htmlContent_P_conditional2);

        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);
        Button btnShowAlertDialog = view.findViewById(R.id.python_conditional_DYK);
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
        return Math.round(PythonConditionalStatementFragment_2.TEXT_SIZE_IN_DP * density);
    }

    //-----------------------DID YOU KNOW AND QUESTIONS BUTTONS-------------------------//
    private void showDYK1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Did you know");
        alertDialogBuilder.setMessage("did you know that if statement is used to check a condition. If the condition evaluates to True, the code block indented below the if statement is executed. If the condition is False, the code block is skipped.");
        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> {
            // You can add some action here when the user clicks "OK"
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
}