package controller;

import java.util.ArrayList;

import boundary.DBBoundary;
import model.IndividualAccount;
import model.Review;
import model.Workhistory;

public class ReviewController {

    public ArrayList<Review> reviewList = new ArrayList<Review>();
    public static DBBoundary dbManager;

    public ArrayList<Review> readReviewById(String enterpriseId) {
        return null;
    }

    public ArrayList<Review> getReviewList() {
        return null;
    }

    public Boolean verifyWorkHistory(String individualId, String enterpriseId) {
        return null;
    }

    public void addToReviewList( String enterpriseId, String individualId, String review) {
        return;
    }

    public void saveDB(Object o) {
        return;
    }

    public ArrayList<Object> readDB(String tablename) {
        return null;
    }

    public Object readDb(String dbname)
    {
        return null;
    }

}