package controller;

import boundary.DBBoundary;
import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class ApplyController extends DBBoundary{
    public static ArrayList<Apply> applyList=new ArrayList<>();

    Apply apply;
    //기업->개인
    public static void makeApplytoIndividual(String individualId,String enterpriseId,int resumeId) throws Exception {
        return;
    }
    //개인->기업
    public Apply makeApplytoEnterprise(String individualId, String enterpriseId,int announcementId){
        System.out.println("Add apply to DB..");
        Apply a = new Apply();
        a.setIndividualId(individualId);
        a.setEnterpriseId(enterpriseId);
        a.setAnnouncementId(announcementId);
        saveApplyDB(a);
        return a;
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

    //오퍼 수락여부 전달
    public void sendResult(Apply applyResult)
    {
        //apply 안의 기업,개인에게 저장된 결과를 전달해줌
        //합격한다면 workhistory에 추가
        return;

    }
    public void addWorkHistory(String individualId, int announcementId){
        return;
    }

    public ArrayList<Apply> getApplyList() {
        applyList = readApplyDB();
        return applyList;
    }


    public static void main(String args[]){
        try {
            ApplyController applyController = new ApplyController();
            DBBoundary dbBoundary = new DBBoundary();
            dbBoundary.clearDB("Apply");
            applyController.makeApplytoIndividual("mo", "kakao", 1);


        }catch(Exception e){

        }
    }
}
