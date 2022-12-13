package boundary;

import model.*;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DBBoundary {

    ArrayList<Apply> applyList = new ArrayList<>();
    ArrayList<Report> reportList = new ArrayList<>();
    ArrayList<Question> questionList = new ArrayList<>();
    public static ArrayList<FAQ> faqList = new ArrayList<>();
    public static ArrayList<Review> reviewList = new ArrayList<>();
    public static ArrayList<EnterpriseAccount> enterpriseAccountsList = new ArrayList<>();

    public static ArrayList<IndividualAccount> individualAccountsList=new ArrayList<>();
    public static ArrayList<Workhistory> workhistoryList=new ArrayList<>();

    //----------------------Account--------------------------//
    public static void saveIndiDB(IndividualAccount individualAccount)
    {
        ArrayList<String> accountInfo=new ArrayList<>();
        try{
        File f=new File("/Users/kimseojin/IdeaProjects/AlbaMan/src/main/java/Database/IndividualAccountDB.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f,true));
        accountInfo.add(individualAccount.getId()+" ");
        accountInfo.add(individualAccount.getPassword()+" ");
        accountInfo.add(individualAccount.getEmail()+" ");
        accountInfo.add(individualAccount.getPhoneNumber()+" ");
        accountInfo.add(individualAccount.getAge()+" ");
        accountInfo.add(individualAccount.getGender()+" ");
        accountInfo.add(individualAccount.getName()+" ");
        accountInfo.add(individualAccount.getValid()+" ");
        accountInfo.add(individualAccount.getIsActive()+" ");
        accountInfo.add(individualAccount.getType()+"\n");

        for (String info : accountInfo){
            bufferedWriter.write(info,0,info.length());
        }
        bufferedWriter.flush();
        bufferedWriter.close();

        // System.out.println("개인계정 저장 성공");

    }catch (Exception e){

    }

    }

    public static void saveIndiDB(ArrayList<IndividualAccount> individualAccounts){

        clearDB("IndividualAccount");


        for (IndividualAccount iAccount : individualAccounts) {
            saveIndiDB(iAccount);
        }
    }

    public static void saveEnterDB(EnterpriseAccount enterpriseAccount)
    {
        ArrayList<String> accountInfo=new ArrayList<>();
        try{
            File f=new File("/Users/kimseojin/IdeaProjects/AlbaMan/src/main/java/Database/EnterpriseAccountDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f,true));
            accountInfo.add(enterpriseAccount.getId()+" ");
            accountInfo.add(enterpriseAccount.getPassword()+" ");
            accountInfo.add(enterpriseAccount.getEnterpriseNum()+" ");
            accountInfo.add(enterpriseAccount.getEnterprisePhoneNumber()+" ");
            accountInfo.add(enterpriseAccount.getEnterpriseLocation()+" ");
            accountInfo.add(enterpriseAccount.getName()+" ");
            accountInfo.add(enterpriseAccount.getValid()+" ");
            accountInfo.add(enterpriseAccount.getIsActive()+" ");
            accountInfo.add(enterpriseAccount.getType()+"\n");

            for (String info : accountInfo){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

            System.out.println("기업계정 저장 성공");

        }catch (Exception e){

        }


    }

    public static void saveEnterDB(ArrayList<EnterpriseAccount> enterpriseAccounts){

        clearDB("EnterpriseAccount");

        for (EnterpriseAccount eAccount : enterpriseAccounts) {
            saveEnterDB(eAccount);
        }
    }

    public static ArrayList<EnterpriseAccount> readEnterDB() {

        enterpriseAccountsList.clear();

        try {
            File f = new File("/Users/kimseojin/IdeaProjects/AlbaMan/src/main/java/Database/EnterpriseAccountDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
                EnterpriseAccount enterpriseAccount = new EnterpriseAccount();
                String[] info = line.split(" ");
                enterpriseAccount.setId(info[0]);
                enterpriseAccount.setPassword(info[1]);
                enterpriseAccount.setEnterpriseNum(info[2]);
                enterpriseAccount.setEnterprisePhoneNumber(info[3]);
                enterpriseAccount.setEnterpriseLocation(info[4]);
                enterpriseAccount.setName(info[5]);
                enterpriseAccount.setIsActive(Boolean.parseBoolean(info[6]));
                enterpriseAccount.setValid(Boolean.parseBoolean(info[7]));
                enterpriseAccount.setType(info[8]);

                enterpriseAccountsList.add(enterpriseAccount);
            }
            bufferedReader.close();

        }catch (Exception e){

        }
        return enterpriseAccountsList;
    }

    public static ArrayList<IndividualAccount> readIndiDB() {

        individualAccountsList.clear();

        try {
            File f = new File("/Users/kimseojin/IdeaProjects/AlbaMan/src/main/java/Database/IndividualAccountDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
                IndividualAccount individualAccount = new IndividualAccount();
                String[] info = line.split(" ");
                individualAccount.setId(info[0]);
                individualAccount.setPassword(info[1]);
                individualAccount.setEmail(info[2]);
                individualAccount.setPhoneNumber(info[3]);
                individualAccount.setAge(Integer.parseInt(info[4]));
                individualAccount.setGender(info[5]);
                individualAccount.setName(info[6]);
                individualAccount.setIsActive(Boolean.parseBoolean(info[7]));
                individualAccount.setValid(Boolean.parseBoolean(info[8]));
                individualAccount.setType(info[9]);
                individualAccountsList.add(individualAccount);
            }
            bufferedReader.close();

        }catch (Exception e){

        }
        return individualAccountsList;
    }

    //---------------------Resume----------------------------//
    public static void saveResumeDB(Resume resume)
    {
        ArrayList<String> resumeInfo=new ArrayList<>();
        try{
            File f=new File("C:\\Users\\홍길동\\IdeaProjects\\Alba_Man\\src\\main\\java\\Database\\Resume.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f,true));
            resumeInfo.add(resume.getId()+" ");
            resumeInfo.add(resume.getSelfIntroduction()+" ");
            resumeInfo.add(resume.getWorkExperience()+" ");
            resumeInfo.add(resume.getOpened()+" ");
            resumeInfo.add(resume.getIndividualAccount().getId()+"\n");//db에는 객체를 통쨰로 저장하는게 아니라 id만 저장하자
            //나중에 resume 관련 조회할 때는 id로 객체 찾아서 return


            for (String info : resumeInfo){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

            System.out.println("이력서 저장 성공");

        }catch (Exception e){

        }

    }



    //---------------------Announcement------------------------//

    public void saveAnnouncementDB(Announcement announcement)
    {
        ArrayList<String> announcementInfo=new ArrayList<>();
        try{
            File f=new File("C:\\Users\\홍길동\\IdeaProjects\\Alba_Man\\src\\main\\java\\Database\\Announcement.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f));
            announcementInfo.add(announcement.getId()+" ");
            announcementInfo.add(announcement.getEnterpriseId()+" ");//db에는 객체를 통쨰로 저장하는게 아니라 id만 저장하자
            announcementInfo.add(announcement.getWagePerHour()+" ");
            announcementInfo.add(announcement.getWorkingDaysPerWeek()+" ");
            announcementInfo.add(announcement.getWorkingHourPerWeek()+" ");
            announcementInfo.add(announcement.getDeadline()+" ");

            //나중에 resume 관련 조회할 때는 id로 객체 찾아서 return


            for (String info : announcementInfo){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

            System.out.println("공고 저장 성공");

        }catch (Exception e){

        }

    }

    public void saveScrapAnnouncementDB(Announcement announcement,String individualId)
    {
        ArrayList<String> announcementInfo=new ArrayList<>();
        try{
            File f=new File("C:\\Users\\홍길동\\IdeaProjects\\Alba_Man\\src\\main\\java\\Database\\Announcement.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f));
            announcementInfo.add(announcement.getId()+" ");
            announcementInfo.add(announcement.getEnterpriseId()+" ");//db에는 객체를 통쨰로 저장하는게 아니라 id만 저장하자
            announcementInfo.add(announcement.getWagePerHour()+" ");
            announcementInfo.add(announcement.getWorkingDaysPerWeek()+" ");
            announcementInfo.add(announcement.getWorkingHourPerWeek()+" ");
            announcementInfo.add(announcement.getDeadline()+" ");
            announcementInfo.add(individualId+" "); //어떤 사람이 스크랩한 공고인지

            //나중에 resume 관련 조회할 때는 id로 객체 찾아서 return


            for (String info : announcementInfo){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

            System.out.println("공고 스크랩 성공");

        }catch (Exception e){

        }

    }




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

    //----------------------------------------------------------------

    public static void saveReviewDB(Review review)
    {
        List<String> reviewInfo = new ArrayList<>();

        try {
            File f = new File("/Users/kimseojin/IdeaProjects/AlbaMan/src/main/java/Database/ReviewDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true)); // true 추가해야 이어쓰기 가능
            reviewInfo.add(review.getEnterpriseId()+" ");
            reviewInfo.add(review.getIndividualId()+" ");
            reviewInfo.add(review.getReview()+"\n");

            for (String info : reviewInfo){
                bufferedWriter.write(info, 0, info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e){
        }
    }

    public static ArrayList<Review> readReviewDB() {

        try {
            File f = new File("/Users/kimseojin/IdeaProjects/AlbaMan/src/main/java/Database/ReviewDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
                Review review = new Review();
                String[] info = line.split(" ");
                review.setEnterpriseId(info[0]);
                review.setIndividualId(info[1]);
                review.setReview(info[2]);

                reviewList.add(review);
            }
            bufferedReader.close();

        } catch (Exception e){

        }

        return reviewList;
    }

    public static void saveFAQDB(FAQ faq) {
        List<String> FAQInfo = new ArrayList<>();
        try {
            File f = new File("/Users/kimseojin/IdeaProjects/AlbaMan/src/main/java/Database/FAQDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true));
            FAQInfo.add(faq.getQuestion()+" ");
            FAQInfo.add(faq.getAnswer()+"\n");

            for (String info : FAQInfo){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        }catch (Exception e){

        }
    }

    public static ArrayList<FAQ> readFAQDB() {
        try {
            File f = new File("/Users/kimseojin/IdeaProjects/AlbaMan/src/main/java/Database/FAQDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
                FAQ faq = new FAQ();
                String[] info = line.split(" ");
                faq.setQuestion(info[0]);
                faq.setAnswer(info[1]);

                faqList.add(faq);
            }
            bufferedReader.close();

        }catch (Exception e){

        }
        return faqList;
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

//    public ArrayList<Question> readQuestionDB() {
//
//        try {
//            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\QuestionDB.txt");
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
//            String line = null;
//            while((line = bufferedReader.readLine())!=null)
//            {
//                Question question = new Question();
//                String[] info = line.split(" ");
//                question.setId(Integer.parseInt(info[0]));
//                question.setQuestion(info[1]);
//                question.setAnswer(info[2]);
//
//                questionList.add(question);
//            }
//            bufferedReader.close();
//
//        }catch (Exception e){
//
//        }
//        return questionList;
//    }
//
//    public ArrayList<Apply> readApplyDB() {
//
//        try {
//            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\ReportDB.txt");
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
//            String line = null;
//            while((line = bufferedReader.readLine())!=null)
//            {
//                Apply apply = new Apply();
//                String[] info = line.split(" ");
//                apply.setId(Integer.parseInt(info[0]));
//                apply.setIndividualId(info[1]);
//                apply.setEnterpriseId(info[2]);
//                apply.setAnnouncementId(Integer.parseInt(info[3]));
//                applyList.add(apply);
//            }
//            bufferedReader.close();
//
//        }catch (Exception e){
//
//        }
//        return applyList;
//    }

//    public ArrayList<Report> readReportDB() {
//
//        try {
//            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\ReportDB.txt");
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
//            String line = null;
//            while((line = bufferedReader.readLine())!=null)
//            {
//                Report report = new Report();
//                String[] info = line.split(" ");
//                report.setId(Integer.parseInt(info[0]));
//                report.setReportedMemberId(info[1]);
//                report.setReportedMemberId(info[2]);
//                report.setReportContext(info[3]);
//                reportList.add(report);
//            }
//            bufferedReader.close();
//
//        }catch (Exception e){
//
//        }
//        return reportList;
//    }

    public static void saveWorkHistoryDB(Workhistory workhistory)
    {
        ArrayList<String> workhistoryinfo = new ArrayList<>();
        try {
            File f = new File("/Users/kimseojin/IdeaProjects/AlbaMan/src/main/java/Database/WorkhistoryDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f,true));
            workhistoryinfo.add(workhistory.getIndividualId()+" ");
            workhistoryinfo.add(workhistory.getEnterpriseId()+"\n");


            for (String info : workhistoryinfo){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        }catch (Exception e){

        }

        return;
    }
    public static ArrayList<Workhistory> readWorkHistoryDB() {

        try {
            File f = new File("/Users/kimseojin/IdeaProjects/AlbaMan/src/main/java/Database/WorkhistoryDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
                Workhistory workhistory = new Workhistory();
                String[] info = line.split(" ");
                workhistory.setIndividualId(info[0]);
                workhistory.setEnterpriseId(info[1]);

                workhistoryList.add(workhistory);
            }
            bufferedReader.close();

        }catch (Exception e){

        }
        return workhistoryList;
    }

    public static void clearDB(String dbname){
        String db = "/Users/kimseojin/IdeaProjects/AlbaMan/src/main/java/Database/"+dbname+"DB.txt";
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
}
