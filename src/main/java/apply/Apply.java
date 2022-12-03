package apply;

import java.util.ArrayList;
import resume.Resume;
import resume.ResumeList;


//기업->개인 Offer에 관한 클래스
public class Apply {
    private String individualId;
    private String enterpriseId;

    private int id;
    private Boolean passOrFail=false; //기업->개인, 개인-> 기업 다르므로
    //기업->개인용 apply랑
    //개인->기업용 apply랑 생성자 따로 두기

    public Apply(String individualId,String enterpriseId)
    {
        this.individualId=individualId;
        this.enterpriseId=enterpriseId;
    }

    //기업->개인
    public Apply(String individualId, String enterpriseId,Boolean isAccept)
    {
        this.enterpriseId=enterpriseId;
        this.individualId=individualId;
        this.passOrFail=isAccept;

        System.out.println("Succefully added!");
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
