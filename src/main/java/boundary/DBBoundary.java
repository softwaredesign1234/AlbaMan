package boundary;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DBBoundary {

    static ArrayList<Apply> applyList = new ArrayList<>();

    public static ArrayList<EnterpriseAccount> enterpriseAccountsList = new ArrayList<>();
    public static ArrayList<Resume> resumeArrayList = new ArrayList<>();
    public static ArrayList<IndividualAccount> individualAccountsList=new ArrayList<>();
    public static ArrayList<Workhistory> workhistoryList=new ArrayList<>();
    //----------------------Account--------------------------//
    public static void saveIndiDB(IndividualAccount individualAccount)
    {
        ArrayList<String> accountInfo=new ArrayList<>();
        try{
        File f=new File("C:\\Users\\홍길동\\IdeaProjects\\Alba_Man\\src\\main\\java\\Database\\IndividualAccount.txt");
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

        System.out.println("개인계정 저장 성공");

    }catch (Exception e){

    }

    }

    public static void saveEnterDB(EnterpriseAccount enterpriseAccount)
    {
        ArrayList<String> accountInfo=new ArrayList<>();
        try{
            File f=new File("C:\\Users\\홍길동\\IdeaProjects\\Alba_Man\\src\\main\\java\\Database\\EnterpriseAccount.txt");
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

    public static ArrayList<EnterpriseAccount> readEnterDB() {

        try {
            File f = new File("C:\\Users\\홍길동\\IdeaProjects\\Alba_Man\\src\\main\\java\\Database\\EnterpriseAccount.txt");
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

        try {
            File f = new File("C:\\Users\\홍길동\\IdeaProjects\\Alba_Man\\src\\main\\java\\Database\\IndividualAccount.txt");
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
            resumeInfo.add(resume.getIndividualAccount()+"\n");//db에는 객체를 통쨰로 저장하는게 아니라 id만 저장하자
            //나중에 resume 관련 조회할 때는 id로 객체 찾아서 return


            for (String info : resumeInfo){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

            System.out.println("Resume Succefully saved!");

        }catch (Exception e){

        }

    }
    public static ArrayList<Resume> readResumeDB() {

        try {
            File f = new File("C:\\Users\\홍길동\\IdeaProjects\\Alba_Man\\src\\main\\java\\Database\\Resume.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
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

        }catch (Exception e){

        }
        return resumeArrayList;
    }



    //---------------------Announcement------------------------//





    //--------------------------Apply---------------------------------------//
    public static void saveApplyDB(Apply apply)
    {
        List<String> applyInfo = new ArrayList<>();
        try {
            File f = new File("C:\\Users\\홍길동\\IdeaProjects\\Alba_Man\\src\\main\\java\\Database\\Apply.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f,true));
            applyInfo.add(apply.getId()+" ");
            applyInfo.add(apply.getIndividualId()+" ");
            applyInfo.add(apply.getEnterpriseId()+" ");
            applyInfo.add(apply.getAnnouncementId()+" ");
            applyInfo.add(apply.getPassOrFail()+"\n");

            for (String info : applyInfo){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        }catch (Exception e){

        }

        return;
    }



    public static ArrayList<Apply> readApplyDB() {

        try {
            File f = new File("C:\\Users\\홍길동\\IdeaProjects\\Alba_Man\\src\\main\\java\\Database\\Apply.txt");
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
                apply.setPassOrFail(Boolean.parseBoolean(info[4]));
                applyList.add(apply);
            }
            bufferedReader.close();

        }catch (Exception e){

        }
        return applyList;
    }

    public static void deleteApplyDB(int id)
    {
        ArrayList<Apply> arr=readApplyDB();
        Apply apply=arr.stream()
                .filter(apply1 -> id== apply1.getId())
                .findAny()
                .orElse(null);
        arr.remove(apply);
        String path = "C:\\Users\\홍길동\\IdeaProjects\\Alba_Man\\src\\main\\java\\Database\\Apply.txt";

        try (FileOutputStream fos = new FileOutputStream(path, false)) {

        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Apply applys:arr)
        {
            saveApplyDB(applys);
        }
    }


    //---------------------workHistory----------------------------//
    public static void saveWorkHistoryDB(Workhistory workhistory)
    {
        ArrayList<String> workhistoryinfo = new ArrayList<>();
        try {
            File f = new File("C:\\Users\\홍길동\\IdeaProjects\\Alba_Man\\src\\main\\java\\Database\\WorkHistory.txt");
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
    public static ArrayList<Workhistory> readworkHistoryDB() {

        try {
            File f = new File("C:\\Users\\홍길동\\IdeaProjects\\Alba_Man\\src\\main\\java\\Database\\WorkHistory.txt");
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

    public void saveAnnouncementDB(Announcement announcement) {
    }

    public void saveScrapAnnouncementDB(Announcement announcement, String individualId) {
    }
}
