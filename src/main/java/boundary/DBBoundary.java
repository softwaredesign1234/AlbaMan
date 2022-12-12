package boundary;

import model.*;

import javax.sql.DataSource;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBBoundary {

	ArrayList<WorkHistory> workHistoryList = new ArrayList<>();

	public void saveIndividualAccountDB(IndividualAccount individual)
    {
        List<String> individualInfo = new ArrayList<>();
        
        try {
            File f = new File("/Users/kimseojin/git/AlbaMan/.git/AlbaMan/src/main/java/IndividualAccountDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true)); // true 추가해야 이어쓰기 가능
            individualInfo.add(individual.getId()+" ");
            individualInfo.add(individual.getPassword()+" ");
            individualInfo.add(individual.getName()+" ");
            individualInfo.add(individual.getValid()+" ");
            individualInfo.add(individual.getIsActive()+" ");
            individualInfo.add(individual.getType()+" ");
            individualInfo.add(individual.getEmail()+" ");
            individualInfo.add(individual.getPhoneNumber()+" ");
            individualInfo.add(individual.getAge()+" ");
            individualInfo.add(individual.getGender()+" ");

            for (String info : individualInfo){
                bufferedWriter.write(info, 0, info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e){
        	System.out.println("fail to read IndividualAccountDB");
        }

        return;
    }
	
	public void saveWorkHistoryDB(WorkHistory workHistory)
	    {
	        List<String> workHistoryInfo = new ArrayList<>();
	        
	        try {
	            File f = new File("/Users/kimseojin/git/AlbaMan/.git/AlbaMan/src/main/java/WorkHistoryDB.txt");
	            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true)); // true 추가해야 이어쓰기 가능
	            workHistoryInfo.add(workHistory.getEnterpriseId()+" ");
	            workHistoryInfo.add(workHistory.getIndividualId()+" ");

	            for (String info : workHistoryInfo){
	                bufferedWriter.write(info, 0, info.length());
	            }
	            bufferedWriter.flush();
	            bufferedWriter.close();

	        } catch (Exception e){
	        	System.out.println("fail to read WorkHistoryDB");
	        }

	        return;
	    }
    
    public void saveReviewDB(Review review)
    {
        List<String> reviewInfo = new ArrayList<>();
        
        try {
            File f = new File("/Users/kimseojin/git/AlbaMan/.git/AlbaMan/src/main/java/ReviewDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true)); // true 추가해야 이어쓰기 가능
            reviewInfo.add(review.getEnterpriseId()+" ");
            reviewInfo.add(review.getIndividualId()+" ");
            reviewInfo.add(review.getRevew()+" ");

            for (String info : reviewInfo){
                bufferedWriter.write(info, 0, info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e){
        	System.out.println("fail to read ReviewDB");
        }

        return;
    }
    
    public void saveFAQDB(FAQ faq)
    {
        List<String> faqInfo = new ArrayList<>();
        
        try {
            File f = new File("/Users/kimseojin/git/AlbaMan/.git/AlbaMan/src/main/java/FAQDB.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true)); // true 추가해야 이어쓰기 가능
            faqInfo.add(faq.getQuestion()+" ");
            faqInfo.add(faq.getAnswer()+" ");

            for (String info : faqInfo){
                bufferedWriter.write(info, 0, info.length());
            }
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e){
        	System.out.println("fail to read FAQDB");
        }

        return;
    }
    
    public ArrayList<Object> readIndividualAccountDB() {
    	
    	try {
            File f = new File("/Users/kimseojin/git/AlbaMan/.git/AlbaMan/src/main/java/IndividualAccountDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
                IndividualAccount individual = new IndividualAccount();
                String[] info = line.split(" ");
                individual.setId(info[0]);
                individual.setPassword(info[1]);
                individual.setName(info[2]);
                individual.setValid(info[3]);
                individual.setIsActive(info[4]);
                individual.setType(info[5]);
                individual.setEmail(info[6]);
                individual.setPhoneNumber(info[7]);
                individual.setAge(info[8]);
                individual.setGender(info[9]);

                individualAccountList.add(individual);
            }
            bufferedReader.close();

        } catch (Exception e){

        }
    	
        return individualAccountList;
    }
    
    
    public ArrayList<Object> readWorkHistoryDB() {
    	
    	try {
            File f = new File("/Users/kimseojin/git/AlbaMan/.git/AlbaMan/src/main/java/WorHistoryDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
                WorkHistory workHistory = new WorkHistory();
                String[] info = line.split(" ");
                review.setEnterpriseId(info[0]);
                review.setIndividualId(info[1]);

                workHistoryList.add(workHistory);
            }
            bufferedReader.close();

        } catch (Exception e){

        }
    	
        return workHistoryList;
    }
    
    public ArrayList<Object> readReviewDB() {
    	
    	try {
            File f = new File("/Users/kimseojin/git/AlbaMan/.git/AlbaMan/src/main/java/ReviewDB.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String line = null;
            while((line = bufferedReader.readLine())!=null)
            {
                Review review = new Review();
                String[] info = line.split(" ");
                review.setEnterpriseId(info[0]);
                review.setIndividualId(info[1]);
                review.setReview(info[2]);

                reviewList.add(review);
            }
            bufferedReader.close();

        } catch (Exception e){

        }
    	
        return reviewList;
    }

}
