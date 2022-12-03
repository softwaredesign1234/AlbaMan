package controller;

import boundary.DBBoundary;
import model.IndividualAccount;

import java.util.ArrayList;

public class ReportController {

    static DBBoundary dbManager;

    public void deactivateMember(String reportedMemberId){

        return;
    }
    public IndividualAccount findMemberInfo(String reportedMemberId){

        return null;
    }
    public void makeValidation(String reportedMemberId, String validOrNot){

        return;
    }
    public void addReport(String memberId, String reportedMemberId){

        return;
    }
    public void saveDB(Object o)
    {
        //받은 obeject를 string으로 변환해서 text파일에 저장하기
        return;
    }
    public Object readDb(String dbname)
    {
        return null;
    }

    public ArrayList<Object> readDB(String tablename) {
        return null;
    }



}