package controller;

import java.util.ArrayList;

import model.FAQ;

public class FAQController {

    ArrayList<FAQ> faq = new ArrayList<FAQ>();

    public static void addToFAQ(String Question, String Answer) {
    	FAQ newFAQ = new FAQ(Question, Answer); // 생성
    	
    	faq.add(newFAQ);
    	saveDB(newFAQ);
        return;
    }

    public static ArrayList<FAQ> getFAQList() {
    	ArrayList<FAQ> FAQList = readDB("FAQList");
    	
        // return faq;
        return FAQList;
    }

    public void saveDB(Object o) {
        return;
    }

    public ArrayList<Object> readDB(String tablename) {
        return null;
    }

    public Object readDb(String dbname) {
        return null;
    }
}
