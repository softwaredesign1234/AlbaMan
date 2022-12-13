package boundary;

import model.FAQ;
import model.Question;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionBoundary {

    private Scanner sc = new Scanner(System.in);

    public String inputQuestion(){
        System.out.println("Input your question");
        return "DoesSign-upFree?";
//        return sc.nextLine();
    }
    public String showAdminInform(String email,String phone){
        System.out.println("Contract Email : "+email+"\nContract number : "+phone);

        return null;
    }

    public void showQuestionList(ArrayList<Question> questionList){
        for (Question q : questionList){
            System.out.println("Question ID : "+q.getId()
                    +" Individual ID : "+q.getIndividualId()
                    +" Question context : "+q.getQuestion()
                    +" Answer : "+q.getAnswer());
        }
        return;
    }

    public String inputAnswer(){
        //input answer fields
//        String answer = sc.nextLine();
//        return answer;
        return "yes";
    }
    public void makeAFAQ() {
        return;
    }

    public ArrayList<FAQ> searchFAQ() {
        return null;
    }
}
