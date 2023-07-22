package com.example.care_prototype_01.CSharpLessons.CSharpVariablesFragments;

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


public class CSharpVariablesFragment_2 extends Fragment {
    private static final int TEXT_SIZE_IN_DP = 20;
    private MediaPlayer question_sounds;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c_sharp_variables_2, container, false);

        // Example variable 1
        WebView codeWebView_P_variables1 = view.findViewById(R.id.c_var_string_code_example);
        String formattedCode_P_variables1 = getString(R.string.c_var_string_code_example);
        String htmlContent_P_variables1 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_variables1);
        configureWebView(codeWebView_P_variables1, htmlContent_P_variables1);

        // Example variable 1
        WebView codeWebView_P_variables2 = view.findViewById(R.id.c_var_int_code_example);
        String formattedCode_P_variables2 = getString(R.string.c_var_int_code_example);
        String htmlContent_P_variables2 = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", dpToPx(), formattedCode_P_variables2);
        configureWebView(codeWebView_P_variables2, htmlContent_P_variables2);


        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);

        Button btnShowAlertDialog = view.findViewById(R.id.C_conditional_DYK);
        btnShowAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDYK1();
            }
        });

        Button btnShowAlertDialog1 = view.findViewById(R.id.C_conditional_DYK1);
        btnShowAlertDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDYK2();
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
        return Math.round(CSharpVariablesFragment_2.TEXT_SIZE_IN_DP * density);
    }

    private void showDYK1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_c_cut);
        alertDialogBuilder.setTitle("Did you know!");
        alertDialogBuilder.setMessage("To create a variable that should store text you should use \"string\"");
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
    private void showDYK2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_c_cut);
        alertDialogBuilder.setTitle("Did you know!");
        alertDialogBuilder.setMessage("To create a variable that should store a number you should use \"int\"");
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