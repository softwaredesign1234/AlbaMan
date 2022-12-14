package controller;

import boundary.DBBoundary;
import model.Apply;
import model.EnterpriseAccount;
import model.IndividualAccount;
import model.Workhistory;

import java.util.ArrayList;

import static java.lang.System.exit;

public class ApplyController extends DBBoundary {
    static ArrayList<Apply> applyList=new ArrayList<>();

    public static ArrayList<Apply> getApplyList() {
        applyList = readApplyDB();
        return applyList;
    }
    public static Apply makeApplytoIndividual(String individualId,String enterpriseId) throws Exception
    {
        int id=getApplyList().size()+1;

        Apply apply=new Apply(id,individualId,enterpriseId,0,null);
        applyList.add(apply);
        saveApplyDB(apply);

        System.out.println("Apply success!");
        System.out.println("Apply id :"+apply.getId());
        System.out.println("Apply individualId :"+apply.getIndividualId());
        System.out.println("Apply enterpriseId :"+apply.getEnterpriseId());


        return apply;


    }

    //개인->기업 수락여부, 기업->개인 채용여부 return
    public void passOrNot(Apply apply, boolean result)
    {
        applyList.clear();
        applyList = readApplyDB();
        clearDB("Question");
        for (Apply a : applyList){
            if (a.getId() == apply.getId()) {
                apply = a;
                a.setPassOrFail(result);
                saveApplyDB(a);
            }
            else{
                saveApplyDB(a);
            }
        }
        if(result == true){
            System.out.println("Passed!");
            Workhistory workhistory = new Workhistory(apply.getEnterpriseId(),apply.getIndividualId());
            saveWorkHistoryDB(workhistory);
        }
        else{
            System.out.println("Failed..");
        }
        return;
    }

    //개인에게 기업오퍼 전달, 수락여부 return
    //db에서 한줄만 수정하는 동작
    //오퍼 수락여부 전달
    public static void sendResult(int applyId,Boolean accept)
    {
        ArrayList<Apply> arr=readApplyDB();
        Apply apply=arr.stream()
                .filter(apply1 -> applyId==apply1.getId())
                .findAny()
                .orElse(null);

        apply.setPassOrFail(accept);

        if(accept==true)
        {
            //workHistory에 추가 (기업id, 개인id)
            Workhistory workhistory=new Workhistory(apply.getEnterpriseId(),apply.getIndividualId());
            saveWorkHistoryDB(workhistory);

            //apply 내역 업데이트
//            deleteApplyDB(applyId);
//            saveApplyDB(apply);
            System.out.println("Apply is accepted!");
        }
        else
            System.out.println("Apply is not accepted!");
    }

    public Apply makeApplytoEnterprise(String individualId, String enterpriseId,int announcementId){
        System.out.println("Add apply to DB..");
        Apply a = new Apply();
        a.setIndividualId(individualId);
        a.setEnterpriseId(enterpriseId);
        a.setAnnouncementId(announcementId);
        saveApplyDB(a);
        return a;
    }

    public static void main(String[] args) throws Exception{


        makeApplytoIndividual("aa1111","bb1111");
        makeApplytoIndividual("aa0000","bb0000");
        makeApplytoIndividual("aa1234","bb1234");
//        deleteApplyDB(2);
        sendResult(1,true);
    }
}