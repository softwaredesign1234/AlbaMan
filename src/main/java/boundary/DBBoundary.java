package boundary;

import model.*;

import javax.sql.DataSource;
import java.io.*;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static controller.ApplyController.applyList;

public class DBBoundary {




    public void saveAnnouncementDB(Announcement announcement)
    {
        List<String> AnnouncementInfo = new ArrayList<>();
        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\AnnouncementDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f,true));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));

            int id = countLine(bufferedReader);

            AnnouncementInfo.add(id+" ");
            AnnouncementInfo.add(announcement.getEnterpriseId()+" ");
            AnnouncementInfo.add(announcement.getWagePerHour()+" ");
            AnnouncementInfo.add(announcement.getWorkingHourPerWeek()+" ");
            AnnouncementInfo.add(announcement.getWorkingDaysPerWeek()+" ");
            AnnouncementInfo.add(announcement.getDeadline()+" ");

            for (String info : AnnouncementInfo){
                bufferedWriter.write(info,0,info.length());
            }

            bufferedWriter.write("\n");
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();

        }catch (Exception e){

        }

        return;
    }
    public void saveApplyDB(Apply apply)
    {
        List<String> applyInfo = new ArrayList<>();
        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\ApplyDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));

            int id = countLine(bufferedReader);

            applyInfo.add(id+" ");
            applyInfo.add(apply.getIndividualId()+" ");
            applyInfo.add(apply.getEnterpriseId()+" ");
            applyInfo.add(apply.getAnnouncementId()+" ");
            applyInfo.add(apply.getResumeId()+" ");

            for (String info : applyInfo){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.write("\n");
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();

        }catch (Exception e){

        }

        return;
    }

    public void saveReportDB(Report report)
    {
        List<String> reportInfo = new ArrayList<>();
        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\ReportDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f,true));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));

            int id = countLine(bufferedReader);

            reportInfo.add(id+" ");
            reportInfo.add(report.getMemberId()+" ");
            reportInfo.add(report.getReportedMemberId()+" ");
            reportInfo.add(report.getReportContext()+" ");

            for (String info : reportInfo){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.write("\n");
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();

        }catch (Exception e){

        }

        return;
    }

    public void saveQuestionDB(Question question)
    {
        List<String> questionInfo = new ArrayList<>();
        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\QuestionDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f,true));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));

            int id = countLine(bufferedReader);

            questionInfo.add(id+" ");
            questionInfo.add(question.getIndividualId()+" ");
            questionInfo.add(question.getQuestion()+" ");
            questionInfo.add(question.getAnswer()+" ");

            for (String info : questionInfo){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.write("\n");
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();
        }catch (Exception e){

        }
        return;
    }

    public void saveScrapDB(String individualId, Announcement announcement)
    {
        List<String> scrapList = new ArrayList<>();
        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\ScrapDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f,true));

            scrapList.add(individualId+" ");
            scrapList.add(announcement.getId()+" ");

            for (String info : scrapList){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.write("\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (Exception e){

        }
        return;
    }

    public void saveWorkHistoryDB(Workhistory workhistory)
    {
        List<String> workedInfo = new ArrayList<>();
        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\WorkHistoryDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f,true));


            workedInfo.add(workhistory.getEnterpriseId()+" ");
            workedInfo.add(workhistory.getIndividualId()+" ");

            for (String info : workedInfo){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.write("\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (Exception e){

        }
        return;
    }


    public ArrayList<Question> readQuestionDB() {
        ArrayList<Question> questionList = new ArrayList<>();
        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\QuestionDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
                Question question = new Question();
                String[] info = line.split(" ");
                question.setId(Integer.parseInt(info[0]));
                question.setIndividualId(info[1]);
                question.setQuestion(info[2]);
                question.setAnswer(info[3]);

                questionList.add(question);
            }
            bufferedReader.close();

        }catch (Exception e){

        }
        return questionList;
    }

    public ArrayList<Apply> readApplyDB() {
        ArrayList<Apply> applyList = new ArrayList<>();
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
        ArrayList<Report> reportList = new ArrayList<>();
        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\ReportDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
                Report report = new Report();
                String[] info = line.split(" ");
                report.setId(Integer.parseInt(info[0]));
                report.setMemberId(info[1]);
                report.setReportedMemberId(info[2]);
                report.setReportContext(info[3]);

                reportList.add(report);
            }
            bufferedReader.close();

        }catch (Exception e){

        }
        return reportList;
    }

    public ArrayList<Announcement> readAnnouncementDB() {
        ArrayList<Announcement> announcementList = new ArrayList<>();
        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\AnnouncementDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
                String[] info = line.split(" ");
                Announcement announcement = new Announcement(Integer.parseInt(info[0]));
                announcement.setEnterpriseId(info[1]);
                announcement.setWagePerHour(Integer.parseInt(info[2]));
                announcement.setWorkingHourPerWeek(Integer.parseInt(info[3]));
                announcement.setWorkingDaysPerWeek(Integer.parseInt(info[4]));
                announcement.setDeadline(info[5]);

                announcementList.add(announcement);
            }
            bufferedReader.close();

        }catch (Exception e){

        }
        return announcementList;
    }

    public void clearDB(String dbname){
        String db = "C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\"+dbname+"DB.txt";
        try {
            File f = new File(db);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f));
            bufferedWriter.write("");
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (Exception e){

        }
        return;
    }

    private int countLine(BufferedReader bufferedReader){
        String line = null;
        int num = 0;
//            num = bufferedReader.readLine().length()
        try {
            while ((line = bufferedReader.readLine()) != null)
                num++;
            num++;
        }catch (IOException e){

        }
        return num;
    }


}
