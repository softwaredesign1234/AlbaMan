package model;

public class Report {


    private int id;


    private String memberId;
    private String reportedMemberId;

    public String getReportContext() {
        return reportContext;
    }

    public void setReportContext(String reportContext) {
        this.reportContext = reportContext;
    }

    private String reportContext;


    public Report(String memberId, String reportedMemberId) {
        this.memberId = memberId;
        this.reportedMemberId = reportedMemberId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getReportedMemberId() {
        return reportedMemberId;
    }

    public void setReportedMemberId(String reportedMemberId) {
        this.reportedMemberId = reportedMemberId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}