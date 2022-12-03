package model;


public class Apply {
    private String individualId;
    private String enterpriseId;

    private int id;
    private Boolean passOrFail=false; //기업->개인, 개인-> 기업 다르므로

    private int announcementId;
    public Apply(String individualId,String enterpriseId)
    {
        this.individualId=individualId;
        this.enterpriseId=enterpriseId;
    }

    //기업->개인
    public Apply(String individualId, String enterpriseId,Boolean isAccept,int announcementId)
    {
        this.enterpriseId=enterpriseId;
        this.individualId=individualId;
        this.passOrFail=isAccept;
        this.announcementId=announcementId;
    }

    public void passOrFail(Boolean accept)
    {

        this.passOrFail=accept;
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
    public Boolean getAccept() {
        return passOrFail;
    }

    public void setAccept(Boolean accept) {
        passOrFail = accept;
    }
}
