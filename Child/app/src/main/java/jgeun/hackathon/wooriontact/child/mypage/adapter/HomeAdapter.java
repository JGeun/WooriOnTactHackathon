package jgeun.hackathon.wooriontact.child.mypage.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import jgeun.hackathon.wooriontact.R;
import jgeun.hackathon.wooriontact.child.mypage.data.MissionData;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private ArrayList<MissionData> missonList;
    public HomeAdapter(ArrayList<MissionData> missonList){
        this.missonList = missonList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView indexText;
        private TextView mission;
        private ImageView missionClear;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            indexText = view.findViewById(R.id.homeitem_index);
            mission = view.findViewById(R.id.homeitem_contents);
            missionClear = view.findViewById(R.id.homeitem_clear);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.indexText.setText((position+1)+". ");
        holder.mission.setText(missonList.get(position).getMission());
        if(missonList.get(position).isCLear())
            holder.missionClear.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return missonList.size();
    }


}
