package resume;

import java.io.*;
import java.sql.*;
import java.util.*;

import account.IndividualAccount;
import announcement.Announcement;
import resume.Resume;

public class ResumeList {

    static ArrayList<Resume> resumeList=new ArrayList<>();
    static ArrayList<IndividualAccount> individualAccounts=new ArrayList<>(); //개인회원 db


    //이력서 생성 및 저장
    //개인계정의 ID를 받아서 해당하는 계정의 이력서 리스트에 저장 + 전체 이력서 리스트에 저장
    public static void saveResume(String individualId, String selfIntroduction, String workExperience, Boolean isopen) throws Exception {
        int id=getResumeList().size()+1;

        //개인 계정에 본인 이력서 추가 -> 개인이 작성한 여러 이력서 조회 가능
        Resume resume=new Resume(id,selfIntroduction,workExperience,isopen);
        IndividualAccount individual=getIndividual(individualId);//Id 받아서
        individual.addResume(resume);//해당 id와 일치하는 개인계정에 이력서 저장

        //조회용 이력서 전체 리스트에 추가 -> 나중에 id 하나하나로 조회 가능
        Resume resumeForList=new Resume(id,selfIntroduction,workExperience,isopen,individual);
        resumeList.add(resumeForList);

        System.out.println("Succefully saved!");

    }

    public static IndividualAccount getIndividual(String individualId)
    {
        ArrayList<IndividualAccount> arr=getIndividualAccounts();

        IndividualAccount result=arr.stream()
                .filter(individualAccount -> individualId.equals(individualAccount.getId()))
                .findAny()
                .orElse(null);

        return result;
    }


    //이력서 조회
    //이력서를 어떤식으로 조회할건지? ->이력서 id로 하나하나 조회하기
    public static Resume readResume(int id)
    {
        ArrayList<Resume> arr=getResumeList();
        Resume resultResume=arr.stream()
                .filter(resume -> id== resume.getId())
                .findAny()
                .orElse(null);

        return resultResume;
    }


    public static ArrayList<Resume> getResumeList()
    {
        return resumeList;
    }
    public static ArrayList<IndividualAccount> getIndividualAccounts()
    {
        return individualAccounts;
    }


    public static void main(String[] args) throws Exception{
        String name="yunju";
        String self="hello:)";
        String work="5-7 years";
        Boolean open=true;
        saveResume(name,self,work,open);

        System.out.println(resumeList.get(0).getId());
        System.out.println(resumeList.get(0).getSelfIntroduction());
        System.out.println(resumeList.get(0).getWorkExperience());
        System.out.println(resumeList.get(0).getOpened());


    }



}
