package jgeun.hackathon.wooriontact_parent.src.mypage;

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

import java.util.ArrayList;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.src.child.ChildInfoActivity;
import jgeun.hackathon.wooriontact_parent.src.child.RegisterChildActivity;
import jgeun.hackathon.wooriontact_parent.src.mypage.adapter.ProfileAdapter;
import jgeun.hackathon.wooriontact_parent.src.mypage.data.InfoData;

public class ProfileFragment extends Fragment {
    private String name;
    private SharedPreferences sharedPreferences;

    public ProfileFragment(String name) {
        this.name = name;
    }

    private ArrayList<InfoData> missonList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        sharedPreferences = getActivity().getSharedPreferences("pay", Context.MODE_PRIVATE);

        TextView childName1 = view.findViewById(R.id.profile_tv_childName1);
        childName1.setText(name);
        TextView childName2 = view.findViewById(R.id.profile_tv_childName2);
        childName2.setText(name);
        TextView childName3 = view.findViewById(R.id.profile_tv_childName3);
        childName3.setText(name);

        LinearLayout changeSetting = view.findViewById(R.id.profile_changeSetting);
        changeSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RegisterChildActivity.class));
            }
        });

        missonList.clear();
        setMission(sharedPreferences.getString("mission1", ""), "일주일마다 15,000원 저축하기");
        setMission(sharedPreferences.getString("mission2", ""), "게임에 10,000원 이하로 사용하기");
        setMission(sharedPreferences.getString("mission3", ""), "군것질 30,000원 이하로 사용하기");
        setMission(sharedPreferences.getString("mission4", ""), "문구점에서 준비물 사오기");

        RecyclerView missionView = view.findViewById(R.id.home_rv_mission);
        missionView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        missionView.setAdapter(new ProfileAdapter(missonList));

        ArrayList<InfoData> creditList = new ArrayList<>();
        creditList.add(new InfoData("쿠키런 킹덤 2,000원", false));
        creditList.add(new InfoData("동아문방구 3,000원", false));
        creditList.add(new InfoData("이마트 이수점 9,900원", false));
        creditList.add(new InfoData("네이버페이 6,100원", false));
        RecyclerView creditView = view.findViewById(R.id.home_rv_credit);
        creditView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        creditView.setAdapter(new ProfileAdapter(creditList));
        return view;
    }

    public void setMission(String mission, String msg) {
        if (!mission.equals("")) {
            missonList.add(new InfoData(mission, true));
        } else {
            missonList.add(new InfoData(msg, true));
        }
    }
}
