package model;

public class Report {


    private int id;


    private String memberId;
    private String reportedMemberId;

    private String reportContext;

    public String getReportContext() {

        return reportContext;
    }

    public void setReportContext(String reportContext) {
        this.reportContext = reportContext;
    }



    public Report(String memberId, String reportedMemberId,String reportContext) {
        this.memberId = memberId;
        this.reportedMemberId = reportedMemberId;
        this.reportContext = reportContext;
    }

    public Report(String memberId, String reportedMemberId) {
        this.memberId = memberId;
        this.reportedMemberId = reportedMemberId;
    }
    public Report(){

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