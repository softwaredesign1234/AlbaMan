package controller;


import boundary.DBBoundary;
import jdk.nashorn.internal.runtime.QuotedStringTokenizer;
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

    public void addQuestion(String individualId, String questionContext){
        Question q = new Question(individualId,questionContext);
        saveQuestionDB(q);
        return;
    }
    public void addAnswer(int questionId, String questionAnswer){
        questionList.clear();
        questionList = readQuestionDB();
        clearDB("Question");
        for (Question q : questionList){
            if (q.getId() == questionId) {
                q.setAnswer(questionAnswer);
                saveQuestionDB(q);
            }
            else{
                saveQuestionDB(q);
            }
        }
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

    public static void main(String args[]){
        QuestionController questionController = new QuestionController();
        questionController.addQuestion("1","question1");
        questionController.addQuestion("2","question2");
        questionController.addAnswer(1,"answer1");
        questionController.addAnswer(2,"answer2");

        System.out.println(questionController.findAnswer(1).getAnswer());

    }

}