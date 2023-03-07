package com.divyabharathi.empsat.Model;

import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;

public class Question {
    private int id;
    private String questionText;
    private ArrayList<OptionModel> options;
    private int answer;
    private String questionType;
    private String imageAsset;

    public Question(int id, String questionText, ArrayList<OptionModel> options, int answer, String questionType, String imageAsset) {
        this.id = id;
        this.questionText = questionText;
        this.options = options;
        this.answer = answer;
        this.questionType = questionType;
        this.imageAsset = imageAsset;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public ArrayList<OptionModel> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<OptionModel> options) {
        this.options = options;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getImageAsset() {
        return imageAsset;
    }

    public void setImageAsset(String imageAsset) {
        this.imageAsset = imageAsset;
    }
}
