package jgeun.hackathon.wooriontact_parent.src.mypage.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.src.mypage.data.InfoData;


public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private List<InfoData> list;
    public ProfileAdapter(ArrayList<InfoData> list){
        this.list = list;
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
        holder.mission.setText(list.get(position).getMission());
        if(list.get(position).isCLear())
            holder.missionClear.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
