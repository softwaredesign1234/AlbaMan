package boundary;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DBBoundary {

    static ArrayList<Apply> applyList = new ArrayList<>();
    public static ArrayList<FAQ> faqList = new ArrayList<>();
    public static ArrayList<Review> reviewList = new ArrayList<>();
    public static ArrayList<EnterpriseAccount> enterpriseAccountsList = new ArrayList<>();
    public static ArrayList<Resume> resumeArrayList = new ArrayList<>();
    public static ArrayList<IndividualAccount> individualAccountsList = new ArrayList<>();
    public static ArrayList<Workhistory> workhistoryList = new ArrayList<>();

    ArrayList<Report> reportList = new ArrayList<>();
    ArrayList<Question> questionList = new ArrayList<>();
    ArrayList<Announcement> announcementList = new ArrayList<>();
    //----------------------Account--------------------------//
    public static void saveIndiDB(IndividualAccount individualAccount) {
        System.out.println("DBBoundary - saveIndiDB() visited");
        ArrayList<String> accountInfo = new ArrayList<>();
        try {
            File f = new File("src/main/java/Database/IndividualAccountDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true));
            accountInfo.add(individualAccount.getId() + " ");
            accountInfo.add(individualAccount.getPassword() + " ");
            accountInfo.add(individualAccount.getEmail() + " ");
            accountInfo.add(individualAccount.getPhoneNumber() + " ");
            accountInfo.add(individualAccount.getAge() + " ");
            accountInfo.add(individualAccount.getGender() + " ");
            accountInfo.add(individualAccount.getName() + " ");
            accountInfo.add(individualAccount.getValid() + " ");
            accountInfo.add(individualAccount.getIsActive() + " ");
            accountInfo.add(individualAccount.getType() + "\n");

            for (String info : accountInfo) {
                bufferedWriter.write(info, 0, info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();


        } catch (Exception e) {

        }
    }

    public static void saveIndiDB(ArrayList<IndividualAccount> individualAccounts){
        System.out.println("DBBoundary - saveIndiDB() visited");
        clearDB("IndividualAccount");


        for (IndividualAccount iAccount : individualAccounts) {
            saveIndiDB(iAccount);
        }
    }

    public static void saveEnterDB(EnterpriseAccount enterpriseAccount) {
        System.out.println("DBBoundary - saveEnterDB() visited");
        ArrayList<String> accountInfo = new ArrayList<>();
        try {
            File f = new File("src/main/java/Database/EnterpriseAccountDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true));
            accountInfo.add(enterpriseAccount.getId() + " ");
            accountInfo.add(enterpriseAccount.getPassword() + " ");
            accountInfo.add(enterpriseAccount.getEnterpriseNum() + " ");
            accountInfo.add(enterpriseAccount.getEnterprisePhoneNumber() + " ");
            accountInfo.add(enterpriseAccount.getEnterpriseLocation() + " ");
            accountInfo.add(enterpriseAccount.getName() + " ");
            accountInfo.add(enterpriseAccount.getValid() + " ");
            accountInfo.add(enterpriseAccount.getIsActive() + " ");
            accountInfo.add(enterpriseAccount.getType() + "\n");

            for (String info : accountInfo) {
                bufferedWriter.write(info, 0, info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();


        } catch (Exception e) {

        }


    }

    public static void saveEnterDB(ArrayList<EnterpriseAccount> enterpriseAccounts){
        System.out.println("DBBoundary - saveEnterDB() visited");
        clearDB("EnterpriseAccount");

        for (EnterpriseAccount eAccount : enterpriseAccounts) {
            saveEnterDB(eAccount);
        }
    }
    public static ArrayList<EnterpriseAccount> readEnterDB() {
        System.out.println("DBBoundary - readEnterDB() visited");
        try {
            File f = new File("src/main/java/Database/EnterpriseAccountDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
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

        } catch (Exception e) {

        }
        return enterpriseAccountsList;
    }

    public static ArrayList<IndividualAccount> readIndiDB() {
        System.out.println("DBBoundary - readIndiDB() visited");
        individualAccountsList.clear();
        try {
            File f = new File("src/main/java/Database/IndividualAccountDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
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

        } catch (Exception e) {

        }
        return individualAccountsList;
    }

    //---------------------Resume----------------------------//
    public static void saveResumeDB(Resume resume) {
        System.out.println("DBBoundary - saveResumeDB() visited");
        ArrayList<String> resumeInfo = new ArrayList<>();
        try {
            File f = new File("src/main/java/Database/ResumeDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true));
            resumeInfo.add(resume.getId() + " ");
            resumeInfo.add(resume.getSelfIntroduction() + " ");
            resumeInfo.add(resume.getWorkExperience() + " ");
            resumeInfo.add(resume.getOpened() + " ");
            resumeInfo.add(resume.getIndividualAccount() + "\n");//db에는 객체를 통쨰로 저장하는게 아니라 id만 저장하자
            //나중에 resume 관련 조회할 때는 id로 객체 찾아서 return


            for (String info : resumeInfo) {
                bufferedWriter.write(info, 0, info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

            System.out.println("Resume Succefully saved!");

        } catch (Exception e) {

        }

    }

    public static ArrayList<Resume> readResumeDB() {

        System.out.println("DBBoundary - readResumeDB() visited");
        try {
            File f = new File("src/main/java/Database/ResumeDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                Resume resume = new Resume();
                String[] info = line.split(" ");
                resume.setId(Integer.parseInt(info[0]));
                resume.setSelfIntroduction(info[1]);
                resume.setWorkExperience(info[2]);
                resume.setOpened(Boolean.parseBoolean(info[3]));
                resume.setIndividualAccount(info[4]);

                resumeArrayList.add(resume);
            }
            bufferedReader.close();

        } catch (Exception e) {

        }
        return resumeArrayList;
    }


    //---------------------Announcement------------------------//


    //--------------------------Apply---------------------------------------//
    public static void saveApplyDB(Apply apply) {
        System.out.println("DBBoundary - saveApplyDB() visited");
        List<String> applyInfo = new ArrayList<>();
        try {
            File f = new File("src/main/java/Database/ApplyDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true));
            applyInfo.add(apply.getId() + " ");
            applyInfo.add(apply.getIndividualId() + " ");
            applyInfo.add(apply.getEnterpriseId() + " ");
            applyInfo.add(apply.getAnnouncementId() + " ");
            applyInfo.add(apply.getPassOrFail() + "\n");

            for (String info : applyInfo) {
                bufferedWriter.write(info, 0, info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            System.out.println("apply saved!");
        } catch (Exception e) {

        }

        return;
    }


    public static ArrayList<Apply> readApplyDB() {
        System.out.println("DBBoundary - readApplyDB() visited");
        try {
            File f = new File("src/main/java/Database/ApplyDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                Apply apply = new Apply();
                String[] info = line.split(" ");
                apply.setId(Integer.parseInt(info[0]));
                apply.setIndividualId(info[1]);
                apply.setEnterpriseId(info[2]);
                apply.setAnnouncementId(Integer.parseInt(info[3]));
                apply.setPassOrFail(Boolean.parseBoolean(info[4]));
                applyList.add(apply);
            }
            bufferedReader.close();

        } catch (Exception e) {

        }
        return applyList;
    }




    //---------------------workHistory----------------------------//
    public static void saveWorkHistoryDB(Workhistory workhistory) {
        System.out.println("DBBoundary - saveWorkHistoryDB() visited");
        ArrayList<String> workhistoryinfo = new ArrayList<>();
        try {
            File f = new File("src/main/java/Database/WorkHistoryDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true));
            workhistoryinfo.add(workhistory.getIndividualId() + " ");
            workhistoryinfo.add(workhistory.getEnterpriseId() + "\n");


            for (String info : workhistoryinfo) {
                bufferedWriter.write(info, 0, info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e) {

        }

        return;
    }

    public static ArrayList<Workhistory> readWorkHistoryDB() {
        System.out.println("DBBoundary - readWorkHistoryDB() visited");
        try {
            File f = new File("src/main/java/Database/WorkHistoryDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                Workhistory workhistory = new Workhistory();
                String[] info = line.split(" ");
                workhistory.setIndividualId(info[0]);
                workhistory.setEnterpriseId(info[1]);

                workhistoryList.add(workhistory);
            }
            bufferedReader.close();

        } catch (Exception e) {

        }
        return workhistoryList;
    }


    public static void saveReviewDB(Review review) {
        System.out.println("DBBoundary - saveReviewDB() visited");
        List<String> reviewInfo = new ArrayList<>();

        try {
            File f = new File("src/main/java/Database/ReviewDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true)); // true 추가해야 이어쓰기 가능
            reviewInfo.add(review.getEnterpriseId() + " ");
            reviewInfo.add(review.getIndividualId() + " ");
            reviewInfo.add(review.getReview() + "\n");

            for (String info : reviewInfo) {
                bufferedWriter.write(info, 0, info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e) {
        }
    }

    public static ArrayList<Review> readReviewDB() {
        System.out.println("DBBoundary - readReviewDB() visited");
        try {
            File f = new File("src/main/java/Database/ReviewDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                Review review = new Review();
                String[] info = line.split(" ");
                review.setEnterpriseId(info[0]);
                review.setIndividualId(info[1]);
                review.setReview(info[2]);

                reviewList.add(review);
            }
            bufferedReader.close();

        } catch (Exception e) {

        }

        return reviewList;
    }

    public static void saveFAQDB(FAQ faq) {
        System.out.println("DBBoundary - saveFAQDB() visited");
        List<String> FAQInfo = new ArrayList<>();
        try {
            File f = new File("src/main/java/Database/FAQDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true));
            FAQInfo.add(faq.getQuestion() + " ");
            FAQInfo.add(faq.getAnswer() + "\n");

            for (String info : FAQInfo) {
                bufferedWriter.write(info, 0, info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e) {

        }
    }

    public static ArrayList<FAQ> readFAQDB() {
        System.out.println("DBBoundary - readFAQDB() visited");
        try {
            File f = new File("src/main/java/Database/FAQDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                FAQ faq = new FAQ();
                String[] info = line.split(" ");
                faq.setQuestion(info[0]);
                faq.setAnswer(info[1]);

                faqList.add(faq);
            }
            bufferedReader.close();

        } catch (Exception e) {

        }
        return faqList;
    }



    public static void clearDB(String dbname){
        System.out.println("DBBoundary - clearDB() visited");
        String db = "src/main/java/Database/"+dbname+"DB.txt";
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


    public void saveAnnouncementDB(Announcement announcement)
    {
        System.out.println("DBBoundary - saveAnnouncementDB() visited");
        List<String> AnnouncementInfo = new ArrayList<>();
        try {
            File f = new File("src/main/java/Database/AnnouncementDB.txt");
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
            System.out.println("Announcement saved!");

        }catch (Exception e){

        }

        return;
    }

    public void saveReportDB(Report report)
    {
        System.out.println("DBBoundary - saveReportDB() visited");
        List<String> reportInfo = new ArrayList<>();
        try {
            File f = new File("src/main/java/Database/ReportDB.txt");
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
        System.out.println("DBBoundary - saveQuestionDB() visited");
        List<String> questionInfo = new ArrayList<>();
        try {
            File f = new File("src/main/java/Database/QuestionDB.txt");
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
        System.out.println("DBBoundary - saveScrapDB() visited");
        List<String> scrapList = new ArrayList<>();
        try {
            File f = new File("src/main/java/Database/ScrapDB.txt");
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

    public ArrayList<Question> readQuestionDB() {
        System.out.println("DBBoundary - readQuestionDB() visited");
        questionList.clear();
        try {
            File f = new File("src/main/java/Database/QuestionDB.txt");
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

    public ArrayList<Report> readReportDB() {
        System.out.println("DBBoundary - readReportDB() visited");
        reportList.clear();
        try {
            File f = new File("src/main/java/Database/ReportDB.txt");
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
        System.out.println("DBBoundary - readAnnouncementDB() visited");
        announcementList.clear();
        try {
            File f = new File("src/main/java/Database/AnnouncementDB.txt");
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


    private int countLine(BufferedReader bufferedReader){
        System.out.println("DBBoundary - countLine() visited");
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
