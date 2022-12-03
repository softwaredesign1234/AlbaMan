package controller;


import boundary.DBBoundary;
import model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionController {

    static DBBoundary dbManager;
    private final String email = "11@naver.com";
    private final String phoneNumber = "01051111111";

    public String showMail(){
        return null;
    }
    public String showPhoneNumber(){
        return null;
    }

    public void addQuestion(String email, String phoneNumber, String question){
        return;
    }
    public void addAnswer(int questionId, String questionAnswer){
        return;
    }
    public Question findAnswer(int questionId){
        return null;
    }
    public List<Question> findQuestion(int questionId, String question){

        return null;
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