package com.divyabharathi.empsat.Model;

import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;

public class Question {
    private int id;
    private String questionText;
    private ArrayList<OptionModel> options;
    private String answer;

    public Question(int id, String questionText, ArrayList<OptionModel> options, String answer) {
        this.id = id;
        this.questionText = questionText;
        this.options = options;
        this.answer = answer;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
