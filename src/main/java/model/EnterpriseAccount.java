package model;


import java.io.*;

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
    public String getEnterpriseNum() {
        return enterpriseNum;
    }

    public void setEnterpriseNum(String enterpriseNum) {
        this.enterpriseNum = enterpriseNum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEnterprisePhoneNumber() {
        return enterprisePhoneNumber;
    }

    public void setEnterprisePhoneNumber(String enterprisePhoneNumber) {
        this.enterprisePhoneNumber = enterprisePhoneNumber;
    }

    public String getEnterpriseLocation() {
        return enterpriseLocation;
    }

    public void setEnterpriseLocation(String enterpriseLocation) {
        this.enterpriseLocation = enterpriseLocation;
    }



}
