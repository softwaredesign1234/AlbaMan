package controller;

import boundary.DBBoundary;
import model.Announcement;
import model.IndividualAccount;

import javax.management.DescriptorAccess;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AnnouncementController extends DBBoundary {

    ArrayList<Announcement> announcementList=new ArrayList<>();
    ArrayList<IndividualAccount> individualAccounts=new ArrayList<>();

    public void makeAnnouncement(String enterpriseId,int wagePerHour,int workingHourPerWeek,int workingDaysPerWeek, String deadline) throws Exception
    {
        Announcement announcement = new Announcement();
        announcement.setEnterpriseId(enterpriseId);
        announcement.setWagePerHour(wagePerHour);
        announcement.setWorkingHourPerWeek(workingHourPerWeek);
        announcement.setWorkingDaysPerWeek(workingDaysPerWeek);
        announcement.setDeadline(deadline);
        saveAnnouncementDB(announcement);
        return;
    }

    public static void scrapAnnouncement(String individualId,int id)
    {
        return;
    }

    public void deleteAnnouncement(int AnnouncementId){
        return;
    }
    public int CalculatedWage(int announcementId){
        int wage = 0;
        announcementList.clear();
        announcementList = readAnnouncementDB();
        for (Announcement a : announcementList){
            if(a.getId() == announcementId) {
                wage = a.getWagePerHour() * a.getWorkingHourPerWeek() * 4;
            }
        }
        return wage;
    }
    public IndividualAccount getIndividual(String individualId)
    {
        return null;
    }

    public ArrayList<IndividualAccount> getIndividualAccounts()
    {
        return individualAccounts;
    }
    //공고 id로 조회하기 (원하는 하나의 공고 조회)
    public Announcement readAnnouncementById(int announcementId)
    {
        Announcement announcement = new Announcement();
        announcementList.clear();
        announcementList = readAnnouncementDB();
        for (Announcement a : announcementList){
            if(a.getId() == announcementId) {
                announcement = a;
            }
        }
        return announcement;
    }


    //회사 이름으로 조회하기
    public ArrayList<Announcement> readAnnouncementByCategory(String enterpriseId)
    {
        announcementList.clear();
        for (Announcement a : readAnnouncementDB()){
            if(a.getEnterpriseId().equals(enterpriseId)) {
                announcementList.add(a);
            }
        }
        return announcementList;
    }

    //시급으로 조회하기
    public ArrayList<Announcement> readAnnouncementByWage(int wage)
    {
        announcementList.clear();
        announcementList = getAnnouncementList();
        for (Announcement a : announcementList){
            if(a.getWagePerHour() >= wage) {
                announcementList.add(a);
            }
        }
        return announcementList;
    }

    //주시간으로 조회하기
    public ArrayList<Announcement> readAnnouncementByHours(int hours)
    {
        announcementList.clear();
        announcementList = getAnnouncementList();
        for (Announcement a : announcementList){
            if(a.getWorkingHourPerWeek() <= hours) {
                announcementList.add(a);
            }
        }
        return announcementList;
    }

    //주 근무일수로 조회하기
    public ArrayList<Announcement> readAnnouncementByDays(int days)
    {
        announcementList.clear();
        announcementList = getAnnouncementList();
        for (Announcement a : announcementList){
            if(a.getWorkingHourPerWeek() <= days) {
                announcementList.add(a);
            }
        }
        return announcementList;
    }


    public ArrayList<Announcement> getAnnouncementList()
    {
        announcementList = readAnnouncementDB();
        return announcementList;
    }

    public static void main(String args[]){
        try {
            AnnouncementController a = new AnnouncementController();
            DBBoundary dbBoundary = new DBBoundary();
            dbBoundary.clearDB("Announcement");

            a.makeAnnouncement("kakao", 10000, 50, 5, "22/12/31");
            a.makeAnnouncement("apple", 10000, 40, 4, "22/12/31");
            for(Announcement a1 : a.getAnnouncementList()){
                System.out.println(a1.getEnterpriseId());
            }
            System.out.println(a.CalculatedWage(1));

            for(Announcement a2 : a.readAnnouncementByCategory("kakao")){
                System.out.println(a2.getEnterpriseId());
            }
            //less than days
            for(Announcement a3 : a.readAnnouncementByDays(4)){
                System.out.println(a3.getEnterpriseId());
            }
            //more than wage
            for(Announcement a5 : a.readAnnouncementByWage(8000)){
                System.out.println(a5.getEnterpriseId());
            }
            //less than hours
            for(Announcement a4 : a.readAnnouncementByHours(45)){
                System.out.println(a4.getEnterpriseId());
            }

            System.out.println(a.readAnnouncementById(1));


        }catch(Exception e){

        }
    }
}
