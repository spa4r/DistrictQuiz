package com.example.districtquiz.district;

public class Question {

    private String _id;
    private String question;
    private String reponse;

    public Question(String ID, String question, String reponse) {
        this.setID(ID);
        this.setQuestion(question);
        this.setReponse(reponse);
    }

    public String getID() {
        return this._id;
    }

    public void setID(String ID) {
        this._id = ID;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return this.reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

}
