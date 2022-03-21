package jgeun.hackathon.wooriontact_parent.src.child;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import jgeun.hackathon.wooriontact_parent.R;

public class InfoFragment1 extends Fragment {
    private EditText et_name;
    private String name;
    public static SharedPreferences sharedPreferences = null;
    private SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info1, container, false);

        sharedPreferences = getActivity().getSharedPreferences("pay", Context.MODE_PRIVATE);
        ;
        editor = sharedPreferences.edit();


        et_name = view.findViewById(R.id.info_childName);

        et_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    name = et_name.getText().toString();
                    editor.putString("이름", name);
                    editor.apply();
                }
            }
        });
        return view;
    }
}
