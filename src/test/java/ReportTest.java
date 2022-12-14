import boundary.DBBoundary;
import boundary.ReportBoundary;
import controller.AccountController;
import controller.ReportController;
import model.IndividualAccount;
import model.Report;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Scanner;

public class ReportTest {

    @Mock
    AccountController accountController;

    @Mock
    IndividualAccount individual;
    ReportController reportController = new ReportController();

    DBBoundary dbBoundary = new DBBoundary();
    ReportBoundary reportBoundary = new ReportBoundary();

    IndividualAccount a1 = new IndividualAccount("aa0000@naver.com","010-0000-0000",25,"F","aa0000","0000","janny",true,true,"Individual");
    IndividualAccount a2 = new IndividualAccount("aa1111@naver.com","010-1111-1111",23,"M","aa1111","1111","mo",true,true,"Individual");
    ArrayList<IndividualAccount> individualList = new ArrayList<>();

    @BeforeEach
    void setting(){

        dbBoundary.clearDB("Report");

    }
    @Test
    @DisplayName("UC10-신고 정상")
    public void addReport() {
        String judgement = "";
        boolean isActive;
        String reportContext = reportBoundary.inputReport();
        Report r = new Report(a1.getId(),a2.getId(),reportContext);
        r.setId(1);
        reportController.addReport(a1.getId(),a2.getId(),reportContext);
        reportBoundary.showReport(r);

        judgement = reportBoundary.makeJudgement();
        r = reportController.findReport(a2.getId());


        individual = reportController.findMemberInfo(a2);
        isActive = reportController.deactivateMember(individual.getId());
        accountController.modifyIndividualAccountInfo(individual.getId(),9,"isActive");

    }

    @Test
    @DisplayName("UC10-신고 반려")
    public void rejectReport() {
        String judgement = "";
        String reportContext = reportBoundary.inputReport();
        reportController.addReport(a1.getId(),a2.getId(),reportContext);
        Report r = new Report(a1.getId(),a2.getId(),reportContext);
        r.setId(1);
        reportBoundary.showReport(r);

        judgement = reportBoundary.makeJudgement();
        reportController.removeReport(1);

    }

}