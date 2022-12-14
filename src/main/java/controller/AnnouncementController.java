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
    }

    public void scrapAnnouncement(String individualId,Announcement announcement)
    {
        System.out.println("scrap announcement : "+announcement.getId());
        saveScrapDB(individualId,announcement);
        return;
    }

    public void deleteAnnouncement(int announcementId){
        System.out.println("\nDelete announcement Id : "+ announcementId);
        return;
    }
    public int CalculatedWage(Announcement a){
        int wage = 0;
        announcementList.clear();
        announcementList = readAnnouncementDB();

        wage = a.getWagePerHour() * a.getWorkingHourPerWeek() * 4;
        System.out.println("wage = "+wage+" WagePerHour = "+a.getWagePerHour()+" Working hours per week = "+a.getWorkingHourPerWeek());
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
    public ArrayList<Announcement> readAnnouncementById(int announcementId)
    {
        Announcement announcement = new Announcement();
        boolean find = false;
        announcementList.clear();
        announcementList = readAnnouncementDB();
        for (Announcement a : announcementList){
            if(a.getId() == announcementId) {
                announcement = a;
                find = true;
            }
        }
        announcementList.clear();
        announcementList.add(announcement);
        System.out.println("\nAnnouncement filtered by ID : "+announcementId);
        return announcementList;
    }


    //회사 이름으로 조회하기
    public ArrayList<Announcement> readAnnouncementByName(String enterpriseName)
    {
        ArrayList<Announcement> a1 = new ArrayList<>();
        announcementList.clear();
        for (Announcement a : readAnnouncementDB()){
            if(a.getEnterpriseId().equals(enterpriseName)) {
                a1.add(a);
            }
        }
        System.out.println("\nAnnouncement filtered by enterprise name : "+enterpriseName);
        return validateList(a1);
    }

    //시급으로 조회하기
    public ArrayList<Announcement> readAnnouncementByWage(int wage)
    {
        ArrayList<Announcement> a1 = new ArrayList<>();
        announcementList.clear();
        announcementList = getAnnouncementList();
        for (Announcement a : announcementList){
            if(a.getWagePerHour() >= wage) {
                a1.add(a);
            }
        }
        System.out.println("\nAnnouncement filtered by wage : "+wage);
        return validateList(a1);
    }

    //주시간으로 조회하기
    public ArrayList<Announcement> readAnnouncementByHours(int hours)
    {
        ArrayList<Announcement> a1 = new ArrayList<>();
        announcementList.clear();
        announcementList = getAnnouncementList();
        for (Announcement a : announcementList){
            if(a.getWorkingHourPerWeek() <= hours) {
                a1.add(a);
            }
        }
        System.out.println("\nAnnouncement filtered by hours : "+hours);
        return validateList(a1);
    }

    //주 근무일수로 조회하기
    public ArrayList<Announcement> readAnnouncementByDays(int days)
    {
        ArrayList<Announcement> a1 = new ArrayList<>();
        announcementList.clear();
        for (Announcement a : readAnnouncementDB()){
            if(a.getWorkingDaysPerWeek() <= days) {
                a1.add(a);
            }
        }
        System.out.println("Announcement filtered by working days : "+days);
        return validateList(a1);
    }


    public ArrayList<Announcement> getAnnouncementList()
    {
        announcementList.clear();
        announcementList = readAnnouncementDB();
        return announcementList;
    }

    private ArrayList<Announcement> validateList(ArrayList<Announcement> a){
        if (a.size() == 0){
            System.out.println("No result has been found! Display all announcement");
            return getAnnouncementList();
        }
        else{
            return a;
        }

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
        boolean timePassed = false;
        System.out.println("Today = "+today+" Announcement's deadline : "+a.getDeadline());
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
            timePassed = true;
        else if(todayTimeInt[1] > targetTimeInt[1])
            timePassed = true;
        else if(todayTimeInt[2] > targetTimeInt[2])
            timePassed = true;
        else
            timePassed = false;
        if(timePassed)
            deleteAnnouncement(a.getId());

        return timePassed;
    }
}