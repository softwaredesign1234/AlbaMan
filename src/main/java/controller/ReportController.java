package controller;

import boundary.DBBoundary;
import model.IndividualAccount;
import model.Report;

import java.util.ArrayList;

public class ReportController extends DBBoundary{

    static DBBoundary dbManager;
    ArrayList<Report> reportList = new ArrayList<>();


    //List<Report>
    public Report findReport(String reportedMemberId){
        System.out.println("ReportController - findReport() visited");

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
        System.out.println("ReportController - deactivateMember() visited");

        System.out.println(reportedMemberId+" member has been blocked");
        return false;
    }
    public IndividualAccount findMemberInfo(IndividualAccount individual){
        System.out.println("ReportController - findMemberInfo() visited");

        System.out.println("Reported Member's Info = ");
        System.out.println(individual.getId()+individual.getAge()+individual.getEmail()+individual.getPhoneNumber());
        return individual;
    }

    public void addReport(String memberId, String reportedMemberId,String reportContext){
        System.out.println("ReportController - addReport() visited");
        Report report = new Report(memberId,reportedMemberId,reportContext);
        saveReportDB(report);
        return;
    }
    public void removeReport(int reportId){
        System.out.println("ReportController - removeReport() visited");

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
        System.out.println("Remove report id : "+reportId);
        return;
    }




}