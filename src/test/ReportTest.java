import boundary.DBBoundary;
import controller.ReportController;
import model.IndividualAccount;
import model.Report;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class ReportTest {
    Scanner scanner = new Scanner(System.in);
    ReportController reportController = new ReportController();

    @Test
    public void addReport() {
        String memberId = "mo";
        String reportedMemberId = "ji";
        String wow;
        reportController.addReport(memberId,reportedMemberId);
        System.out.println(reportController.findReport(reportedMemberId));


    }

}
