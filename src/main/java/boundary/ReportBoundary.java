package boundary;

import model.Report;

import java.util.ArrayList;
import java.util.Scanner;

public class ReportBoundary {
    //신고사유 존재시 + Report 모델 수정필요
    Scanner sc = new Scanner(System.in);
    public String inputReport(){
        //        return sc.next();
        System.out.println("Input Report Context");
        String context = "SpamContents";
        return context;
    }

    public String makeJudgement(){
        System.out.println("Input your Judgement");
        String judgement = "true";
        return judgement;
    }

    public void showReport(Report r){
        System.out.println("reportID : "+r.getId()+"" +
                "\nreportMemberID : "+r.getMemberId()+" reportedMemberID : " + r.getReportedMemberId()+
                "\nReportContext : "+r.getReportContext());
        return;
    }
}
