package com.example.care_prototype_01.CSharpLessons.CSharpConditionalStatementsFragments;

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

import com.example.care_prototype_01.R;


public class CSharpConditionalStatementsFragment_3 extends Fragment {


    private static final int TEXT_SIZE_IN_DP = 20;
    private MediaPlayer question_sounds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c_sharp_conditional_statements_3, container, false);

        // Example sing line comment
        WebView codeWebView_P_looping1 = view.findViewById(R.id.c_else_code);
        String formattedCode_P_looping1  = getString(R.string.c_else_code);
        String htmlContent_P_loopingl1  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping1);
        configureWebView(codeWebView_P_looping1, htmlContent_P_loopingl1);


        // Example sing line comment
        WebView codeWebView_P_looping2 = view.findViewById(R.id.c_else_example_code);
        String formattedCode_P_looping2  = getString(R.string.c_else_example_code);
        String htmlContent_P_loopingl2  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping2);
        configureWebView(codeWebView_P_looping2, htmlContent_P_loopingl2);

        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);
        Button btnShowAlertDialog = view.findViewById(R.id.C_conditional_DYK);
        btnShowAlertDialog.setOnClickListener(v -> showDYK1());

        Button btnShowAlertDialog1 = view.findViewById(R.id.C_conditional_DYK1);
        btnShowAlertDialog1.setOnClickListener(v -> showDYK2());

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
        return Math.round(CSharpConditionalStatementsFragment_3.TEXT_SIZE_IN_DP * density);
    }

    //-----------------------DID YOU KNOW AND QUESTIONS BUTTONS-------------------------//
    private void showDYK1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_c_cut);
        alertDialogBuilder.setTitle("Did you know!");
        alertDialogBuilder.setMessage("Did you know that the \"if\" keyword initiates a conditional statement, evaluating to true or false in C#. If true, the code block is executed, and if false, the code block is executed.");
        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> {
            // You can add some action here when the user clicks "OK"
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void showDYK2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_c_cut);
        alertDialogBuilder.setTitle("Did you know!");
        alertDialogBuilder.setMessage("Did you know that an 'if-else' statement can act as a catalyst for alternate behaviors in a program? This statement enables a program to leverage branching logic and effectively determine the best possible outcome following a specific scenario. With an 'if-else' statement in place, code can take on multiple forms depending on the given conditions. Such a powerful construct allows for efficient decision-making and can prove to be an invaluable tool for developers.");
        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> {
            // You can add some action here when the user clicks "OK"
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
}