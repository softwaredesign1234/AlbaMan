package controller;

import java.util.ArrayList;

import boundary.DBBoundary;
import model.FAQ;

public class FAQController {

    ArrayList<FAQ> faq = new ArrayList<FAQ>();
    public static DBBoundary dbManager;

    public void addToFAQ(String Question, String Answer) {
        return;
    }

    public ArrayList<FAQ> getFAQList() {
        return null;
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
