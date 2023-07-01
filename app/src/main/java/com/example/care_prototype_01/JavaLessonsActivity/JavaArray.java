package com.example.care_prototype_01.JavaLessonsActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.care_prototype_01.R;


public class JavaArray extends AppCompatActivity {
    Button btn_DYK_1,btn_DYK_2,btn_question1, btn_question2, btn_question3;;
    private MediaPlayer question_sounds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_array);

        // Apply desired text size to the HTML content
        int textSizeInSp = 50; // Adjust the text size as needed

        //jagged array
        WebView codeWebViewJagged = findViewById(R.id.java_jagged_text);
        String formattedCodeJagged = getString(R.string.jagged_array_code);
        //Exception array
        WebView codeWebViewArrayException = findViewById(R.id.java_array_exception_text);
        String formattedCodeArrayException = getString(R.string.java_array_exception_code);


        String htmlContentJagged = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", textSizeInSp, formattedCodeJagged, formattedCodeArrayException);
        String htmlContentException = String.format("<html><body style=\"font-size: %dpx;\">%s</body></html>", textSizeInSp, formattedCodeArrayException);

        // Load the HTML content into the WebView
        codeWebViewJagged.loadDataWithBaseURL(null, htmlContentJagged, "text/html", "UTF-8", null);
        codeWebViewArrayException.loadDataWithBaseURL(null, htmlContentException, "text/html", "UTF-8", null);

        // Set the background color of the WebView
        codeWebViewJagged.setBackgroundColor(0xd3d3d3); // Black color
        codeWebViewArrayException.setBackgroundColor(0xd3d3d3); // Black color

        // Set rounded corners to the WebView button
        codeWebViewJagged.setBackgroundResource(R.drawable.callout_background);
        codeWebViewArrayException.setBackgroundResource(R.drawable.callout_background);

        // Enable horizontal scrolling for the WebView
        WebSettings webSettings = codeWebViewJagged.getSettings();
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        //websettings for array execption
        WebSettings webSettingsExecption = codeWebViewArrayException.getSettings();
        webSettingsExecption.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettingsExecption.setLoadWithOverviewMode(true);
        webSettingsExecption.setUseWideViewPort(true);






        //declare for the sounds
        question_sounds = MediaPlayer.create(JavaArray.this, R.raw.question);

        //this will open the did you know in syntax
        btn_DYK_1 = findViewById(R.id.btndyk1);
        btn_DYK_1.setOnClickListener(view ->
                openDYK1()
        );
        //this will open the three questions
        btn_question1 = findViewById(R.id.btnquestion1);
        btn_question1.setOnClickListener(view ->
                openQuestion1()
        );

        btn_question2 = findViewById(R.id.btnquestion2);
        btn_question2.setOnClickListener(view ->
                openQuestion2()
        );

        btn_question3 = findViewById(R.id.btnquestion3);
        btn_question3.setOnClickListener(view ->
                openQuestion3()
        );
    }
    private void openDYK1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaArray.this);
        builder.setTitle("Did you know?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("Did you know that arrays in Java is index-based? Meaning, the first element of the array is stored at the 0th index, 2nd element is stored at 1st index, and so on.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }
    private void openQuestion1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaArray.this);
        builder.setTitle("What is the class name of Java array?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("In Java, an array is an object. It is creating a proxy class whose name can be obtained by using getClass().getName() method in the object.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();
    }

    private void openQuestion2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaArray.this);
        builder.setTitle("Can we copy a Java Array?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("The answer is Yes. Copying a Java array to another by using arraycopy() method of System class.\n" +
                        "Syntax:\n" +
                        "public static void arraycopy(  \n" +
                        "Object src, int srcPos,Object dest, int destPos, int length  \n" +
                        "):")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();

    }

    private void openQuestion3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaArray.this);
        builder.setTitle("Can we clone an Array in Java?")
                .setIcon(R.drawable.codey_java_dyk)
                .setMessage("The answer is Yes. Since Java array implements cloneable interface, we can create the clone of the Java array.")
                .setPositiveButton("Okay", (dialogInterface, i) -> {
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        question_sounds.start();

    }

}