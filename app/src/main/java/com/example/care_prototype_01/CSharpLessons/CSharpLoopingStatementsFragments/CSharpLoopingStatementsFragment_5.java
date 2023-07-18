package com.example.care_prototype_01.CSharpLessons.CSharpLoopingStatementsFragments;

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


public class CSharpLoopingStatementsFragment_5 extends Fragment {

    private MediaPlayer question_sounds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c_sharp_looping_statements_5, container, false);

        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);


        Button btnP_loop_Q1 = view.findViewById(R.id.P_loop_btnQ1);
        Button btnP_loop_Q2 = view.findViewById(R.id.P_loop_btnQ2);
        Button btnP_loop_Q3 = view.findViewById(R.id.P_loop_btnQ3);
        btnP_loop_Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_loop_Q1();
            }
        });
        btnP_loop_Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_loop_Q2();
            }
        });
        btnP_loop_Q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_loop_Q3();
            }
        });
        return view;
    }
    private void btnP_loop_Q1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_c_cut);
        alertDialogBuilder.setTitle("What is the concept of nested loops in C#?");
        alertDialogBuilder.setMessage("In C#, the use of one loop inside another is referred to as the concept of nested loops. This indicates that there are two loops—an outer loop and an inner loop—each of which is entirely enclosed within the outer loop's body. For each time the outer loop iterates, the inside loop will also repeats repeatedly.\n" +
                "As an example of nested loops in C#, consider the following:\n" +
                "for (int i = 1; i <= 3; i++) // Outer loop\n" +
                "{\n" +
                "    for (int j = 1; j <= 3; j++) // Inner loop\n" +
                "    {\n" +
                "        Console.WriteLine(\"Outer loop: \" + i + \", Inner loop: \" + j);\n" +
                "    }\n" +
                "}\n" +
                "In this illustration, the outer loop iterates from 1 to 3. An inner loop that iterates from 1 to 3 is present inside the outer loop. The inner loop will complete all of its iterations for each iteration of the outer loop. Both the inner loop variable (j) and the outer loop variable (i) will show their current values in the output.\n" +
                "The end outcome is:\n" +
                "Outer loop: 1, Inner loop: 1\n" +
                "Outer loop: 1, Inner loop: 2\n" +
                "Outer loop: 1, Inner loop: 3\n" +
                "Outer loop: 2, Inner loop: 1\n" +
                "Outer loop: 2, Inner loop: 2\n" +
                "Outer loop: 2, Inner loop: 3\n" +
                "Outer loop: 3, Inner loop: 1\n" +
                "Outer loop: 3, Inner loop: 2\n" +
                "Outer loop: 3, Inner loop: 3\n" +
                "When processing multi-dimensional arrays, navigating hierarchical data structures, or carrying out operations on combinations of elements, nested loops are frequently utilized. They offer a method for managing repetitive work involving various iterations in a systematic fashion.\n");
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
    private void btnP_loop_Q2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_c_cut);
        alertDialogBuilder.setTitle("In C#, how do I utilize a \"foreach\" loop to iterate over a collection and apply a conditional statement to perform specific actions?");
        alertDialogBuilder.setMessage("The steps below describe how to use a \"foreach\" loop in C# to iterate over a collection and apply a conditional statement:\n" +
                "•\tMake sure you have a collection that you intend to iterate over before declaring the collection. This can be an IEnumerable interface-implemented type such as an array, list, or other type.\n" +
                "•\tUtilize the \"foreach\" loop: To cycle through each element of the collection, use the \"foreach\" loop construct in C#. Without a specific index, the loop automatically iterates through each element.\n" +
                "•\tApply the conditional statement: Check the required condition using a \"if\" statement inside the loop. You can carry out particular actions or omit specific components depending on the condition.\n" +
                "Here is an illustration of how to use a \"foreach\" loop.\n" +
                "int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };\n" +
                "\n" +
                "foreach (int num in numbers)\n" +
                "{\n" +
                "    if (num % 2 == 0) // Condition to check if the number is even\n" +
                "    {\n" +
                "        Console.WriteLine(num + \" is even.\");\n" +
                "    }\n" +
                "    else\n" +
                "    {\n" +
                "        Console.WriteLine(num + \" is odd.\");\n" +
                "    }\n" +
                "}\n" +
                "We have an array of numbers in this case. The \"foreach\" loop goes over each item in the \"numbers\" array one by one. Using the modulo operator (%), the conditional statement inside the loop determines if the number is even or odd. It prints the appropriate message in accordance with the condition.\n" +
                "Input will result in:\n" +
                "1 is odd.\n" +
                "2 is even.\n" +
                "3 is odd.\n" +
                "4 is even.\n" +
                "5 is odd.\n" +
                "6 is even.\n" +
                "7 is odd.\n" +
                "8 is even.\n" +
                "9 is odd.\n" +
                "10 is even.\n" +
                "You can carry out particular operations or come to conclusions about each element in the collection by applying a conditional expression within the \"foreach\" loop.\n");
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
    private void btnP_loop_Q3() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_c_cut);
        alertDialogBuilder.setTitle("How can I use the \"if-else\" statement in C# to conditionally execute different sets of code based on a particular condition within a loop?");
        alertDialogBuilder.setMessage("You can use the \"if-else\" statement in C# to conditionally run various sets of code based on a specific circumstance inside a loop by doing the following:\n" +
                "1)\tSet up the loop: To start, decide whether you want to use a \"for\" loop, \"while\" loop, or \"do-while\" loop. This will control the loop's iteration and the timing of the conditional evaluation.\n" +
                "2)\tThe \"if-else\" phrase should be defined inside the loop to check the required condition. Any comparison or phrase that needs to be evaluated can serve as the basis for the condition.\n" +
                "3)\tWrite the code that should run in each case in the \"if\" block to indicate what should happen if the condition is true. Put the code that should run if the condition is false in the \"else\" block.\n" +
                "To demonstrate how to utilize the \"if-else\" expression inside of a loop in C#, consider the following example:\n" +
                "string[] fruits = { \"Apple\", \"Banana\", \"Orange\", \"Grapes\", \"Mango\" };\n" +
                "\n" +
                "foreach (string fruit in fruits)\n" +
                "{\n" +
                "    if (fruit.Length > 5) // Condition to check if the length of the fruit name is greater than 5\n" +
                "    {\n" +
                "        Console.WriteLine(fruit + \" is a long fruit name.\");\n" +
                "    }\n" +
                "    else\n" +
                "    {\n" +
                "        Console.WriteLine(fruit + \" is a short fruit name.\");\n" +
                "    }\n" +
                "}\n" +
                "In this case, there are several different fruit names. Each fruit in the \"fruits\" array is iterated over by the \"foreach\" loop. The \"if-else\" clause in the loop determines whether the fruit name is more than five characters. It prints that it is a long fruit name if the condition is true. It prints that it is a short fruit name if the condition is false.\n" +
                "\n" +
                "Input will result in:\n" +
                "Apple is a short fruit name.\n" +
                "Banana is a long fruit name.\n" +
                "Orange is a long fruit name.\n" +
                "Grapes is a short fruit name.\n" +
                "Mango is a long fruit name.\n" +
                "\n" +
                "In this case, the \"if-else\" statement enables us to classify the fruit names according to their length and carry out various operations as necessary. The \"if-else\" statement's conditions and actions can be modified in your own applications to meet your unique needs.\n");
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