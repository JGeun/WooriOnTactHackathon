package jgeun.hackathon.wooriontact_parent.src.mypage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import jgeun.hackathon.wooriontact_parent.R;

public class AdFragment extends Fragment {
    private int check;

    public AdFragment(int check) {
        this.check = check;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ad, container, false);
        ImageView imageView = view.findViewById(R.id.image1);
        View alterView = view.findViewById(R.id.image2);


        if (check == 0) {
            imageView.setVisibility(View.INVISIBLE);
            alterView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.VISIBLE);
            alterView.setVisibility(View.INVISIBLE);
            if (check == 1) {
                imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.buy1, null));
            } else if (check == 2) {
                imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.buy2, null));
            }else if (check == 3) {
                imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ad1, null));
            }else if (check == 4) {
                imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ad2, null));
            }
        }
        return view;
    }
}
