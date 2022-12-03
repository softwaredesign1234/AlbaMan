package model;

public class Apply {
    private int id;
    private String individualId;
    private String enterpriseId;
    private int announcementId;
    private Boolean passOrFail;

    public Apply(String individualId, String enterpriseId, int announcementId) {
        this.individualId = individualId;
        this.enterpriseId = enterpriseId;
        this.announcementId = announcementId;
    }


    //getter setter

    public String getIndividualId() {
        return individualId;
    }

    public void setIndividualId(String individualId) {
        this.individualId = individualId;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public int getAnnouncementId() { return announcementId; }

    public void setAnnouncementId(int announcementId) { this.announcementId = announcementId; }

    public Boolean getPassOrFail() {
        return passOrFail;
    }

    public void setPassOrFail(Boolean passOrFail) {
        this.passOrFail = passOrFail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
