package model;

public class Announcement {
    private int id; //공고번호
    private String enterpriseId; //회사의 id
    private int wagePerHour;
    private int workingHourPerWeek;
    private int workingDaysPerWeek;



    private String deadline;

    public Announcement(int id,String enterpriseId,
                        int wagePerHour,int workingHourPerWeek, int workingDaysPerWeek,String deadline) {

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
    public Announcement()
    {

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
    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}