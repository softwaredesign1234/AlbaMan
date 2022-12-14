import boundary.DBBoundary;
import boundary.QuestionBoundary;
import controller.AccountController;
import controller.QuestionController;
import controller.FAQController;
import model.Account;
import model.IndividualAccount;
import model.EnterpriseAccount;
import model.Question;
import model.FAQ;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FAQTest extends DBBoundary {

    FAQController faqController = new FAQController();

    @Test
    @DisplayName("UC9-FAQ 등록 정상")
    void createFAQ() {

        String question1 = "i_can't_find_my_id";
        String answer1 = "we_don't_know";

        String question2 = "where-are-you";
        String answer2 = "behind-you";

        QuestionBoundary.makeAFAQ(question1, answer1);
        QuestionBoundary.makeAFAQ(question2, answer2);
    }

    @Test
    @DisplayName("UC9-FAQ 조회 정상")
    void searchFAQ() {
        createFAQ();

        ArrayList<FAQ> faqList = QuestionBoundary.searchFAQ();

        int count = 1;
        for (FAQ faq : faqList) {
            System.out.println(count++ + "번 " + "Q: " + faq.getQuestion() + "/ A: " + faq.getAnswer());
        }
    }

    @Test
    @DisplayName("UC9-FAQ 없음 조회 실패")
    void searchFAQFail() {
        clearDB("FAQ");

        QuestionBoundary.searchFAQ();
    }

}