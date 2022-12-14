import boundary.DBBoundary;
import controller.ReviewController;
import model.EnterpriseAccount;
import model.IndividualAccount;
import model.Review;
import model.Workhistory;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import boundary.ReviewBoundary;

import java.util.ArrayList;

public class ReviewTest extends DBBoundary {

    @Mock
    private static IndividualAccount individual;
    ReviewController reviewController;
    IndividualAccount individual1;
    IndividualAccount individual2;
    EnterpriseAccount enterprise1;
    EnterpriseAccount enterprise2;
    @Mock
    ReviewBoundary reviewBoundary;
    private static ArrayList<Review> savedReview1 = new ArrayList<>();
    private static ArrayList<Review> savedReview2 = new ArrayList<>();

    @BeforeEach
    void basicMember()
    {
        individual1=new IndividualAccount("aa0000@naver.com","010-0000-0000",25,"F","aa0000","0000","janny",true,true,"Individual");
        individual2=new IndividualAccount("aa1111@naver.com","010-1111-1111",21,"M","aa1111","1111","Tom",true,true,"Individual");
        enterprise1=new EnterpriseAccount("000-00-00000","Restaurant","053-222-2222","Daegu","bb0000","0000","steakhouse",true,true,"Enterprise");
        enterprise2=new EnterpriseAccount("111-11-11111","SwimmingPool","053-333-3333","Daegu","bb1111","1111","blueswimming",true,true,"Enterprise");

        saveEnterDB(enterprise1);
        saveEnterDB(enterprise2);
        saveIndiDB(individual1);
        saveIndiDB(individual2);

        Workhistory workhistory1 = new Workhistory("bb0000", "aa0000");
        Workhistory workhistory2 = new Workhistory("bb1111", "aa0000");
        Workhistory workhistory3 = new Workhistory("bb0000", "aa1111");
        Workhistory workhistory4 = new Workhistory("bb1111", "aa1111");

        saveWorkHistoryDB(workhistory1);
        saveWorkHistoryDB(workhistory2);
        saveWorkHistoryDB(workhistory3);
        saveWorkHistoryDB(workhistory4);
    }

    @Test
    @DisplayName("UC8-리뷰 작성 정상")
    void createAReview() {
        String review1 = "1234";
        String review2 = "5678";

        ReviewBoundary.makeAReview(individual1.getId(), enterprise1.getId(), review1);
        ReviewBoundary.makeAReview(individual2.getId(), enterprise1.getId(), review1);
        ReviewBoundary.makeAReview(individual1.getId(), enterprise2.getId(), review2);
        ReviewBoundary.makeAReview(individual2.getId(), enterprise2.getId(), review2);
    }

    @Test
    @DisplayName("UC8-근무 이력 없음")
    void createAReviewFail() {
        String review1 = "review1";

        ReviewBoundary.makeAReview(individual1.getId(), "bb1234", review1);
    }

    @Test
    @DisplayName("UC8-리뷰 조회 정상")
    void searchReviews() {

        createAReview();
        System.out.println("--------------------------");

        ArrayList<Review> searchedReview1 = ReviewBoundary.searchAReview(enterprise1.getId());
        for (Review review : searchedReview1) {
            System.out.println("기업 id: " + review.getEnterpriseId());
            System.out.println("리뷰 내용: " + review.getReview());
        }

        System.out.println("--------------------------");
        ArrayList<Review> searchedReview2 = ReviewBoundary.searchAReview(enterprise2.getId());
        for (Review review : searchedReview1) {
            System.out.println("기업 id: " + review.getEnterpriseId());
            System.out.println("리뷰 내용: " + review.getReview());
        }
    }

    @Test
    @DisplayName("UC8-리뷰 조회 실패(기업 id 일치 항목 없음)")
    void searchReviewFail() {
        createAReview();
        System.out.println("--------------------------");

        ArrayList<Review> searchedReview1 = ReviewBoundary.searchAReview("doesnt-exist");
    }


}