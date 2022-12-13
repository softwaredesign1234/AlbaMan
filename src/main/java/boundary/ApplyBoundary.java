package boundary;

import model.Apply;
import controller.ApplyController;

public class ApplyBoundary {

    public static ApplyController applyController;
    public static Apply inputapply(String individualId,String enterpriseId) throws Exception {
        Apply apply=applyController.makeApplytoIndividual(individualId,enterpriseId);

        return apply;

    }

    public static void inputResult(int applyId, Boolean acceptOrNot)
    {
        applyController.sendResult(applyId,acceptOrNot);

    }
    public static void main(String[] args) throws Exception{


//        makeApplytoIndividual("aa1111","bb1111");
//        makeApplytoIndividual("aa0000","bb0000");
//        makeApplytoIndividual("aa1234","bb1234");
////        deleteApplyDB(2);
        inputResult(1,true);
    }

}
