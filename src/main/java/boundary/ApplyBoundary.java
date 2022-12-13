package boundary;

import controller.ApplyController;
import model.Apply;

public class ApplyBoundary {
    ApplyController applyController = new ApplyController();
    Apply apply;
    public Apply inputApplyToEnterprise(String individualId,String enterpriseId,int announcementId) throws Exception {
        apply = applyController.makeApplytoEnterprise(individualId,enterpriseId,announcementId);
        return apply;
    }

    public void inputPassOrFail(Boolean result)
    {

    }

    public void inputResultTo()
    {

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
