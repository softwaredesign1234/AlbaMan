package controller;

import boundary.DBBoundary;
import model.Apply;
import model.IndividualAccount;
import model.Question;
import model.Report;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class ApplyController {
    public static ArrayList<Apply> applyList=new ArrayList<>();
    public static DBBoundary dbManager;


    //기업->개인
    public static void makeApplytoIndividual(String individualId,String enterpriseId,int resumeId) throws Exception {
        return;
    }
    //개인->기업
    public void makeApplytoEnterprise(String individualId, String enterpriseId,int announcementId){
        Apply a = new Apply();
        a.setIndividualId(individualId);
        a.setEnterpriseId(enterpriseId);
        a.setAnnouncementId(announcementId);
        saveDB(a);
        return;
    }


    //개인->기업 수락여부, 기업->개인 채용여부 return
    public Apply passOrNot(int applyId)
    {
        return null;
    }

    //오퍼 수락여부 전달
    public void sendResult(Apply applyResult)
    {
        //apply 안의 기업,개인에게 저장된 결과를 전달해줌
        //합격한다면 workhistory에 추가
        return;

    }
    public void addWorkHistory(String individualId, int announcementId){
        return;
    }

    public static ArrayList<Apply> getApplyList() {
        return applyList;
    }

    public void saveDB(Apply apply)
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

    public ArrayList<Apply> readDB(String tablename) {

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

    public void saveDB(Object o)
    {
        return;
    }
    public Object readDb(String dbname)
    {
        return null;
    }

    public static void main(String args[]){

    }
}
