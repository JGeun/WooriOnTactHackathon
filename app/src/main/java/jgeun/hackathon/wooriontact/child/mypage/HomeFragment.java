package jgeun.hackathon.wooriontact.child.mypage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import jgeun.hackathon.wooriontact.R;
import jgeun.hackathon.wooriontact.child.makeCard.MakeCardActivity;
import jgeun.hackathon.wooriontact.child.mypage.adapter.HomeAdapter;
import jgeun.hackathon.wooriontact.child.mypage.data.MissionData;
import jgeun.hackathon.wooriontact.child.signup.ChildSignUpActivity;

public class HomeFragment extends Fragment {
    private String name;
    public HomeFragment(String name){
        this.name = name;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        LinearLayout changeDesignButton = view.findViewById(R.id.home_btn_changeCardDesign);
        changeDesignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MakeCardActivity.class));
            }
        });

        TextView nameText =  view.findViewById(R.id.home_tv_name);
        nameText.setText(name);
        ArrayList<MissionData> missonList = new ArrayList<>();
        missonList.add(new MissionData("일주일 동안 100,000원 이하 사용하기", true));
        missonList.add(new MissionData("일주일 동안 100,000원 이하 사용하기", true));
        missonList.add(new MissionData("일주일 동안 100,000원 이하 사용하기", false));
        missonList.add(new MissionData("일주일 동안 100,000원 이하 사용하기", true));
        missonList.add(new MissionData("일주일 동안 100,000원 이하 사용하기", false));

        RecyclerView recyclerView=view.findViewById(R.id.home_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new HomeAdapter(missonList));
        return view;
    }
}
