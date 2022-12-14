package controller;

import boundary.DBBoundary;
import model.Announcement;
import model.IndividualAccount;

import java.util.ArrayList;

public class AnnouncementController extends DBBoundary {

    ArrayList<Announcement> announcementList=new ArrayList<>();
    ArrayList<IndividualAccount> individualAccounts=new ArrayList<>();

    public void makeAnnouncement(String enterpriseId,int wagePerHour,int workingHourPerWeek,int workingDaysPerWeek, String deadline) throws Exception
    {
        System.out.println("AnnouncementController - makeAnnouncement() visited");

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
        System.out.println("AnnouncementController - scrapAnnouncement() visited");

        System.out.println("scrap announcement : "+announcement.getId());
        saveScrapDB(individualId,announcement);
        return;
    }

    public void deleteAnnouncement(int announcementId){
        System.out.println("AnnouncementController - deleteAnnouncement() visited");

        System.out.println("\nDelete announcement Id : "+ announcementId);
        return;
    }
    public int CalculatedWage(Announcement a){
        System.out.println("AnnouncementController - CalculatedWage() visited");

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
        System.out.println("AnnouncementController - readAnnouncementById() visited");

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
        System.out.println("AnnouncementController - readAnnouncementByName() visited");

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
        System.out.println("AnnouncementController - readAnnouncementByWage() visited");

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
        System.out.println("AnnouncementController - readAnnouncementByHours() visited");

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

        System.out.println("AnnouncementController - readAnnouncementByDays() visited");

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
        System.out.println("AnnouncementController - getAnnouncementList() visited");

        announcementList.clear();
        announcementList = readAnnouncementDB();
        return announcementList;
    }

    private ArrayList<Announcement> validateList(ArrayList<Announcement> a){
        System.out.println("AnnouncementController - validateList() visited");

        if (a.size() == 0){
            System.out.println("No result has been found! Display all announcement");
            return getAnnouncementList();
        }
        else{
            return a;
        }

    }


    public boolean deadlinePassed(String today, Announcement a){
        System.out.println("AnnouncementController - deadlinePassed() visited");

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