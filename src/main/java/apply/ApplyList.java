package apply;

import resume.Resume;

import java.util.ArrayList;

import static java.lang.System.exit;

public class ApplyList {
    static ArrayList<Apply> applyList=new ArrayList<>();


    //기업->개인 지원 (giveOffer)
    public static void saveApply(String individualID,String enterpriseId) throws Exception {
        Apply apply=new Apply(individualID,enterpriseId);
        Boolean isAccepted=false;
        apply.addApply(individualID,enterpriseId,isAccepted);
        applyList.add(apply);
        System.out.println("Succefully applied !");

    }

    public static ArrayList<Apply> getApplyList() {
        return applyList;
    }

    //오퍼 수락여부 전달
    public void acceptOrNot(String individualId,Boolean accept)
    {
        ArrayList<Apply> arr=getApplyList();
        Apply apply=arr.stream()
                .filter(apply1 -> individualId.equals(apply1.getIndividualId()))
                .findAny()
                .orElse(null);

        apply.acceptOrnot(accept);

        if(accept=true)
        {
            //workHistory에 추가
        }
        else
            exit(0);
    }
}
