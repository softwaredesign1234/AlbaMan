package controller;

import boundary.DBBoundary;
import model.IndividualAccount;
import model.Review;
import model.Workhistory;

import java.util.ArrayList;

public class ReviewController extends DBBoundary {

    public ArrayList<Review> reviewList = new ArrayList<Review>();

    public static ArrayList<Review> readReviewById(String enterpriseId) {
        System.out.println("ReviewController - readReviewById() visited");


        Boolean result = false;

        ArrayList<Review> reviewList = DBBoundary.readReviewDB();
        ArrayList<Review> searchReviewList = new ArrayList<>();

        for (Review review : reviewList) {
            if (review.getEnterpriseId().equals(enterpriseId)) {
                searchReviewList.add(review);
                result = true;
            }
        }

        if (result == false) {
            System.out.println("검색 결과 없음");
        }
        else {
            System.out.println("리뷰 검색 성공");
        }

        return searchReviewList;
    }

    public static Boolean verifyWorkHistory(String individualId, String enterpriseId) {
        System.out.println("ReviewController - verifyWorkHistory() visited");

        ArrayList<IndividualAccount> individualAccounts = DBBoundary.readIndiDB();
        ArrayList<Workhistory> workHistoryDB = DBBoundary.readWorkHistoryDB();
        ArrayList<Workhistory> workHistory = new ArrayList<>();

        IndividualAccount iAccount = individualAccounts.stream()
                .filter(i -> i.getId().equals(individualId))
                .findAny()
                .orElse(null);

        if (iAccount == null)
            return false;
        else {
            for (Workhistory w : workHistoryDB) {
                if (w.getIndividualId().equals(iAccount.getId())) {
                    workHistory.add(w);
                }
            }

            Workhistory find = workHistory.stream()
                    .filter(w -> w.getEnterpriseId().equals(enterpriseId))
                    .findAny()
                    .orElse(null);

            if (find == null) {
                System.out.println("workhistory 확인 실패: 리뷰 권한 실패");
                return false;
            }
            else {
                System.out.println("workhistory 확인 완료: 리뷰 권한 성공");
                return true;
            }
        }
    }

    public static Review addToReviewList( String enterpriseId, String individualId, String review) {
        System.out.println("ReviewController - addToReviewList() visited");

        Review newReview = new Review(enterpriseId, individualId, review);
        DBBoundary.saveReviewDB(newReview);

        return newReview;
    }

}