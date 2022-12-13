package boundary;

import model.FAQ;
import controller.FAQController;

import java.util.ArrayList;

public class QuestionBoundary {
    public void inputQuestion(){
        //input question fields
        return;
    }
    public void showAdminInform(){

        return;
    }

    public void showQuestionList(){
        return;
    }

    public void inputAnswer(){
        //input answer fields
        return;
    }
    public static void makeAFAQ(String question, String answer) {
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
}
