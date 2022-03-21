package jgeun.hackathon.wooriontact.child.mypage.data;

public class MissionData {
    private String mission;
    private boolean isCLear;

    public MissionData(String mission, boolean isCLear) {
        this.mission = mission;
        this.isCLear = isCLear;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public boolean isCLear() {
        return isCLear;
    }

    public void setCLear(boolean CLear) {
        isCLear = CLear;
    }
}
