package care_fragments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.care_prototype_01.MainActivity;
import com.example.care_prototype_01.R;
import com.example.care_prototype_01.care_languages.CSharpLanguageActivity;
import com.example.care_prototype_01.care_languages.JavaLanguageActivity;
import com.example.care_prototype_01.care_languages.PythonLanguageActivity;

public class HomeFragment extends Fragment {

    private MediaPlayer codeymainintro;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Declare for the sounds
        codeymainintro = MediaPlayer.create(requireActivity(), R.raw.codeymainintro);
        codeymainintro.start();

        ImageButton btnJava = view.findViewById(R.id.btnJava);
        MainActivity mainActivity1 = (MainActivity) getActivity();

        ImageButton btnPython = view.findViewById(R.id.btnPython);
        MainActivity mainActivity2 = (MainActivity) getActivity();

        ImageButton btnC = view.findViewById(R.id.btnC);
        MainActivity mainActivity3 = (MainActivity) getActivity();
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent OpenPythonLessons = new Intent(getActivity(), CSharpLanguageActivity.class);
                startActivity(OpenPythonLessons);
            }
        });
        btnPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent OpenPythonLessons = new Intent(getActivity(), PythonLanguageActivity.class);
                startActivity(OpenPythonLessons);
            }
        });
        btnJava.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent OpenJavaLessons = new Intent(getActivity(), JavaLanguageActivity.class);
                startActivity(OpenJavaLessons);
            }
        });
        return view;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        // Release the MediaPlayer resources when the activity is destroyed
        if (codeymainintro != null) {
            codeymainintro.release();
            codeymainintro = null;
        }
    }

}