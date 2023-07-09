package com.example.care_prototype_01.PythonLessons.PythonLoopingStatementsFragments;

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

public class PythonLoopingStatementFragment_5 extends Fragment {
    private static final int TEXT_SIZE_IN_DP = 20;
    private MediaPlayer question_sounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_python_looping_statement_5, container, false);

        // Example sing line comment
        WebView codeWebView_P_looping1 = view.findViewById(R.id.p_for_loop_with_continue);
        String formattedCode_P_looping1  = getString(R.string.p_for_loop_with_continue);
        String htmlContent_P_loopingl1  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping1);
        configureWebView(codeWebView_P_looping1, htmlContent_P_loopingl1);


        // Example sing line comment
        WebView codeWebView_P_looping2 = view.findViewById(R.id.p_for_loop_with_continue_example);
        String formattedCode_P_looping2  = getString(R.string.p_for_loop_with_continue_example);
        String htmlContent_P_loopingl2  = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping2);
        configureWebView(codeWebView_P_looping2, htmlContent_P_loopingl2);

        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);
        Button btnShowAlertDialog = view.findViewById(R.id.python_looping_DYK);
        btnShowAlertDialog.setOnClickListener(v -> showDYK1());

        Button btnShowAlertDialog2 = view.findViewById(R.id.python_looping_DYK2);
        btnShowAlertDialog2.setOnClickListener(v -> showDYK2());
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
        return Math.round(PythonLoopingStatementFragment_5.TEXT_SIZE_IN_DP * density);
    }

    //-----------------------DID YOU KNOW AND QUESTIONS BUTTONS-------------------------//
    private void showDYK1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Did you know");
        alertDialogBuilder.setMessage("did you know that “continue statement” is used to skip the remaining code block for the current iteration and move to the next iteration. When the condition is true, the code block after the continue statement is skipped for that iteration.");
        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> {
            // You can add some action here when the user clicks "OK"
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }

    private void showDYK2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Did you know");
        alertDialogBuilder.setMessage("did you know the “continue statement” only affects the current innermost loop. If nested loops are present, the continue statement will only skip to the next iteration of the innermost loop.");
        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> {
            // You can add some action here when the user clicks "OK"
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
}