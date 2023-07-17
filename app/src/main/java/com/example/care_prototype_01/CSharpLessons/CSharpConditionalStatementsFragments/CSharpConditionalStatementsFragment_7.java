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

public class CSharpConditionalStatementsFragment_7 extends Fragment {

    private static final int TEXT_SIZE_IN_DP = 20;
    private MediaPlayer question_sounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c_sharp_conditional_statements_7, container, false);

        // Example sing line comment
        WebView codeWebView_P_looping1 = view.findViewById(R.id.c_switch_example_code);
        String formattedCode_P_looping1 = getString(R.string.c_switch_example_code);
        String htmlContent_P_loopingl1 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping1);
        configureWebView(codeWebView_P_looping1, htmlContent_P_loopingl1);


        // Example sing line comment
        WebView codeWebView_P_looping2 = view.findViewById(R.id.c_switch_break_example_code);
        String formattedCode_P_looping2 = getString(R.string.c_switch_break_example_code);
        String htmlContent_P_loopingl2 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping2);
        configureWebView(codeWebView_P_looping2, htmlContent_P_loopingl2);

        // Example sing line comment
        WebView codeWebView_P_looping3 = view.findViewById(R.id.c_default_example_code);
        String formattedCode_P_looping3 = getString(R.string.c_default_example_code);
        String htmlContent_P_loopingl3 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping3);
        configureWebView(codeWebView_P_looping3, htmlContent_P_loopingl3);

        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);
        Button btnShowAlertDialog = view.findViewById(R.id.C_conditional_DYK);
        btnShowAlertDialog.setOnClickListener(v -> showDYK1());

        Button btnShowAlertDialog1 = view.findViewById(R.id.c_conditional_DYK2);
        btnShowAlertDialog1.setOnClickListener(v -> showNote());

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
        return Math.round(CSharpConditionalStatementsFragment_7.TEXT_SIZE_IN_DP * density);
    }

    //-----------------------DID YOU KNOW AND QUESTIONS BUTTONS-------------------------//
    private void showDYK1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Note!");
        alertDialogBuilder.setMessage("A break \"ignores\" the execution of the entire rest of the switch block's code, which can save a significant amount of time during execution.");
        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> {
            // You can add some action here when the user clicks "OK"
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void showNote() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Note!");
        alertDialogBuilder.setMessage("Take note C# exits the switch block when it comes to a break keyword. This will stop further code execution and case testing within the block. When a match is made and the work is over, a break is necessary. More testing is not necessary.");
        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> {
            // You can add some action here when the user clicks "OK"
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
}