package boundary;

import controller.ResumeController;
import model.IndividualAccount;
import model.Resume;

import java.util.Scanner;

public class ResumeBoundary {
    Scanner sc=new Scanner(System.in);
    public static ResumeController r;
    public static Resume inputResume(String individualId, String selfIntroduction, String workExperience, Boolean isopen) throws Exception {

        Resume resume=r.saveResume(individualId,selfIntroduction,workExperience,isopen);

        return resume;


    }

    public static Resume showResume(int resumeId)
    {

        Resume resume=r.showResume(resumeId);
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
