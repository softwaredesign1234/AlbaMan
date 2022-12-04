package controller;

import boundary.DBBoundary;
import model.Apply;

import java.util.ArrayList;

import static java.lang.System.exit;

public class ApplyController {
    public static ArrayList<Apply> applyList=new ArrayList<>();
    public static DBBoundary dbManager;


    //기업->개인
    public static void makeApplytoIndividual(String individualId,String enterpriseId,int resumeId) throws Exception {
        return;
    }
    //개인->기업
    public static void makeApplytoEnterprise(String individualId, String enterpriseId,int announcementId){
        return;
    }


    //개인->기업 수락여부, 기업->개인 채용여부 return
    public Apply passOrNot(int applyId)
    {
        return null;
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

    public static ArrayList<Apply> getApplyList() {
        return applyList;
    }

    public void saveDB(Object o)
    {
        return;
    }
    public Object readDb(String dbname)
    {
        return null;
    }
    public ArrayList<Object> readDB(String tablename) {
        return null;
    }
}
