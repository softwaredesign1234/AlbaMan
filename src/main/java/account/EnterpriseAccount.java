package account;

import account.Account;
import java.util.*;
import java.io.*;
import announcement.Announcement;

public class EnterpriseAccount extends Account implements Serializable {

    private String companyNum;


    private String category;
    private String companyPhoneNumber;
    private String companyLocation;

    public EnterpriseAccount(String id,String password,String name,Boolean valid,Boolean isActive,String type)
    {
        this.id=id;
        this.password=password;
        this.name=name;
        this.valid=valid;
        this.isActive=isActive;
        this.type=type;
    }

    public EnterpriseAccount(String companyNum, String category, String companyPhoneNumber, String companyLocation,
                             String id, String password, String name,
                             Boolean valid, Boolean isActive, String type) {
        this.companyNum = companyNum;
        this.category = category;
        this.companyLocation = companyLocation;
        this.companyPhoneNumber = companyPhoneNumber;
        this.id = id;
        this.password = password;
        this.name = name;
        this.valid = valid;
        this.isActive = isActive;
        this.type = type;
    }













    //getter,setter
    public String getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(String companyNum) {
        this.companyNum = companyNum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }


}
