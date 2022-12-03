package model;

public class WorkHistory {

    private String individualId;
    private String enterpriseName;

    public WorkHistory(String individualId) {
        this.individualId = individualId;
    }



    public String getIndividualId() {
        return individualId;
    }

    public void setIndividualId(String individualId) {
        this.individualId = individualId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
}
