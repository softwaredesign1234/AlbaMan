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
    public boolean deactivateMember(String reportedMemberId){
        System.out.println(reportedMemberId+" member has been blocked");
        return false;
    }
    public IndividualAccount findMemberInfo(IndividualAccount individual){
        System.out.println("Reported Member's Info = ");
        System.out.println(individual.getId()+individual.getAge()+individual.getEmail()+individual.getPhoneNumber());
        return individual;
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