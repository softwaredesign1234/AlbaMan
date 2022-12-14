import boundary.AnnouncementBoundary;
import boundary.DBBoundary;
import controller.AnnouncementController;
import controller.ApplyController;
import model.Announcement;
import model.Apply;
import model.EnterpriseAccount;
import model.IndividualAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;

public class applyIndividualToEnterpriseTest {
    int option = 1;
    AnnouncementController announcementController = new AnnouncementController();
    ApplyController applyController = new ApplyController();
    AnnouncementBoundary announcementBoundary = new AnnouncementBoundary();
    DBBoundary dbBoundary = new DBBoundary();


    Announcement filteredAnnouncement;
    ArrayList<Announcement> announcementList1 = new ArrayList<>();

    IndividualAccount a1 = new IndividualAccount("aa0000@naver.com","010-0000-0000",25,"F","aa0000","0000","janny",true,true,"Individual");
    IndividualAccount a2 = new IndividualAccount("aa1111@naver.com","010-1111-1111",23,"M","1","1111","mo",true,true,"Individual");
    EnterpriseAccount e1 = new EnterpriseAccount("000-00-00000","Restaurant","053-222-2222","Daegu","bb0000","0000","steakhouse",true,true,"Enterprise");
    EnterpriseAccount e2 = new EnterpriseAccount("111-11-11111","IT","053-111-1111","Daegu","bb0001","0001","kakao",true,true,"Enterprise");

    Announcement a;
    Announcement b;
    Announcement c;
    Announcement d;



    @BeforeEach
    void setting(){
        try {
            dbBoundary.clearDB("Apply");
            dbBoundary.clearDB("Announcement");
            dbBoundary.clearDB("Scrap");
            announcementList1.clear();
            a = announcementBoundary.inputAnnouncement(e1.getId(), 12000, 50, 5, "22/12/31");
            b = announcementBoundary.inputAnnouncement(e1.getId(), 11000, 48, 4, "22/12/31");
            c = announcementBoundary.inputAnnouncement(e2.getId(), 10000, 46, 5, "22/12/31");
            d = announcementBoundary.inputAnnouncement(e2.getId(), 9000, 40, 4, "22/12/31");
            a.setId(1);
            b.setId(2);
            c.setId(3);
            d.setId(4);

        }catch (Exception e){

        }
    }
    @Test
    @DisplayName("UC4-정상")
    public void applyAnnouncements(){
        try {
            announcementList1 = announcementController.getAnnouncementList();
            announcementBoundary.showAnnouncement(announcementList1);

            announcementList1.clear();
            announcementList1 = announcementController.readAnnouncementById(1);

            announcementBoundary.showAnnouncement(announcementList1);

            announcementList1.clear();
            announcementList1 = announcementController.readAnnouncementByWage(10000);
            announcementBoundary.showAnnouncement(announcementList1);

            announcementList1.clear();
            for (Announcement an : announcementController.readAnnouncementByName(e1.getId())) {
                announcementList1.add(an);
            }
            announcementBoundary.showAnnouncement(announcementList1);

            announcementList1.clear();
            announcementList1 = announcementController.readAnnouncementByDays(5);
            announcementBoundary.showAnnouncement(announcementList1);

            announcementList1.clear();
            announcementList1 = announcementController.readAnnouncementByHours(48);
            announcementBoundary.showAnnouncement(announcementList1);

            //scrap
            announcementBoundary.scrapAnnouncementId(a1.getId(),a);
            //makeApply
            try {
                Apply apply;
                apply = announcementBoundary.inputApplyToEnterprise(a1.getId(), e1.getId(), a.getId());
                announcementBoundary.inputPassOrNot(apply,true);
            }catch (Exception e) {

            }
            //delete
            announcementController.deleteAnnouncement(a.getId());
        }catch(Exception e){

        }
    }

    @Test
    @DisplayName("UC4-검색결과 없음")
    public void noResult(){
        announcementList1 = announcementController.getAnnouncementList();
        announcementBoundary.showAnnouncement(announcementList1);

        announcementList1.clear();
        announcementList1 = announcementController.readAnnouncementByWage(20000);
        announcementBoundary.showAnnouncement(announcementList1);
    }


    @Test
    @DisplayName("UC4-기업 지원 불합격")
    public void failedResult(){
        try {
            Apply apply;
            apply = announcementBoundary.inputApplyToEnterprise(a1.getId(), e1.getId(), a.getId());
            announcementBoundary.inputPassOrNot(apply,false);
        }catch (Exception e){

        }
    }

    @Test
    @DisplayName("UC4-공고기한 만료")
    public void deadlinePassed(){
        String today = "23/1/1";
        boolean passed = announcementController.deadlinePassed(today,a);
    }
    @Test
    @DisplayName("UC11-공고 임금 계산기")
    public void calculateWage(){
        int wage;
        Announcement announcement = new Announcement();
        announcementList1 = announcementController.getAnnouncementList();
        announcementBoundary.showAnnouncement(announcementList1);

        announcementList1.clear();
        announcementList1 = announcementController.readAnnouncementById(1);
        announcementBoundary.showAnnouncement(announcementList1);
        for (Announcement an : announcementList1){
            announcement = an;
        }

        wage = announcementController.CalculatedWage(announcement);

    }
}