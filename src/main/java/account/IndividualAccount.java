package account;

import account.Account;
import announcement.Announcement;
import resume.Resume;
import workhistory.Workhistory;

import java.util.*;
import java.io.*;

public class IndividualAccount extends Account implements Serializable {
    private String email;

    private String phoneNumber;
    private int age;
    private String gender;

    private ArrayList<Workhistory> workhistoryList=new ArrayList<>();
    private ArrayList<Announcement> scrapList=new ArrayList<>();
    private ArrayList<Resume> resuemList=new ArrayList<>();


    public IndividualAccount(String email, String phoneNumber, int age, String gender, String id, String password,
                             String name, Boolean valid, Boolean isActive, String type) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.password = password;
        this.name = name;
        this.valid = valid;
        this.isActivated = isActive;
        this.type = type;

    }

    public IndividualAccount(String id,String password,String name,Boolean valid,Boolean isActive,String type)
    {
        this.id=id;
        this.password=password;
        this.name=name;
        this.valid=valid;
        this.isActivated=isActive;
        this.type=type;
    }

    public void onlyIndividualAccount(String email, String phoneNumber, int age, String gender)
    {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.gender = gender;
    }


    public void addResume(Resume resume)
    {
        this.resuemList.add(resume);
    }

    public void addWorkHistory(Workhistory workhistory)
    {
        this.workhistoryList.add(workhistory);
    }

    public void scrapAnnouncement(Announcement announcement)
    {
        this.scrapList.add(announcement);
    }

    public void addWorkhistory(Workhistory workhistory)
    {
        this.workhistoryList.add(workhistory);
    }



    // getter,setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
