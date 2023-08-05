package com.example.care_prototype_01.JavaLessonsActivity.JavaSyntaxFragments;

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


public class JavaSyntaxFragment_3 extends Fragment {
    private static final int TEXT_SIZE_IN_DP = 20;
    private MediaPlayer question_sounds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_java_syntax_3, container, false);


        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);

        Button btnShowAlertDialog = view.findViewById(R.id.java_syntax_output1);
        btnShowAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDYK1();
            }
        });
        // Example syntax print
        WebView codeWebView_J_Syntax_1_1 = view.findViewById(R.id.java_code_syn_1_1);
        String formattedCode_J_Syntax_1_1 = getString(R.string.java_code_syn_1_1);
        String htmlContent_J_Syntax_1_1 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_J_Syntax_1_1);
        configureWebView(codeWebView_J_Syntax_1_1, htmlContent_J_Syntax_1_1);

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
        return Math.round(JavaSyntaxFragment_3.TEXT_SIZE_IN_DP * density);
    }
    private void showDYK1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("Output");
        alertDialogBuilder.setMessage("Hello World");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // You can add some action here when the user clicks "OK"
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        question_sounds.start();
    }
}