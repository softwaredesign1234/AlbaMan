package controller;


import boundary.DBBoundary;
import model.Question;
import model.Report;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionController extends DBBoundary{

    ArrayList<Question> questionList = new ArrayList<>();

    static DBBoundary dbManager;
    private final String managerEmail = "11@naver.com";
    private final String managerPhoneNumber = "01051111111";

    public String showMail(){

        return managerEmail;
    }
    public String showPhoneNumber(){

        return managerPhoneNumber;
    }

    public void addQuestion(String questionContext){
        Question q = new Question();
        q.setQuestion(questionContext);
        saveQuestionDB(q);

        return;
    }
    public void addAnswer(int questionId, String questionAnswer){

        return;
    }
    public Question findAnswer(int questionId){
        Question question = new Question();
        for (Question q : readQuestionDB())
        {
            if (q.getId() == questionId)
                question = q;
        }
        return question;
    }


}