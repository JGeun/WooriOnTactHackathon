package jgeun.hackathon.wooriontact_parent.src.mypage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.src.child.ChildInfoActivity;
import jgeun.hackathon.wooriontact_parent.src.child.RegisterChildActivity;
import jgeun.hackathon.wooriontact_parent.src.child.adapter.InfoAdapter;
import jgeun.hackathon.wooriontact_parent.src.mypage.adapter.ADAdapter;
import jgeun.hackathon.wooriontact_parent.src.mypage.adapter.HomeAdapter;
import me.relex.circleindicator.CircleIndicator3;


public class HomeFragment extends Fragment {
    private ViewPager2 buyViewpager;
    private HomeAdapter homeAdapter;
    private CircleIndicator3 buyIndicator;

    private ViewPager2 adViewpager;
    private ADAdapter adAdapter;
    private CircleIndicator3 adIndicator;

    private String name;

    private TextView buyPageNumber;
    private TextView buyPageMaxNumber;

    private TextView adPageNumber;
    private TextView adPageMaxNumber;

    public HomeFragment(String name){
        this.name = name;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView childName1 = view.findViewById(R.id.home_childName1);
        childName1.setText(name);
        TextView childName2 = view.findViewById(R.id.home_childName2);
        childName2.setText(name);
        TextView childName3 = view.findViewById(R.id.home_childName3);
        childName3.setText(name);

        LinearLayout changeSetting = view.findViewById(R.id.home_changeSetting);
        changeSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RegisterChildActivity.class));
            }
        });

        buyPageNumber = view.findViewById(R.id.buy_pageNumber);
        buyPageMaxNumber = view.findViewById(R.id.buy_pageMaxNumber);
        buyPageMaxNumber.setText(Integer.toString(4));

        adPageNumber = view.findViewById(R.id.ad_pageNumber);
        adPageMaxNumber = view.findViewById(R.id.ad_pageMaxNumber);
        adPageMaxNumber.setText(Integer.toString(4));

        buyViewpager = view.findViewById(R.id.buy_viewpager);
        homeAdapter = new HomeAdapter((FragmentActivity) view.getContext(), 4);
        buyViewpager.setAdapter(homeAdapter);
        buyViewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        buyViewpager.setOffscreenPageLimit(3);

        buyViewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    buyViewpager.setCurrentItem(position);

                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                buyPageNumber.setText(Integer.toString(position+1));
//                buyIndicator.animatePageSelected(position%4);
            }
        });

        adViewpager = view.findViewById(R.id.ad_viewpager);
        //adIndicator = view.findViewById(R.id.ad_indicator);
        ADAdapter adAdapter = new ADAdapter((FragmentActivity) view.getContext(), 4);
        adViewpager.setAdapter(adAdapter);
        //adIndicator.setViewPager(adViewpager);
        //adIndicator.createIndicators(4,0);
        adViewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        //viewpager.setCurrentItem(1000);
        adViewpager.setOffscreenPageLimit(3);

        adViewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels == 0) {
                    adViewpager.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                adPageNumber.setText(Integer.toString(position+1));
               // adIndicator.animatePageSelected(position%4);
            }
        });
        return view;
    }
}