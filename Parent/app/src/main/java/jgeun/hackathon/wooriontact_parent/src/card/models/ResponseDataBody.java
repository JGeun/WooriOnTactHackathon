package jgeun.hackathon.wooriontact_parent.src.card.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseDataBody {
    @SerializedName("GRID_CNT")
    private int bodyCount;

    @SerializedName("GRID")
    private ArrayList<AccData> accList;

    public int getBodyCount() {
        return bodyCount;
    }

    public ArrayList<AccData> getAccList() {
        return accList;
    }
}
