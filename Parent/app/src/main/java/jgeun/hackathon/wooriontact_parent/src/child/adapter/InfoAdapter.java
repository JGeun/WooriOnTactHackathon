package jgeun.hackathon.wooriontact_parent.src.child.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import jgeun.hackathon.wooriontact_parent.src.child.InfoFragment1;
import jgeun.hackathon.wooriontact_parent.src.child.InfoFragment2;
import jgeun.hackathon.wooriontact_parent.src.child.InfoFragment3;

public class InfoAdapter extends FragmentStateAdapter {
    private Context context;
    private int mCount;
    public InfoAdapter(FragmentActivity fa, int count) {
        super(fa);
        context = fa;
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);
        if(index==0) {
            return new InfoFragment1();
        }
        else if(index==1){
            return new InfoFragment2();
        }
        else if(index==2){
            return new InfoFragment3();
        }else{
            return new InfoFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return mCount;
    }

    public int getRealPosition(int position) { return position % mCount; }
}