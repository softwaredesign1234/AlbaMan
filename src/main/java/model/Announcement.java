package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Date;

public class Announcement {
    private int id; //공고번호
    private String enterpriseId; //회사의 id
    private int wagePerHour;
    private int workingHourPerWeek;
    private int workingDaysPerWeek;
    private LocalDate deadline;

    public Announcement(int id,String enterpriseId,
                        int wagePerHour,int workingHourPerWeek, int workingDaysPerWeek,LocalDate deadline) {

        this.id=id;
        this.enterpriseId=enterpriseId;
        this.wagePerHour=wagePerHour;
        this.workingDaysPerWeek=workingDaysPerWeek;
        this.workingHourPerWeek=workingHourPerWeek;
        this.deadline=deadline;
    }

    public Announcement(int id)
    {
        this.id=id;
    }






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public int getWagePerHour() {
        return wagePerHour;
    }

    public void setWagePerHour(int wagePerHour) {
        this.wagePerHour = wagePerHour;
    }

    public int getWorkingHourPerWeek() {
        return workingHourPerWeek;
    }

    public void setWorkingHourPerWeek(int workingHourPerWeek) {
        this.workingHourPerWeek = workingHourPerWeek;
    }

    public int getWorkingDaysPerWeek() {
        return workingDaysPerWeek;
    }

    public void setWorkingDaysPerWeek(int workingDaysPerWeek) {
        this.workingDaysPerWeek = workingDaysPerWeek;
    }
    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
}
