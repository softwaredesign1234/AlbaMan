package boundary;

import model.Announcement;
import model.EnterpriseAccount;
import model.IndividualAccount;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBBoundary {

    private List<Announcement> announcementList = new ArrayList<Announcement>();
    private List<IndividualAccount> individualAccounts = new ArrayList<>();
    private List<EnterpriseAccount> enterpriseAccounts = new ArrayList<>();




    public void saveDB(Object o)
    {
        //받은 obeject를 string으로 변환해서 text파일에 저장하기
    }
    public Object readDb(String dbname)
    {
        return null;
    }


    public ArrayList<Object> readDB(String tablename) {
        return null;
    }


    public List<Announcement> getAnnouncementList() {
        return announcementList;
    }

    public void setAnnouncementList(List<Announcement> announcementList) {
        this.announcementList = announcementList;
    }

    public List<IndividualAccount> getIndividualAccounts() {
        return individualAccounts;
    }

    public void setIndividualAccounts(List<IndividualAccount> individualAccounts) {
        this.individualAccounts = individualAccounts;
    }

    public List<EnterpriseAccount> getEnterpriseAccounts() {
        return enterpriseAccounts;
    }

    public void setEnterpriseAccounts(List<EnterpriseAccount> enterpriseAccounts) {
        this.enterpriseAccounts = enterpriseAccounts;
    }
}
