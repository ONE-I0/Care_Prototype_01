package care_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;


import com.example.care_prototype_01.R;
import com.example.care_prototype_01.care_languages.CSharpLanguageActivity;
import com.example.care_prototype_01.care_languages.JavaLanguageActivity;
import com.example.care_prototype_01.care_languages.PythonLanguageActivity;

public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        ImageButton btnJava = view.findViewById(R.id.btnJava);
        ImageButton btnPython = view.findViewById(R.id.btnPython);
        ImageButton btnC = view.findViewById(R.id.btnC);

        btnC.setOnClickListener(view1 -> {
            Intent OpenCLessons = new Intent(getActivity(), CSharpLanguageActivity.class);
            startActivity(OpenCLessons);
            getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        btnPython.setOnClickListener(view12 -> {
            Intent OpenPythonLessons = new Intent(getActivity(), PythonLanguageActivity.class);
            startActivity(OpenPythonLessons);
            getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        btnJava.setOnClickListener(view13 -> {
            Intent OpenJavaLessons = new Intent(getActivity(), JavaLanguageActivity.class);
            startActivity(OpenJavaLessons);
            getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        return view;
    }
}