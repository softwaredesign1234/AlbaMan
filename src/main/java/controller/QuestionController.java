package controller;


import boundary.DBBoundary;
import model.Question;
import model.Report;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionController {

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
        saveDB(q);
        return;
    }
    public void addAnswer(int questionId, String questionAnswer){

        return;
    }
    public Question findAnswer(int questionId){
        Question question = new Question();
        for (Question q : readDB(questionId))
        {
            if (q.getId() == questionId)
                question = q;
        }
        return question;
    }

    public void saveDB(Question question)
    {
        List<String> questionInfo = new ArrayList<>();
        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\QuestionDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f));
            questionInfo.add(question.getId()+" ");
            questionInfo.add(question.getQuestion()+" ");
            questionInfo.add(question.getAnswer()+" ");

            for (String info : questionInfo){
                bufferedWriter.write(info,0,info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        }catch (Exception e){

        }

        return;
    }

    public ArrayList<Question> readDB(int questionId) {

        try {
            File f = new File("C:\\momo\\java_workspace\\AlbaMan\\AlbaMan\\src\\main\\java\\QuestionDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
                Question question = new Question();
                String[] info = line.split(" ");
                question.setId(Integer.parseInt(info[0]));
                question.setQuestion(info[1]);
                question.setAnswer(info[2]);

                questionList.add(question);
            }
            bufferedReader.close();

        }catch (Exception e){

        }
        return questionList;
    }

}