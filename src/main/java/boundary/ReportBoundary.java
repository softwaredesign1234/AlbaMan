package boundary;

import model.Report;

import java.util.Scanner;

public class ReportBoundary {
    //신고사유 존재시 + Report 모델 수정필요
    Scanner sc = new Scanner(System.in);
    public String inputReport(){
        System.out.println("ReportBoundary - inputReport() visited");

        //        return sc.next();
        String context = "SpamContents";
        System.out.println("User Input Report Context = "+context);
        return context;
    }

    public String makeJudgement(){
        System.out.println("ReportBoundary - makeJudgement() visited");

        String judgement = "true";
        System.out.println("Judgement = "+judgement);
        return judgement;
    }

    public void showReport(Report r){
        System.out.println("ReportBoundary - showReport() visited");

        System.out.println("reportID : "+r.getId()+"" +
                " reportMemberID : "+r.getMemberId()+" reportedMemberID : " + r.getReportedMemberId()+
                " ReportContext : "+r.getReportContext());
        return;
    }
}