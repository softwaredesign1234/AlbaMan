package boundary;

import controller.AnnouncementController;
import controller.ApplyController;
import model.Announcement;
import model.Apply;

import java.util.ArrayList;

public class AnnouncementBoundary {

    AnnouncementController announcementController = new AnnouncementController();
    ApplyController applyController = new ApplyController();
    Apply apply;

    public void inputAnnouncement(String enterpriseId,int wagePerHour,int workingHourPerWeek,int workingDaysPerWeek, String deadline) {
        try {
            Announcement announcement = new Announcement();
            announcement.setEnterpriseId(enterpriseId);
            announcement.setWagePerHour(wagePerHour);
            announcement.setWorkingHourPerWeek(workingHourPerWeek);
            announcement.setWorkingDaysPerWeek(workingDaysPerWeek);
            announcement.setDeadline(deadline);
            announcementController.makeAnnouncement(enterpriseId, wagePerHour, workingHourPerWeek, workingDaysPerWeek, deadline);
            System.out.println("User making announcement..");
            System.out.println("enterpriseId : "+enterpriseId+"...");

        }catch(Exception e){

        }
    }

    public void inputResult(){
        //input result of acceptance
        return;
    }

    public void showAnnouncement(ArrayList<Announcement> list){
        for(Announcement a : list){
            System.out.println(a.getId()+a.getEnterpriseId()+
                    a.getWagePerHour()+a.getWorkingHourPerWeek()+
                    a.getWorkingDaysPerWeek()+a.getDeadline());
        }

    }
    public void scrapAnnouncementId(String individualId, Announcement announcement)
    {
        announcementController.scrapAnnouncement(individualId,announcement);
    }

    public Apply inputApplyToEnterprise(String individualId, String enterpriseId, int announcementId) throws Exception {
        apply = applyController.makeApplytoEnterprise(individualId,enterpriseId,announcementId);
        return apply;
    }
    public void inputPassOrFail(int applyId, Boolean result)
    {
        applyController.passOrNot(applyId,result);
    }



}
