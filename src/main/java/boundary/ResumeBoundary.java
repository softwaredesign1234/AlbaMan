package boundary;

import controller.ResumeController;
import model.IndividualAccount;
import model.Resume;


public class ResumeBoundary {
    public static ResumeController resumeController;
    public static Resume inputResume(String individualId, String selfIntroduction, String workExperience, Boolean isopen) throws Exception {

        Resume resume=resumeController.saveResume(individualId,selfIntroduction,workExperience,isopen);

        return resume;


    }

    public static Resume showResume(int resumeId)
    {

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

}
