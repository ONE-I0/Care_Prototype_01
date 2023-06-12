package care_fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.care_prototype_01.MainActivity;
import com.example.care_prototype_01.R;
import com.example.care_prototype_01.care_languages.JavaLanguageActivity;

public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageButton btnJava = view.findViewById(R.id.btnJava);
        MainActivity mainActivity = (MainActivity) getActivity();
        btnJava.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent OpenJavaLessons = new Intent(getActivity(), JavaLanguageActivity.class);
                startActivity(OpenJavaLessons);
            }
        });
        return view;
    }
}