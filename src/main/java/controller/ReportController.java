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
            if (r.getReportedMemberId() == reportedMemberId)
                report = r;
        }
        return report;
    }
    public void deactivateMember(String reportedMemberId){

        return;
    }
    public IndividualAccount findMemberInfo(String reportedMemberId){

        return null;
    }
    public void makeValidation(String reportedMemberId, String validOrNot){

        return;
    }
    public void addReport(String memberId, String reportedMemberId){
        Report report = new Report(memberId,reportedMemberId);
        saveReportDB(report);
        return;
    }
    public void removeReport(int reportId){
        return;
    }


    public static void main(String args[]){
        ReportController reportController = new ReportController();
        reportController.addReport("1","2");
        System.out.println(reportController.findReport("2"));

    }

}