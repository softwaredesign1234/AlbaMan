package model;

import java.util.List;

public class IndividualAccount extends Account {
    private String email;
    private String phoneNumber;
    private int age;
    private String gender;
    private List<Announcement> scrapList;
    private List<WorkHistory> workList;

    public IndividualAccount(String id, String email, String phoneNumber, int age, String gender) {
        super(id);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.gender = gender;
    }


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

    public List<Announcement> getScrapList() {
        return scrapList;
    }

    public List<WorkHistory> getWorkedList() { return workList; }


}
