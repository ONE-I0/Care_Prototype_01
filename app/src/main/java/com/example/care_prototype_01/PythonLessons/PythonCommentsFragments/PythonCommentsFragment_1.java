package com.example.care_prototype_01.PythonLessons.PythonCommentsFragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class PythonCommentsFragment_1 extends Fragment {
    private static final int TEXT_SIZE_IN_DP = 30;
    private MediaPlayer question_sounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_python_comments_1, container, false);

        // Example sing line comment
        WebView codeWebView_P_single_comment_1 = view.findViewById(R.id.P_single_comment_1);
        String formattedCode_P_single_comment_1 = getString(R.string.P_single_comment_1);
        String htmlContentExample = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_single_comment_1);
        configureWebView(codeWebView_P_single_comment_1, htmlContentExample);

        // Example multi line comment
        WebView codeWebView_P_multi_line_comment = view.findViewById(R.id.P_multi_line_comment);
        String formattedCode_P_multi_line_comment = getString(R.string.P_multi_line_comment);
        String htmlContent_P_multi_line_comment = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_multi_line_comment);
        configureWebView(codeWebView_P_multi_line_comment, htmlContent_P_multi_line_comment);

        // Example doc string comment
        WebView codeWebView_P_doc_comment = view.findViewById(R.id.P_Docstring_comment);
        String formattedCode_P_doc_comment = getString(R.string.P_Docstring_comment);
        String htmlContent_P_doc_comment = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_doc_comment);
        configureWebView(codeWebView_P_doc_comment, htmlContent_P_doc_comment);
        // Declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);

        Button btnShowAlertDialog = view.findViewById(R.id.python_comments_DYK1);
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
        return Math.round(PythonCommentsFragment_1.TEXT_SIZE_IN_DP * density);
    }

    //-----------------------DID YOU KNOW AND QUESTIONS BUTTONS-------------------------//
    private void showDYK1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Did you know");
        alertDialogBuilder.setMessage("Did you know that Python comments are crucial for readability and code documentation? Using the '#' symbol in Python, you can insert comments into your code. The Python interpreter interprets any text that appears on the same line after the '#' as a comment and ignores it. ");
        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> {
            // You can add some action here when the user clicks "OK"
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
}
