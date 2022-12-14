package model;

public class Review {

    private String enterpriseId;
    private String individualId;
    private String review;

    public Review() { }

    public Review(String enterpriseId, String individualId, String review) {

        this.enterpriseId = enterpriseId;
        this.individualId = individualId;
        this.review = review;

    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getIndividualId() {
        return individualId;
    }

    public void setIndividualId(String individualId) {
        this.individualId = individualId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}