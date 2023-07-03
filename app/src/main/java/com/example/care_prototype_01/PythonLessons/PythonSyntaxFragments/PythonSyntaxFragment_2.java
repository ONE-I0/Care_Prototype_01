package com.example.care_prototype_01.PythonLessons.PythonSyntaxFragments;

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

public class PythonSyntaxFragment_2 extends Fragment {
    private static final int TEXT_SIZE_IN_DP = 30;
    private MediaPlayer question_sounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_python_syntax_2, container, false);

        // Example syntax if else statement
        WebView codeWebView_P_Syntax_1= view.findViewById(R.id.if_else_example);
        String formattedCode_P_Syntax_1 = getString(R.string.if_else_example);
        String htmlContent_P_Syntax_1 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_Syntax_1);
        configureWebView(codeWebView_P_Syntax_1, htmlContent_P_Syntax_1);

        // Example syntax total 1
        WebView codeWebView_P_Syntax_2 = view.findViewById(R.id.line_continuation_example);
        String formattedCode_P_Syntax_2 = getString(R.string.line_continuation_example);
        String htmlContentP_Syntax_2 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_Syntax_2);
        configureWebView(codeWebView_P_Syntax_2, htmlContentP_Syntax_2);

        // Example syntax quotations 1
        WebView codeWebView_P_Syntax_3 = view.findViewById(R.id.string_literals_example);
        String formattedCode_P_Syntax_3 = getString(R.string.string_literals_example);
        String htmlContentP_Syntax_3 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_Syntax_3);
        configureWebView(codeWebView_P_Syntax_3, htmlContentP_Syntax_3);



        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);

        //button for the questions
        Button btnP_Syntax_Q1 = view.findViewById(R.id.P_Syntax_btnQ1);
        Button btnP_Syntax_Q2 = view.findViewById(R.id.P_Syntax_btnQ2);
        Button btnP_Syntax_Q3 = view.findViewById(R.id.P_Syntax_btnQ3);
        btnP_Syntax_Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                P_Syntax_btnQ1();
            }
        });
        btnP_Syntax_Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                P_Syntax_btnQ3();
            }
        });
        btnP_Syntax_Q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                P_Syntax_btnQ3();
            }
        });
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
        return Math.round(PythonSyntaxFragment_2.TEXT_SIZE_IN_DP * density);
    }

    private void P_Syntax_btnQ1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("What is Python known for?\n");
        alertDialogBuilder.setMessage("Python is known as the easiest programming language. Because of its syntax that is very close to the language of human, everyone can easily understand the flow of sequence in its codes!\n");
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
    private void P_Syntax_btnQ2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("What is the edge of Python compared to other programming languages?\n");
        alertDialogBuilder.setMessage("Python is vert well known that emphasizes code readability and simplicity. Compared to other languages, Python has a clean and intuitive syntax that allows, not only developers but also beginners, to express any concepts in a more concise and natural way that makes it easier to learn, understand, and maintain codes.\n");
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
    private void P_Syntax_btnQ3() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("What type of language does Python belong?\n");
        alertDialogBuilder.setMessage("Python is considered an interpreted language. When writing a Python code, it is executed by the interpreter line by line without the need for explicit compilation. The interpreter reads the code then interprets it, and executes it directly, translating the code into machine instructions and prints it out into human-readable output.\n");
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