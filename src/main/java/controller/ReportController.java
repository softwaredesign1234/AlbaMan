package controller;

import boundary.DBBoundary;
import model.IndividualAccount;
import model.Report;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ReportController {

    static DBBoundary dbManager;
    ArrayList<Report> reportList = new ArrayList<>();


    //List<Report>
    public Report findReport(String reportedMemberId){
        Report report = new Report();
        for (Report r : readDB(reportedMemberId))
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
        saveDB(report);
        return;
    }
    public void removeReport(int reportId){
        return;
    }
    public void saveDB(Report report)
    {
        List<String> reportInfo = new ArrayList<>();
        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\ReportDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f));
            reportInfo.add(report.getId()+" ");
            reportInfo.add(report.getMemberId()+" ");
            reportInfo.add(report.getReportedMemberId()+" ");
            reportInfo.add(report.getReportContext()+" ");

            for (String info : reportInfo){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        }catch (Exception e){

        }

        return;
    }

    public ArrayList<Report> readDB(String tablename) {

        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\ReportDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
                Report report = new Report();
                String[] info = line.split(" ");
                report.setId(Integer.parseInt(info[0]));
                report.setReportedMemberId(info[1]);
                report.setReportedMemberId(info[2]);
                report.setReportContext(info[3]);
                reportList.add(report);
            }
            bufferedReader.close();

        }catch (Exception e){

        }
        return reportList;
    }

    public static void main(String args[]){
        ReportController reportController = new ReportController();
        reportController.addReport("1","2");
        System.out.println(reportController.findReport("2"));

    }

}