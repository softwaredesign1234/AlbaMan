package boundary;

import controller.ReviewController;
import model.Review;

import java.util.ArrayList;

public class ReviewBoundary extends DBBoundary {

    public static ReviewController reviewCon;

    public static void makeAReview(String individualId, String enterpriseId, String review) {
        System.out.println("ReviewBoundary - makeAReview() visited");

        Boolean result = reviewCon.verifyWorkHistory(individualId, enterpriseId);

        if (result == false)
            System.out.println("리뷰 작성 실패: 권한 없음");
        else {
            reviewCon.addToReviewList(enterpriseId, individualId, review);
            System.out.println("리뷰 작성 성공");
        }
    }

    public static ArrayList<Review> searchAReview(String enterpriseId) {
        System.out.println("ReviewBoundary - searchAReview() visited");

        ArrayList<Review> searchReviewList = reviewCon.readReviewById(enterpriseId);
        return searchReviewList;
    }

}