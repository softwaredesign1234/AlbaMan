package model;


public class Apply {
    private String individualId;
    private String enterpriseId;
    private int id;
    private Boolean passOrFail=false; //기업->개인, 개인-> 기업 다르므로
    private int announcementId;

    public Apply(int id,String individualId, String enterpriseId,int announcementId,Boolean isAccept)
    {
        this.id=id;
        this.enterpriseId=enterpriseId;
        this.individualId=individualId;
        this.passOrFail=isAccept;
        this.announcementId=announcementId;
    }

    public Apply() {

    }


    //getter, setter
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

    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getPassOrFail() {
        return passOrFail;
    }

    public void setPassOrFail(Boolean passOrFail) {
        this.passOrFail = passOrFail;
    }
}
