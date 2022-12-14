package controller;

import java.util.ArrayList;

import boundary.DBBoundary;
import model.FAQ;

public class FAQController extends DBBoundary {

    ArrayList<FAQ> faq = new ArrayList<FAQ>();

    public static void addToFAQ(String question, String answer) {
        System.out.println("FAQController - addToFAQ() visited");

        FAQ newFAQ = new FAQ(question, answer);
        saveFAQDB(newFAQ);
        System.out.println("FAQ 등록 성공");
    }

    public static ArrayList<FAQ> getFAQList() {
        System.out.println("FAQController - getFAQList() visited");
        ArrayList<FAQ> faq = readFAQDB();
        return faq;
    }
}