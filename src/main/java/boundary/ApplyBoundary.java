package boundary;

import model.Apply;
import controller.ApplyController;

public class ApplyBoundary {

    public static ApplyController applyController;
    public static Apply inputapply(String individualId,String enterpriseId) throws Exception {
        Apply apply=applyController.makeApplytoIndividual(individualId,enterpriseId);

        return apply;

    }

    public void inputResult(int applyId,Boolean acceptOrNot)
    {
        applyController.sendResult(applyId,acceptOrNot);

    }
    public Apply showApply()
    {
        return null;
    }

    public Apply sendApply()
    {
        return null;
    }

}
