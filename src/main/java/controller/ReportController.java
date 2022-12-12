package controller;

import boundary.DBBoundary;
import model.IndividualAccount;
import model.Report;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ReportController extends DBBoundary{

    static DBBoundary dbManager;
    ArrayList<Report> reportList = new ArrayList<>();


    //List<Report>
    public Report findReport(String reportedMemberId){
        Report report = new Report();
        for (Report r : readReportDB())
        {
            if (r.getReportedMemberId().equals(reportedMemberId)) {
                report = r;
            }
        }
        return report;
    }
    public void deactivateMember(String reportedMemberId){
        ArrayList<IndividualAccount> individualAccountArrayList = new ArrayList<>();
//        individualAccountArrayList = readIndividualAccountDB();
//        for (IndividualAccount i : individualAccountArrayList){
//            if(i.getId().equals(reportedMemberId)){
//                i.setIsActive(false);
//                saveIndividualAccountDB(i);
//            }
//            else{
//                saveIndividualAccountDB(i);
//            }
//        }
        return;
    }
    public IndividualAccount findMemberInfo(String reportedMemberId){
//        IndividualAccount individualAccount = new IndividualAccount();
//        for (IndividualAccount i : readIndividualAccountDB()){
//            if(i.getId().equals(reportedMemberId)) {
//                individualAccount = i;
//            }
//        }
//        return individualAccount;
        return null;
    }

    public void addReport(String memberId, String reportedMemberId,String reportContext){
        Report report = new Report(memberId,reportedMemberId,reportContext);
        saveReportDB(report);
        return;
    }
    public void removeReport(int reportId){
        reportList.clear();
        reportList = readReportDB();
        clearDB("Report");
        for (Report r : reportList){
            if(r.getId() == reportId){
                continue;
            }
            else{
                saveReportDB(r);
            }
        }
        return;
    }


    public static void main(String args[]){
        ReportController reportController = new ReportController();
        DBBoundary dbBoundary = new DBBoundary();
        dbBoundary.clearDB("Report");
        reportController.addReport("1","2","illegal");
        reportController.addReport("2","1","illegaltoo");

        System.out.println(reportController.findReport("2").getReportContext());
    }

}