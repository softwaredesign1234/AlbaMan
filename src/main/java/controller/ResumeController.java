package controller;

import java.util.*;

import boundary.DBBoundary;
import model.IndividualAccount;
import model.Resume;

public class ResumeController {

    public static ArrayList<Resume> resumeList=new ArrayList<>();
    public static ArrayList<IndividualAccount> individualAccounts=new ArrayList<>(); //개인회원 db
    public static DBBoundary dbManager;


    //이력서 생성 및 저장
    //개인계정의 ID를 받아서 해당하는 계정의 이력서 리스트에 저장 + 전체 이력서 리스트에 저장
    public static void saveResume(String individualId, String selfIntroduction, String workExperience, Boolean isopen) throws Exception {

        return;
    }

    public static IndividualAccount getIndividual(String individualId)
    {
        return null;
    }


    //이력서 조회
    //이력서를 어떤식으로 조회할건지? ->이력서 id로 하나하나 조회하기
    public static Resume readResume(int id)
    {
       return null;
    }


    public static ArrayList<Resume> getResumeList()
    {
        return resumeList;
    }
    public static ArrayList<IndividualAccount> getIndividualAccounts()
    {
        return individualAccounts;
    }
    public void saveDB(Object o)
    {
        //받은 obeject를 string으로 변환해서 text파일에 저장하기
        return;
    }
    public Object readDb(String dbname)
    {
        return null;
    }


    public ArrayList<Object> readDB(String tablename) {
        return null;
    }



}
