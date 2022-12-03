package model;

public class Report {
    private int id;
    private String memberId;
    private String reportedMemberId;


    public Report(String memberId, String reportedMemberId) {
        this.memberId = memberId;
        this.reportedMemberId = reportedMemberId;
    }


}