package boundary;

import controller.ApplyController;
import controller.ResumeController;
import model.Apply;
import model.Resume;


public class ResumeBoundary {
    public static ApplyController applyController;

    public static ResumeController resumeController;
    public static Resume inputResume(String individualId, String selfIntroduction, String workExperience, Boolean isopen) throws Exception {
        System.out.println("ResumeBoundary - inputResume() visited");

        Resume resume=resumeController.saveResume(individualId,selfIntroduction,workExperience,isopen);

        return resume;


    }

    public static Resume showResume(int resumeId)
    {
        System.out.println("ResumeBoundary - showResume() visited");


        Resume resume=resumeController.showResume(resumeId);
        if(resume!=null)
        {
            System.out.println("resumeId: "+resume.getId());
            System.out.println("resumeSelfIntroduction: "+resume.getSelfIntroduction());
            System.out.println("resumeWorkExperience: "+resume.getWorkExperience());
            System.out.println("resumeIsOpened: "+resume.getOpened());
            System.out.println("resumeIndividualId: "+resume.getIndividualAccount());
        }
        return resume;
    }
    public static Apply inputapply(String individualId, String enterpriseId) throws Exception {
        System.out.println("ResumeBoundary - inputapply() visited");

        Apply apply=applyController.makeApplytoIndividual(individualId,enterpriseId);

        return apply;

    }

    public static void inputResult(int applyId, Boolean acceptOrNot)
    {
        System.out.println("ResumeBoundary - inputResult() visited");

        applyController.sendResult(applyId,acceptOrNot);

    }

}
