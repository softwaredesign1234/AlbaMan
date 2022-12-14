package controller;

import boundary.DBBoundary;
import model.IndividualAccount;
import model.Resume;

import java.util.ArrayList;

public class ResumeController extends DBBoundary{

    static ArrayList<Resume> resumeList=new ArrayList<>();
    static ArrayList<IndividualAccount> individualAccounts=new ArrayList<>(); //개인회원 db


    //이력서 생성 및 저장
    //개인계정의 ID를 받아서 해당하는 계정의 이력서 리스트에 저장 + 전체 이력서 리스트에 저장
    public static Resume saveResume(String individualId, String selfIntroduction, String workExperience, Boolean isopen) throws Exception {
        System.out.println("ResumeController - saveResume() visited");
        int id=getResumeList().size()+1;



        Resume resume=new Resume(id,selfIntroduction,workExperience,isopen,individualId);

        saveResumeDB(resume);
        resumeList.add(resume);

        System.out.println("Resume Id: "+resume.getId());
        System.out.println("Resume Owner(Individual) Id: "+resume.getIndividualAccount());
        System.out.println("Resume selfIntroduction: "+resume.getSelfIntroduction());
        System.out.println("Resume workExperience: "+resume.getWorkExperience());
        System.out.println("Resume isOpen: "+resume.getOpened());

        return resume;

    }




    //이력서 조회
    //이력서를 어떤식으로 조회할건지? ->이력서 id로 하나하나 조회하기
    public static Resume showResume(int id)
    {
        System.out.println("ResumeController - showResume() visited");
        ArrayList<Resume> arr=readResumeDB();
        Resume resultResume=arr.stream()
                .filter(resume -> id== resume.getId())
                .findAny()
                .orElse(null);

        if(resultResume==null)
            System.out.println("Can't find the resume");
        else
            System.out.println("Success find resume");
        return resultResume;
    }


    public static ArrayList<Resume> getResumeList()
    {
        System.out.println("ResumeController - getResumeList() visited");
        return resumeList;
    }




}
