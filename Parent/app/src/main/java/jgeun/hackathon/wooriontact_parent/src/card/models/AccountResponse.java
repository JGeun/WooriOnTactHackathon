package jgeun.hackathon.wooriontact_parent.src.card.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AccountResponse {

    @SerializedName("dataBody")
    private ResponseDataBody dataBody;

    public ResponseDataBody getDataBody() {
        return dataBody;
    }
}
