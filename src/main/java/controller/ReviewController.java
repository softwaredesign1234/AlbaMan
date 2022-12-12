package controller;

import java.util.ArrayList;
import java.io.*;

import model.IndividualAccount;
import model.Review;
import model.Workhistory;

import boundary.DBBoundary;


public class ReviewController {

    public ArrayList<Review> reviewList = new ArrayList<Review>();
    
    public DBBoundary DBManager = new DBBoundary();

    public static ArrayList<Review> readReviewById(String enterpriseId) {
    	
    	reviewList = DBManager.readReviewDB();
    	
    	ArrayList<Review> reviews = reviewList.stream()
    			.filter(r -> r.getEnterpriseId().equals(enterpriseId))
    			.collect(Collectors.toList());
    	
        return reviews;
    }

    public static Boolean verifyWorkHistory(String individualId, String enterpriseId) {
    	
    	ArrayList<IndividualAccount> individualAccounts = DBManager.readIndividualAccountDB();
    	ArrayList<WorkHistory> workHistory = DBManager.readWorkHistoryDB();
    	
    	
    	
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

    public void saveDB(Review review)
    {
        List<String> reviewInfo = new ArrayList<>();
        
        try {
            File f = new File("/Users/kimseojin/git/AlbaMan/.git/AlbaMan/src/main/java/ReviewDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f));
            reviewInfo.add(review.getEnterpriseId()+" ");
            reviewInfo.add(review.getIndividualId()+" ");
            reviewInfo.add(review.getRevew()+" ");

            for (String review : reviewInfo){
                bufferedWriter.write(review, 0, review.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e){
        	System.out.println("fail to read ReviewDB");
        }

        return;
    }

    public ArrayList<Object> readDB(String tablename) {
    	
    	try {
            File f = new File("/Users/kimseojin/git/AlbaMan/.git/AlbaMan/src/main/java/ReviewDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f, true)); // true 추가해야 이어쓰기 가능
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
                Review review = new Review();
                String[] info = line.split(" ");
                review.setEnterpriseId(info[0]);
                review.setIndividualId(info[1]);
                review.setReview(info[2]);

                reviewList.add(question);
            }
            bufferedReader.close();

        } catch (Exception e){

        }
    	
        return reviewList;
    }

}