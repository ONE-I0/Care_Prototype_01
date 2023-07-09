package com.example.care_prototype_01.PythonLessons.PythonArraysFragments;

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

public class PythonArraysFragment_4 extends Fragment {

    private MediaPlayer question_sounds;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_python_arrays_4, container, false);

        //declare for the sounds
        question_sounds = MediaPlayer.create(requireActivity(), R.raw.question);


        Button btnP_array_Q1 = view.findViewById(R.id.P_array_btnQ1);
        Button btnP_array_Q2 = view.findViewById(R.id.P_array_btnQ2);
        Button btnP_array_Q3 = view.findViewById(R.id.P_array_btnQ3);
        btnP_array_Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_array_Q1();
            }
        });
        btnP_array_Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_array_Q2();
            }
        });
        btnP_array_Q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnP_array_Q3();
            }
        });
        return view;
    }
    private void btnP_array_Q1() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("What is the difference between a list and an array in Python?");
        alertDialogBuilder.setMessage("In Python, a list is a built-in data structure in Python that emerges, possessing the extraordinary ability to house an assortment of elements, regardless of their diverse data types. This captivating creation is both dynamic and resizable, a collection of items that pulsates with life. On the contrary, an array is not built-in to Python, exists solely through external modules like NumPy. Arrays, those enigmatic entities, consist of a harmonious congregation of elements with a fixed size.");
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
    private void btnP_array_Q2() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("How do I check if a specific element exists in a Python array?");
        alertDialogBuilder.setMessage("To check if a specific element exists in a Python array, you can use the in operator or the index() method. Here's how you can do it:\n" +
                "\n" +
                "Using in() method:\n" +
                "\n" +
                "my_array = [1, 2, 3, 4, 5]\n" +
                "\n" +
                "if 3 in my_array:\n" +
                "    print(\"The element 3 exists in the array.\")\n" +
                "else:\n" +
                "    print(\"The element 3 does not exist in the array.\")\n" +
                "\n" +
                "Output:\n" +
                "The element 3 exists in the array.\n" +
                "\n" +
                "Using index() method:\n" +
                "\n" +
                "my_array = [1, 2, 3, 4, 5]\n" +
                "\n" +
                "try:\n" +
                "    index = my_array.index(3)\n" +
                "    print(f\"The element 3 exists at index {index}.\")\n" +
                "except ValueError:\n" +
                "    print(\"The element 3 does not exist in the array.\")\n" +
                "\n" +
                "Output:\n" +
                "The element 3 exists at index 2.\n");
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
    private void btnP_array_Q3() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(requireContext());
        alertDialogBuilder.setIcon(R.drawable.codey_python_cut);
        alertDialogBuilder.setTitle("How do I perform mathematical operations on Python arrays?");
        alertDialogBuilder.setMessage("To perform mathematical operations on Python arrays, you can utilize the NumPy library, which provides a powerful array manipulation and numerical computing functionality. There, you can unlock different methods that can be used to perform mathematical operation on Python arrays.");
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