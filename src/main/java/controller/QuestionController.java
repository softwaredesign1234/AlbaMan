package controller;


import boundary.DBBoundary;
import model.Question;

import java.util.ArrayList;

public class QuestionController extends DBBoundary{

    ArrayList<Question> questionList = new ArrayList<>();

    private final String managerEmail = "11@naver.com";
    private final String managerPhoneNumber = "01051111111";

    public String showMail(){
        System.out.println("QuestionController - showMail() visited");
        return managerEmail;
    }
    public String showPhoneNumber(){
        System.out.println("QuestionController - showPhoneNumber() visited");
        return managerPhoneNumber;
    }

    public void addQuestion(String individualId, String questionContext){
        System.out.println("QuestionController - addQuestion() visited");

        Question q = new Question(individualId,questionContext);
        saveQuestionDB(q);
        System.out.println("Member id : "+ individualId + "\nAdd question : "+questionContext);
        return;
    }
    public void addAnswer(int questionId, String questionAnswer){
        System.out.println("QuestionController - addAnswer() visited");

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
        System.out.println("QuestionController - findAnswer() visited");

        Question question = new Question();
        for (Question q : readQuestionDB())
        {
            if (q.getId() == questionId)
                question = q;
        }
        return question;
    }

    public ArrayList<Question> findQuestion(){
        System.out.println("QuestionController - findQuestion() visited");

        questionList = readQuestionDB();
        return questionList;
    }



}