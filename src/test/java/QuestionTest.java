import boundary.DBBoundary;
import boundary.QuestionBoundary;
import controller.AccountController;
import controller.QuestionController;
import model.Account;
import model.IndividualAccount;
import model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class QuestionTest {
    QuestionController questionController = new QuestionController();
    IndividualAccount a1 = new IndividualAccount("aa0000@naver.com","010-0000-0000",25,"F","aa0000","0000","janny",true,true,"Individual");
    QuestionBoundary questionBoundary = new QuestionBoundary();

    DBBoundary dbBoundary = new DBBoundary();
    @BeforeEach
    void setting(){
        dbBoundary.clearDB("Question");
    }
    @Test
    @DisplayName("UC9-질문 등록 정상")
    public void makeQuestion(){
        ArrayList<Question> questionList = new ArrayList<>();
        String context = "";
        String answer = "";
        int questionId = 0;

        context = questionBoundary.inputQuestion();
        questionController.addQuestion(a1.getId(),context);

        questionList = questionController.findQuestion();
        questionBoundary.showQuestionList(questionList);

        System.out.println("set questionID = 1");
        questionId = 1;

        answer = questionBoundary.inputAnswer();
        questionController.addAnswer(questionId,answer);

    }

    @Test
    @DisplayName("UC9-관리자 직접연락 정보조회")
    public void directAsk(){
        String email = "";
        String phone = "";

        email = questionController.showMail();
        phone = questionController.showPhoneNumber();

        questionBoundary.showAdminInform(phone,email);

    }
}