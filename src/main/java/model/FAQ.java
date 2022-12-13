package model;

public class FAQ {

    private String question;
    private String answer;

    public FAQ() { }

    public FAQ(String Question, String Answer) {
        this.question = Question;
        this.answer = Answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}