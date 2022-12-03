package controller;

import model.Apply;

import java.util.ArrayList;

import static java.lang.System.exit;

public class ApplyController {
    static ArrayList<Apply> applyList=new ArrayList<>();


    //기업->개인 지원 (giveOffer)
    public static void saveApply(String individualId,String enterpriseId) throws Exception {
    }

    public static ArrayList<Apply> getApplyList() {
        return applyList;
    }


    //개인에게 기업오퍼 전달, 수락여부 return
    public Boolean acceptIndividual(String individualId, String EnterpriseId, Boolean wantToAccept)
    {
        return null;
    }
    //오퍼 수락여부 전달
    public void acceptOrNot(String individualId,Boolean accept,String enterpriseId)
    {
    }
    public void saveDB(Object o)
    {
        //받은 obeject를 string으로 변환해서 text파일에 저장하기
    }
    public Object readDb(String dbname)
    {
        return null;
    }


    public ArrayList<Object> readDB(String tablename) {
        return null;
    }
}
