package jgeun.hackathon.wooriontact_parent.src.card.models;

import com.google.gson.annotations.SerializedName;

public class AccountRequest {
    @SerializedName("dataHeader")
    private DataHeader dataHeader;

    public AccountRequest(DataHeader dataHeader) {
        this.dataHeader = dataHeader;
    }

    public void setDataHeader(DataHeader dataHeader) {
        this.dataHeader = dataHeader;
    }

    public DataHeader getDataHeader() {
        return dataHeader;
    }
}
