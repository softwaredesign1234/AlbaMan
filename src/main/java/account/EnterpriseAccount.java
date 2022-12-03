package account;

import account.Account;
import java.util.*;
import java.io.*;
import announcement.Announcement;

public class EnterpriseAccount extends Account implements Serializable {

    private String enterpriseNum;
    private String category;
    private String enterprisePhoneNumber;
    private String enterpriseLocation;

    public EnterpriseAccount(String id,String password,String name,Boolean valid,Boolean isActive,String type)
    {
        this.id=id;
        this.password=password;
        this.name=name;
        this.valid=valid;
        this.isActivated=isActive;
        this.type=type;
    }

    public EnterpriseAccount(String companyNum, String category, String companyPhoneNumber, String companyLocation,
                             String id, String password, String name,
                             Boolean valid, Boolean isActive, String type) {
        this.enterpriseNum = companyNum;
        this.category = category;
        this.enterprisePhoneNumber = companyLocation;
        this.enterpriseLocation = companyPhoneNumber;
        this.id = id;
        this.password = password;
        this.name = name;
        this.valid = valid;
        this.isActivated = isActive;
        this.type = type;
    }




    //getter,setter
    public String getCompanyNum() {
        return enterpriseNum;
    }

    public void setCompanyNum(String companyNum) {
        this.enterpriseNum = companyNum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCompanyPhoneNumber() {
        return enterprisePhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.enterprisePhoneNumber = companyPhoneNumber;
    }

    public String getCompanyLocation() {
        return enterpriseLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.enterpriseLocation = companyLocation;
    }


}
