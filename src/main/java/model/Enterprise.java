package model;

public class Enterprise extends Account {
    private String companyNum;
    private String companyPhoneNumber;
    private String companyLocation;
    private String category;

    public Enterprise(String id, String companyNum){
        super(id);
        this.companyNum = companyNum;
    }
    public Enterprise(String id) {
        super(id);
    }


    public String getCompanyName() {
        return companyNum;
    }

    public void setCompanyName(String companyName) {
        this.companyNum = companyName;
    }

}
