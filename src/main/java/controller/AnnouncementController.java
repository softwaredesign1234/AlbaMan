package controller;

import boundary.DBBoundary;
import model.Announcement;
import model.IndividualAccount;

import javax.management.DescriptorAccess;
import java.lang.reflect.Array;
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

    public void scrapAnnouncement(String individualId,Announcement announcement)
    {
        saveScrapDB(individualId,announcement);
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
    public ArrayList<Announcement> readAnnouncementByName(String enterpriseName)
    {
        announcementList.clear();
        for (Announcement a : readAnnouncementDB()){
            if(a.getEnterpriseId().equals(enterpriseName)) {
                announcementList.add(a);
            }
        }
        return validateList(announcementList);
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
        return validateList(announcementList);
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
        return validateList(announcementList);
    }

    //주 근무일수로 조회하기
    public ArrayList<Announcement> readAnnouncementByDays(int days)
    {
        announcementList.clear();
        for (Announcement a : readAnnouncementDB()){
            if(a.getWorkingHourPerWeek() <= days) {
                announcementList.add(a);
            }
        }
        return validateList(announcementList);
    }


    public ArrayList<Announcement> getAnnouncementList()
    {
        announcementList.clear();
        announcementList = readAnnouncementDB();
        return announcementList;
    }

    private ArrayList<Announcement> validateList(ArrayList<Announcement> a){
        if (a.size() == 0)
            return getAnnouncementList();
        else
            return a;
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

            for(Announcement a2 : a.readAnnouncementByName("kakao")){
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
    public boolean deadlinePassed(String today, Announcement a){
        String target = a.getDeadline();
        String[] todayTime = today.split("/");
        String[] targetTime = target.split("/");
        int[] todayTimeInt = {0,0,0};
        int[] targetTimeInt = {0,0,0};
        for(int i=0;i<3;i++){
            todayTimeInt[i] = Integer.parseInt(todayTime[i]);
            targetTimeInt[i] = Integer.parseInt(targetTime[i]);
        }
        if(todayTimeInt[0] > targetTimeInt[0])
            return true;
        else if(todayTimeInt[1] > targetTimeInt[1])
            return true;
        else if(todayTimeInt[2] > targetTimeInt[2])
            return true;
        else
            return false;
    }
}
