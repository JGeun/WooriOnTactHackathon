package jgeun.hackathon.wooriontact_parent.src.mypage.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import jgeun.hackathon.wooriontact_parent.src.child.InfoFragment1;
import jgeun.hackathon.wooriontact_parent.src.child.InfoFragment2;
import jgeun.hackathon.wooriontact_parent.src.child.InfoFragment3;
import jgeun.hackathon.wooriontact_parent.src.mypage.AdFragment;

public class ADAdapter extends FragmentStateAdapter {
    private Context context;
    private int mCount;
    public ADAdapter(FragmentActivity fa, int count) {
        super(fa);
        context = fa;
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);
        if(index==0) {
            return new AdFragment(3);
        }
        else if(index==1){
            return new AdFragment(4);
        }
        else if(index==2){
            return new AdFragment(0);
        }else if(index==3) {
            return new AdFragment(0);
        }else if(index==4) {
            return new AdFragment(0);
        } else{
            return new AdFragment(3);
        }
    }

    @Override
    public int getItemCount() {
        return mCount;
    }

    public int getRealPosition(int position) { return position % mCount; }
}
