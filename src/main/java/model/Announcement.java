package model;

import java.util.Date;

public class Announcement {

    private int id;
    private String memberId;
    private int wagePerHour;
    private int workingHour;
    private Date Deadline; //or expiration

    public Announcement(int id, String memberId, int wagePerHour, int workingHour, Date deadline) {
        this.id = id;
        this.memberId = memberId;
        this.wagePerHour = wagePerHour;
        this.workingHour = workingHour;
        Deadline = deadline;
    }

    public Announcement(int id)
    {
        this.id = id;
    }


    public String getMemberId() { return memberId;  }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getWagePerHour() {
        return wagePerHour;
    }

    public void setWagePerHour(int wagePerHour) {
        this.wagePerHour = wagePerHour;
    }

    public int getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }

    public Date getDeadline() { return Deadline; }

    public void setDeadline(Date deadline) {
        Deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
