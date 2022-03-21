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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import jgeun.hackathon.wooriontact_parent.R;

public class InfoFragment3 extends Fragment{
    public static SharedPreferences sharedPreferences = null;
    private SharedPreferences.Editor editor;

    private EditText mission1;
    private EditText mission2;
    private EditText mission3;
    private EditText mission4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info3, container, false);

        sharedPreferences = getActivity().getSharedPreferences("pay", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.putString("mission1", "일주일마다 15,000원 저축하기");
        editor.putString("mission2", "게임에 10,000원 이하로 사용하기");
        editor.putString("mission3", "군것질 30,000원 이하로 사용하기");
        editor.putString("mission4", "문구점에서 준비물 사오기");
        editor.apply();

        mission1 = view.findViewById(R.id.info3_mission1);
        mission2 = view.findViewById(R.id.info3_mission2);
        mission3 = view.findViewById(R.id.info3_mission3);
        mission4 = view.findViewById(R.id.info3_mission4);

        mission1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editor.putString("mission1", mission1.getText().toString());
                editor.apply();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        mission2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editor.putString("mission2", mission2.getText().toString());
                editor.apply();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        mission3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editor.putString("mission3", mission3.getText().toString());
                editor.apply();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        mission4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editor.putString("mission4", mission4.getText().toString());
                editor.apply();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        return view;
    }

}
