package boundary;

import controller.AnnouncementController;
import controller.ApplyController;
import model.Announcement;
import model.Apply;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class AnnouncementBoundary {

    AnnouncementController announcementController = new AnnouncementController();
    ApplyController applyController = new ApplyController();
    Apply apply;

    public Announcement inputAnnouncement(String enterpriseId,int wagePerHour,int workingHourPerWeek,int workingDaysPerWeek, String deadline) {
        Announcement announcement = new Announcement();
        try {
            announcement.setEnterpriseId(enterpriseId);
            announcement.setWagePerHour(wagePerHour);
            announcement.setWorkingHourPerWeek(workingHourPerWeek);
            announcement.setWorkingDaysPerWeek(workingDaysPerWeek);
            announcement.setDeadline(deadline);
            announcementController.makeAnnouncement(enterpriseId, wagePerHour, workingHourPerWeek, workingDaysPerWeek, deadline);
            System.out.println("User making announcement..");
            System.out.println("enterpriseId : "+enterpriseId+" ... ");
        }catch(Exception e){

        }
        return announcement;
    }

    public void inputResult(){
        //input result of acceptance
        return;
    }

    public void showAnnouncement(ArrayList<Announcement> list){
        System.out.println("\n-----Announcement List-----");
        for(Announcement a : list){
            System.out.println("ID : "+a.getId()+"\tEnterpriseId : "+a.getEnterpriseId()+
                    "\tDeadline : "+a.getDeadline()+"\tWagePerHour : "+a.getWagePerHour()+"\tWorking days per week : "+a.getWorkingDaysPerWeek());
        }
        System.out.println();

    }
    public void scrapAnnouncementId(String individualId, Announcement announcement)
    {
        System.out.println("scrapAnnouncementId() \nscrapping announcement...");
        announcementController.scrapAnnouncement(individualId,announcement);
    }

    public Apply inputApplyToEnterprise(String individualId, String enterpriseId, int announcementId) throws Exception {
        System.out.println("\nIndividual User ("+individualId+") making apply to enterprise ("+enterpriseId+")");
        apply = applyController.makeApplytoEnterprise(individualId,enterpriseId,announcementId);
        return apply;
    }
    public void inputPassOrNot(Apply apply, Boolean result)
    {
        System.out.println("\nEnterprise user make result to apply\nApplying announcement id : "+apply.getAnnouncementId()+" \nresult : " + result);
        applyController.passOrNot(apply,result);
    }



}