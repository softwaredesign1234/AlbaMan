package apply;

import java.util.ArrayList;
import resume.Resume;
import resume.ResumeList;


//기업->개인 Offer에 관한 클래스
public class Apply {
    private String individualId;
    private String enterpriseId;



    private Boolean isAccept=false;


    public static ArrayList<Apply> applyList=new ArrayList<>();

    public Apply(String individualId,String enterpriseId)
    {
        this.individualId=individualId;
        this.enterpriseId=enterpriseId;
    }

    //기업->개인
    public void addApply(String individualId, String enterpriseId,Boolean isAccept)
    {
        this.enterpriseId=enterpriseId;
        this.individualId=individualId;
        this.isAccept=isAccept;

        System.out.println("Succefully added!");
    }

    public void acceptOrnot(Boolean accept)
    {

        this.isAccept=accept;
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
        return isAccept;
    }

    public void setAccept(Boolean accept) {
        isAccept = accept;
    }
}
