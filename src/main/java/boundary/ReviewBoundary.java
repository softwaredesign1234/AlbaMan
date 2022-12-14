package boundary;

import java.util.ArrayList;

import controller.ReviewController;
import model.IndividualAccount;
import model.Review;

public class ReviewBoundary extends DBBoundary {

    public static ReviewController reviewCon;

    public static void makeAReview(String individualId, String enterpriseId, String review) {

        Boolean result = reviewCon.verifyWorkHistory(individualId, enterpriseId);

        if (result == false)
            System.out.println("리뷰 작성 실패: 권한 없음");
        else {
            reviewCon.addToReviewList(enterpriseId, individualId, review);
            System.out.println("리뷰 작성 성공");
        }
    }

    public static ArrayList<Review> searchAReview(String enterpriseId) {

        ArrayList<Review> searchReviewList = reviewCon.readReviewById(enterpriseId);
        return searchReviewList;
    }

}