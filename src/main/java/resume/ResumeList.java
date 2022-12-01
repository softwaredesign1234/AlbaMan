package resume;

import java.io.*;
import java.sql.*;
import java.util.*;
import resume.Resume;

public class ResumeList {

    static ArrayList<Resume> resumeList=new ArrayList<>();


    //이력서 생성 및 저장
    public static void saveResume(String individualName,String selfIntroduction,String workExperience,Boolean isopen) throws Exception {
        int id=getResumeList().size()+1;
        Resume resume=new Resume(id);
        resume.addResume(individualName,selfIntroduction,workExperience,isopen);
        resumeList.add(resume);
        System.out.println("Succefully saved!");

    }


    //이력서 조회
    //기업만 조회할 수 있게 유효성 검사 한번 하기?
    public static Resume readResume(String name)
    {
        ArrayList<Resume> arr=getResumeList();
        Resume resultResume=arr.stream()
                .filter(resume -> name.equals(resume.getIndividualName()))
                .findAny()
                .orElse(null);

        return resultResume;
    }

    public static ArrayList<Resume> getResumeList()
    {
        return resumeList;
    }

    public static void main(String[] args) throws Exception{
        String name="yunju";
        String self="hello:)";
        String work="5-7 years";
        Boolean open=true;
        saveResume(name,self,work,open);

        System.out.println(resumeList.get(0).getId());
        System.out.println(resumeList.get(0).getIndividualName());
        System.out.println(resumeList.get(0).getSelfIntroduction());
        System.out.println(resumeList.get(0).getWorkExperience());
        System.out.println(resumeList.get(0).getOpened());

        Resume resume=readResume("yunju");
        System.out.println("찾는 이력서는 : "+resume.getSelfIntroduction());

    }



}
