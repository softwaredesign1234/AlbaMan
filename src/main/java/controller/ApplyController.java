package controller;

import model.Apply;

import java.util.ArrayList;

import static java.lang.System.exit;

public class ApplyController {
    static ArrayList<Apply> applyList=new ArrayList<>();


    //기업->개인 지원 (giveOffer)
    public static void saveApply(String individualId,String enterpriseId) throws Exception {
        Apply apply=new Apply(individualId,enterpriseId,false);//지원 생성
    }

    public static ArrayList<Apply> getApplyList() {
        return applyList;
    }


    //개인에게 기업오퍼 전달, 수락여부 return
    public Boolean acceptIndividual(String individualId, String EnterpriseId, Boolean wantToAccept)
    {
        Boolean result=wantToAccept;
        return result;
    }
    //오퍼 수락여부 전달
    public void acceptOrNot(String individualId,Boolean accept,String enterpriseId)
    {
        ArrayList<Apply> arr=getApplyList();
        Apply apply=arr.stream()
                .filter(apply1 -> individualId.equals(apply1.getIndividualId()))
                .findAny()
                .orElse(null);

        apply.passOrFail(accept);

        if(accept=true)
        {
            //workHistory에 추가 (기업id, 개인id)
        }
        else
            exit(0);
    }
}
