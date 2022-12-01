package resume;


import java.io.*;
import java.sql.*;
import java.util.*;

public class Resume {
    private int id;
    private String individualName;
    private String selfIntroduction;
    private String workExperience;
    private Boolean isOpened;

    public Resume(int id,String individualName,String selfIntroduction,
                  String workExperience,Boolean isOpened)
    {
        this.id=id;
        this.individualName=individualName;
        this.selfIntroduction=selfIntroduction;
        this.workExperience=workExperience;
        this.isOpened=isOpened;
    }

    public Resume(int id)
    {
        this.id=id;
    }





    //resume 클래스: resume 입력하고 하나의 resume 생성 (addResume)
    //resumeList 클래스 : resume 클래스를 받아서 리스트에 저장? (saveResume)
    //위에 두개를 Resume 하나에서 다하기

    //이력서 입력 시 유저 이름도 따로 입력할거? ㅇㅇ
    //테스트 코드에서 맨처음 로그인하고 individualName으로 멤버 이름을 먼저 정해놓으면댐
    //참고로 resumeList를 user가 가지고 있음? ㅇㅇ


    // 이력서 작성
    public void addResume(String individualName,String selfIntroduction,String workExperience,Boolean isopen) throws Exception {

        //유효성 검사 : 필요없음. 로그인을 전제로 할거임

        this.selfIntroduction=selfIntroduction;
        this.workExperience=workExperience;
        this.isOpened=isopen;
        this.individualName=individualName;

        System.out.println("Succefully added!");
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getIndividualName() {
        return individualName;
    }

    public void setIndividualName(String individualName) {
        this.individualName = individualName;
    }
    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }
    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public Boolean getOpened() {
        return isOpened;
    }

    public void setOpened(Boolean opened) {
        isOpened = opened;
    }
}
