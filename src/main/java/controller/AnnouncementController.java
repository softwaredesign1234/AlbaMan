package controller;

import boundary.DBBoundary;
import model.Announcement;
import model.IndividualAccount;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AnnouncementController {

    public static ArrayList<Announcement> announcementList=new ArrayList<>();
    public static ArrayList<IndividualAccount> individualAccounts=new ArrayList<>();


    public static DBBoundary dbManager;
    public static void makeAnnouncement(String enterpriseId,int wagePerHour,int workingHourPerWeek,int workingDaysPerWeek) throws Exception
    {
        LocalDate now = LocalDate.now();
        int id=getAnnouncementList().size()+1;

        Announcement announcement=new Announcement(id,enterpriseId,wagePerHour,workingHourPerWeek,workingDaysPerWeek,now);
        announcementList.add(announcement);
        System.out.println("Succefully saved!");
    }

    public static void scrapAnnouncement(String individualId,int id)
    {
        IndividualAccount individualAccount=getIndividual(individualId);
        Announcement announcement=readAnnouncementById(id);
        individualAccount.scrapAnnouncement(announcement);
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
        ArrayList<Announcement> arr=getAnnouncementList();

        Announcement resultAnnouncement=arr.stream()
                .filter(announcement -> announcementId==announcement.getId())
                .findAny()
                .orElse(null);

        return resultAnnouncement;
    }


    //회사 이름으로 조회하기
    public static ArrayList<Announcement> readAnnouncementByCategory(String enterpriseId)
    {
        ArrayList<Announcement> arr=getAnnouncementList();
        ArrayList<Announcement> resultAnnouncement= (ArrayList<Announcement>) arr.stream()
                .filter(announcement -> enterpriseId.equals(announcement.getEnterpriseId()))
                .collect(Collectors.toList());

        return resultAnnouncement;
    }

    //시급으로 조회하기
    public static ArrayList<Announcement> readAnnouncementByWage(int wage)
    {
        ArrayList<Announcement> arr=getAnnouncementList();
        ArrayList<Announcement> resultAnnouncement= (ArrayList<Announcement>) arr.stream()
                .filter(announcement -> wage==announcement.getWagePerHour())
                .collect(Collectors.toList());

        return resultAnnouncement;
    }

    //주시간으로 조회하기
    public static ArrayList<Announcement> readAnnouncementByHours(int hours)
    {
        ArrayList<Announcement> arr=getAnnouncementList();
        ArrayList<Announcement> resultAnnouncement= (ArrayList<Announcement>) arr.stream()
                .filter(announcement -> hours==announcement.getWagePerHour())
                .collect(Collectors.toList());

        return resultAnnouncement;
    }

    //주 근무일수로 조회하기
    public static ArrayList<Announcement> readAnnouncementByDays(int days)
    {
        ArrayList<Announcement> arr=getAnnouncementList();
        ArrayList<Announcement> resultAnnouncement= (ArrayList<Announcement>) arr.stream()
                .filter(announcement -> days==announcement.getWorkingDaysPerWeek())
                .collect(Collectors.toList());

        return resultAnnouncement;    }


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
