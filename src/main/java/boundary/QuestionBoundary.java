package boundary;

import controller.FAQController;
import model.FAQ;
import model.Question;

import java.util.ArrayList;
import java.util.Scanner;

public class QuestionBoundary {

    public static void makeAFAQ(String question, String answer) {
        System.out.println("QuestionBoundary - makeAFAQ() visited");
        FAQController.addToFAQ(question, answer);
    }

    public static ArrayList<FAQ> searchFAQ() {

        ArrayList<FAQ> faq = FAQController.getFAQList();

        if (faq.isEmpty()) {
            System.out.println("FAQ search 실패: FAQ가 없음");
        }
        else {
            System.out.println("FAQ search 성공");
        }
        return faq;
    }


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

}