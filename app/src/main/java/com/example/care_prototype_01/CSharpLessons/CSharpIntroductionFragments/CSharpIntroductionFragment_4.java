package com.example.care_prototype_01.CSharpLessons.CSharpIntroductionFragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.care_prototype_01.R;

public class CSharpIntroductionFragment_4 extends Fragment {

    private MediaPlayer question_sounds;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c_sharp_introduction_4, container, false);

        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);


        Button btnP_Intro_Q1 = view.findViewById(R.id.P_Intro_btnQ1);
        Button btnP_Intro_Q2 = view.findViewById(R.id.P_Intro_btnQ2);
        Button btnP_Intro_Q3 = view.findViewById(R.id.P_Intro_btnQ3);
        btnP_Intro_Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_Intro_Q1();
            }
        });
        btnP_Intro_Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_Intro_Q2();
            }
        });
        btnP_Intro_Q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_Intro_Q3();
            }
        });
        return view;
    }
    private void btnP_Intro_Q1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("What is .NET Framework?");
        alertDialogBuilder.setMessage("The .NET Framework refers to a software development framework developed by Microsoft. It includes the Common Language Runtime (CLR) and a vast library called the Base Class Library (BCL) that provides a wide range of pre-built functions and APIs for developing Windows applications. The .NET Framework supports multiple programming languages such as C#, Visual Basic.NET, and F#, allowing developers to write code in their preferred language while leveraging the features and capabilities of the framework. It provides a managed execution environment, automatic memory management through garbage collection, and various other services such as security, exception handling, and thread management.");
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
    private void btnP_Intro_Q2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("What is the relationship of C# and .NET?");
        alertDialogBuilder.setMessage("C# is one of the programming languages supported by the .NET framework. When you write code in C#, you are using the language to develop applications that run on the .NET framework. C# code is compiled into an intermediate language called Common Intermediate Language (CIL) or Microsoft Intermediate Language (MSIL), which can be executed by the CLR. In summary, C# is a programming language, while .NET is a development framework. C# is used to write code, while .NET provides the infrastructure and tools for running and executing that code. C# is tightly integrated with the .NET framework and is often the language of choice for developing applications that leverage the capabilities and libraries provided by .NET.");
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
    private void btnP_Intro_Q3() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("What makes C# so unique?");
        alertDialogBuilder.setMessage("What sets apart from C# is specifically designed to work seamlessly with the .NET ecosystem. It has a large community of developers so anyone even the beginners can work with ease and ask for help. Unique features and the combination of C#'s language design, integration with the .NET platform, and development tooling make it a popular and versatile choice for a wide range of application development scenarios.");
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