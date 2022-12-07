package boundary;

import java.util.ArrayList;

import controller.ReviewController;
import model.IndividualAccount;
import model.Review;

public class ReviewBoundary {
	
	// input
	ArrayList<Review> reviewList = new ArrayList<Review>();

    public void makeAReview() {
    	
    	String individualId;
    	String enterpriseid;
    	String review;
    	
    	Boolean result = reviewList.verifyWorkHistory(individualId, enterpriseId);
    	if (result == false)
    		System.out.println("fail to leave a review");
    	else {
    		addToReviewList(enterpriseId, individualId, review);
    	}
    	
        return;
    }

    public ArrayList<Review> searchAReview() {
    	
    	String searchEnterpriseId;
    	
    	// all
    	// ArrayList<Review> searchResult = reviewList.getReviewList();
    	
    	// filtering
    	ArrayList<Review> searchResult;
    	searchResult = reviewList.readReviewById(searchEnterpriseId);

    	
    	
        return searchResult;
    }

}