package controller;


import model.Question;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionList {

    private final String email = "11@naver.com";
    private final String phoneNumber = "01051111111";

    public String showMail(){
        return email;
    }
    public String showPhoneNumber(){
        return phoneNumber;
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

}

