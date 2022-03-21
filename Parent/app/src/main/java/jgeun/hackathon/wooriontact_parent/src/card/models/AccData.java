package jgeun.hackathon.wooriontact_parent.src.card.models;

import com.google.gson.annotations.SerializedName;

public class AccData {
    @SerializedName("ACNO")
    private String accNumber;

    @SerializedName("ACCT_KND")
    private String accCategory;

    @SerializedName("PRD_NM")
    private String accName;

    @SerializedName("CUCD")
    private String accValue;

    @SerializedName("PBOK_BAL")
    private int balance;

    @SerializedName("FAXC_BAL")
    private int balance_fax;

    @SerializedName("NEW_DT")
    private String newDate;

    @SerializedName("XPR_DT")
    private String xprDate;

    @SerializedName("ADNT_RGS_YN")
    private String check1;

    @SerializedName("PSKL_ACT_YN")
    private String check2;

    @SerializedName("ACT_STCD")
    private String check3;

    public String getAccNumber() {
        return accNumber;
    }

    public String getAccCategory() {
        return accCategory;
    }

    public String getAccName() {
        return accName;
    }

    public String getAccValue() {
        return accValue;
    }

    public int getBalance() {
        return balance;
    }

    public int getBalance_fax() {
        return balance_fax;
    }

    public String getNewDate() {
        return newDate;
    }

    public String getXprDate() {
        return xprDate;
    }

    public String getCheck1() {
        return check1;
    }

    public String getCheck2() {
        return check2;
    }

    public String getCheck3() {
        return check3;
    }
}
