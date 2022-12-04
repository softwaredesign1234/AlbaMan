package controller;

import boundary.DBBoundary;
import model.Announcement;
import model.IndividualAccount;

import java.util.ArrayList;

public class AnnouncementController {

    public static ArrayList<Announcement> announcementList=new ArrayList<>();
    public static ArrayList<IndividualAccount> individualAccounts=new ArrayList<>();


    public static DBBoundary dbManager;
    public static void makeAnnouncement(String enterpriseId,int wagePerHour,int workingHourPerWeek,int workingDaysPerWeek) throws Exception
    {
        return;
    }

    public static void scrapAnnouncement(String individualId,int id)
    {
        return;
    }

    public void deleteAnnouncement(int AnnouncementId){
        return;
    }
    public int CalculatedWage(int wagePerHour, int workingHour){
        return wagePerHour*workingHour;
    }
    public static IndividualAccount getIndividual(String individualId)
    {
        return null;
    }

    public static ArrayList<IndividualAccount> getIndividualAccounts()
    {
        return individualAccounts;
    }
    //공고 id로 조회하기 (원하는 하나의 공고 조회)
    public static Announcement readAnnouncementById(int announcementId)
    {
        return null;
    }


    //회사 이름으로 조회하기
    public static ArrayList<Announcement> readAnnouncementByCategory(String enterpriseId)
    {
        return null;
    }

    //시급으로 조회하기
    public static ArrayList<Announcement> readAnnouncementByWage(int wage)
    {
        return null;
    }

    //주시간으로 조회하기
    public static ArrayList<Announcement> readAnnouncementByHours(int hours)
    {
        return null;
    }

    //주 근무일수로 조회하기
    public static ArrayList<Announcement> readAnnouncementByDays(int days)
    {
        return null;
    }


    public static ArrayList<Announcement> getAnnouncementList()
    {
        return announcementList;
    }


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
}
