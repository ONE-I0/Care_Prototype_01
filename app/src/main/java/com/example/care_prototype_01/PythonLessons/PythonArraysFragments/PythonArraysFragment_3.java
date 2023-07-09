package com.example.care_prototype_01.PythonLessons.PythonArraysFragments;

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

public class PythonArraysFragment_3 extends Fragment {
    private static final int TEXT_SIZE_IN_DP = 20;
    private MediaPlayer question_sounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_python_arrays_3, container, false);

        // Example sing line comment
        WebView codeWebView_P_looping1 = view.findViewById(R.id.python_list_methods_example1);
        String formattedCode_P_looping1 = getString(R.string.python_list_methods_example1);
        String htmlContent_P_loopingl1 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping1);
        configureWebView(codeWebView_P_looping1, htmlContent_P_loopingl1);

        // Example sing line comment
        WebView codeWebView_P_looping2 = view.findViewById(R.id.python_list_methods_example2);
        String formattedCode_P_looping2 = getString(R.string.python_list_methods_example2);
        String htmlContent_P_loopingl2 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping2);
        configureWebView(codeWebView_P_looping2, htmlContent_P_loopingl2);

        // Example sing line comment
        WebView codeWebView_P_looping3 = view.findViewById(R.id.python_list_methods_example3);
        String formattedCode_P_looping3 = getString(R.string.python_list_methods_example3);
        String htmlContent_P_loopingl3 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping3);
        configureWebView(codeWebView_P_looping3, htmlContent_P_loopingl3);

        // Example sing line comment
        WebView codeWebView_P_looping4 = view.findViewById(R.id.python_list_methods_example4);
        String formattedCode_P_looping4 = getString(R.string.python_list_methods_example4);
        String htmlContent_P_loopingl4 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping4);
        configureWebView(codeWebView_P_looping4, htmlContent_P_loopingl4);

        // Example sing line comment
        WebView codeWebView_P_looping5 = view.findViewById(R.id.python_list_methods_example5);
        String formattedCode_P_looping5 = getString(R.string.python_list_methods_example5);
        String htmlContent_P_loopingl5 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping5);
        configureWebView(codeWebView_P_looping5, htmlContent_P_loopingl5);

        // Example sing line comment
        WebView codeWebView_P_looping6 = view.findViewById(R.id.python_list_methods_example6);
        String formattedCode_P_looping6 = getString(R.string.python_list_methods_example6);
        String htmlContent_P_loopingl6 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping6);
        configureWebView(codeWebView_P_looping6, htmlContent_P_loopingl6);

        // Example sing line comment
        WebView codeWebView_P_looping7 = view.findViewById(R.id.python_list_methods_example7);
        String formattedCode_P_looping7 = getString(R.string.python_list_methods_example7);
        String htmlContent_P_loopingl7 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping7);
        configureWebView(codeWebView_P_looping7, htmlContent_P_loopingl7);

        // Example sing line comment
        WebView codeWebView_P_looping8 = view.findViewById(R.id.python_list_methods_example8);
        String formattedCode_P_looping8 = getString(R.string.python_list_methods_example8);
        String htmlContent_P_loopingl8 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping8);
        configureWebView(codeWebView_P_looping8, htmlContent_P_loopingl8);

        // Example sing line comment
        WebView codeWebView_P_looping9 = view.findViewById(R.id.python_list_methods_example9);
        String formattedCode_P_looping9 = getString(R.string.python_list_methods_example9);
        String htmlContent_P_loopingl9 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping9);
        configureWebView(codeWebView_P_looping9, htmlContent_P_loopingl9);

        // Example sing line comment
        WebView codeWebView_P_looping10 = view.findViewById(R.id.python_list_methods_example10);
        String formattedCode_P_looping10 = getString(R.string.python_list_methods_example10);
        String htmlContent_P_loopingl10 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping10);
        configureWebView(codeWebView_P_looping10, htmlContent_P_loopingl10);

        // Example sing line comment
        WebView codeWebView_P_looping11 = view.findViewById(R.id.python_list_methods_example11);
        String formattedCode_P_looping11 = getString(R.string.python_list_methods_example11);
        String htmlContent_P_loopingl11 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping11);
        configureWebView(codeWebView_P_looping11, htmlContent_P_loopingl11);

        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);

        Button btnShowAlertDialog = view.findViewById(R.id.python_array_note1);
        btnShowAlertDialog.setOnClickListener(v -> showNOTE1());

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
        return Math.round(PythonArraysFragment_3.TEXT_SIZE_IN_DP * density);
    }
    private void showNOTE1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Note");
        alertDialogBuilder.setMessage("Note that Python does not have built-in support for Arrays, but Python Lists can be used instead.");
        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> {
            // You can add some action here when the user clicks "OK"
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
}