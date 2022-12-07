package controller;

import java.util.ArrayList;

import model.IndividualAccount;
import model.Review;
import model.Workhistory;

public class ReviewController {

    public ArrayList<Review> reviewList = new ArrayList<Review>();

    public static ArrayList<Review> readReviewById(String enterpriseId) {
    	
    	ArrayList<Review> reviews = reviewList.stream()
    			.filter(r -> r.getEnterpriseId().equals(enterpriseId))
    			.collect(Collectors.toList());
    	
        return reviews;
    }

    public static ArrayList<Review> getReviewList() {
    	
        // return reviewList;
    	return readDB("reviewList");
    }

    public static Boolean verifyWorkHistory(String individualId, String enterpriseId) {
    	
    	ArrayList<IndividualAccount> individualAccounts = readDB("individualAccounts");
    	ArrayList<WorkHistory> workHistory;
    	
    	IndividualAccount iAccount = individualAccounts.stream()
    			.filter(i -> i.getId().equals(individualId));
    	
    	if (iAccount == null)
    		return false;
    	else {
    		workHistory = iAccount.getWorkHistory();
    		if (workHistory.stream()
    				.filter(w -> w.getEnterpriseId().equals(enterpriseId)))
    			return true;
    	}
    	
    	return false;
    }

    public static void addToReviewList( String enterpriseId, String individualId, String review) {
        
    	Review newReview = new Review(enterpriseId, individualId, review);
    	
    	// reviewList.add(newReview);
    	saveDB(newReview);
    	
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