package boundary;

import model.*;

import javax.sql.DataSource;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static controller.ApplyController.applyList;

public class DBBoundary {

    ArrayList<Apply> applyList = new ArrayList<>();
    ArrayList<Report> reportList = new ArrayList<>();
    ArrayList<Question> questionList = new ArrayList<>();


    public void saveApplyDB(Apply apply)
    {
        List<String> applyInfo = new ArrayList<>();
        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\ApplyDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f));
            applyInfo.add(apply.getId()+" ");
            applyInfo.add(apply.getIndividualId()+" ");
            applyInfo.add(apply.getEnterpriseId()+" ");
            applyInfo.add(apply.getAnnouncementId()+" ");
            applyInfo.add(apply.getResumeId()+" ");

            for (String info : applyInfo){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        }catch (Exception e){

        }

        return;
    }

    public void saveReportDB(Report report)
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

    public void saveQuestionDB(Question question)
    {
        List<String> questionInfo = new ArrayList<>();
        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\QuestionDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f));
            questionInfo.add(question.getId()+" ");
            questionInfo.add(question.getQuestion()+" ");
            questionInfo.add(question.getAnswer()+" ");

            for (String info : questionInfo){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        }catch (Exception e){

        }

        return;
    }

    public ArrayList<Question> readQuestionDB() {

        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\QuestionDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
                Question question = new Question();
                String[] info = line.split(" ");
                question.setId(Integer.parseInt(info[0]));
                question.setQuestion(info[1]);
                question.setAnswer(info[2]);

                questionList.add(question);
            }
            bufferedReader.close();

        }catch (Exception e){

        }
        return questionList;
    }

    public ArrayList<Apply> readApplyDB() {

        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\ReportDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
                Apply apply = new Apply();
                String[] info = line.split(" ");
                apply.setId(Integer.parseInt(info[0]));
                apply.setIndividualId(info[1]);
                apply.setEnterpriseId(info[2]);
                apply.setAnnouncementId(Integer.parseInt(info[3]));
                applyList.add(apply);
            }
            bufferedReader.close();

        }catch (Exception e){

        }
        return applyList;
    }

    public ArrayList<Report> readReportDB() {

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

}
