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

public class PythonArraysFragment_2 extends Fragment {
    private static final int TEXT_SIZE_IN_DP = 20;
    private MediaPlayer question_sounds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_python_arrays_2, container, false);

        // Example sing line comment
        WebView codeWebView_P_looping1 = view.findViewById(R.id.p_array_indexing_example);
        String formattedCode_P_looping1 = getString(R.string.p_array_indexing_example);
        String htmlContent_P_loopingl1 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping1);
        configureWebView(codeWebView_P_looping1, htmlContent_P_loopingl1);


        // Example sing line comment
        WebView codeWebView_P_looping2 = view.findViewById(R.id.p_array_length_example);
        String formattedCode_P_looping2 = getString(R.string.p_array_length_example);
        String htmlContent_P_loopingl2 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping2);
        configureWebView(codeWebView_P_looping2, htmlContent_P_loopingl2);

        // Example sing line comment
        WebView codeWebView_P_looping3 = view.findViewById(R.id.p_for_loop_iteration_example);
        String formattedCode_P_looping3 = getString(R.string.p_for_loop_iteration_example);
        String htmlContent_P_loopingl3 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping3);
        configureWebView(codeWebView_P_looping3, htmlContent_P_loopingl3);

        // Example sing line comment
        WebView codeWebView_P_looping4 = view.findViewById(R.id.p_array_append_example);
        String formattedCode_P_looping4 = getString(R.string.p_array_append_example);
        String htmlContent_P_loopingl4 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping4);
        configureWebView(codeWebView_P_looping4, htmlContent_P_loopingl4);

        // Example sing line comment
        WebView codeWebView_P_looping5 = view.findViewById(R.id.p_array_pop_remove_example);
        String formattedCode_P_looping5 = getString(R.string.p_array_pop_remove_example);
        String htmlContent_P_loopingl5 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_looping5);
        configureWebView(codeWebView_P_looping5, htmlContent_P_loopingl5);


        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);

        Button btnShowAlertDialog = view.findViewById(R.id.python_array_note);
        btnShowAlertDialog.setOnClickListener(v -> showNOTE1());

        Button btnShowAlertDialog1 = view.findViewById(R.id.python_array_note1);
        btnShowAlertDialog1.setOnClickListener(v -> showNOTE2());
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
        return Math.round(PythonArraysFragment_2.TEXT_SIZE_IN_DP * density);
    }
    private void showNOTE1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Note");
        alertDialogBuilder.setMessage("Note that the length of an array is always one more than the highest array index.");
        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> {
            // You can add some action here when the user clicks "OK"
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void showNOTE2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Note");
        alertDialogBuilder.setMessage("Note that the list’s remove() method only removes the first occurrence of the specified value.");
        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> {
            // You can add some action here when the user clicks "OK"
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
}