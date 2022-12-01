package announcement;

import resume.Resume;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AnnouncementList {

    static ArrayList<Announcement> announcementList=new ArrayList<>();


    public static void saveAnnouncement(String enterpriseId,int wagePerHour,int workingHourPerWeek,int workingDaysPerWeek) throws Exception {
        int id=getAnnouncementList().size()+1;
        Announcement announcement=new Announcement(id);
        announcement.addAnnouncement(enterpriseId,wagePerHour,workingHourPerWeek,workingDaysPerWeek);
        announcementList.add(announcement);
        System.out.println("Succefully saved!");

    }

    //공고 id로 조회하기 (원하는 하나의 공고 조회)
    public static Announcement readAnnouncementbyId(int announcementid)
    {
        ArrayList<Announcement> arr=getAnnouncementList();

        Announcement resultAnnouncement=arr.stream()
                .filter(announcement -> announcementid==announcement.getId())
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
    public static ArrayList<Announcement> readAnnouncementBywage(int wage)
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

        return resultAnnouncement;
    }


    //카테고리로도 검색하고 싶으면 EnterpriseAccount를 Apply가 변수로 가지고 있어야함
    //enterpriseId를 입력받아서 찾고 apply에 추가해야하는데
    //db 조회가 안됨

    public static ArrayList<Announcement> getAnnouncementList()
    {
        return announcementList;
    }


    public static void main(String[] args) throws Exception{
        saveAnnouncement("삼성전자",5000,52,5);
        saveAnnouncement("카카오",5000,52,5);
        saveAnnouncement("카카오",3000,40,5);
        saveAnnouncement("카카오",4000,45,4);

        saveAnnouncement("쿠팡",5000,52,5);

        saveAnnouncement("네이버",5000,52,5);

        ArrayList<Announcement> result=readAnnouncementByCategory("카카오");
        for(int i=0;i<result.size();i++)
        {
            System.out.println(result.get(i).getId()+" "+result.get(i).getEnterpriseId()+" "+result.get(i).getWagePerHour()+" "+result.get(i).getWorkingHourPerWeek()+" "+result.get(i).getWorkingDaysPerWeek());
        }



    }

}
