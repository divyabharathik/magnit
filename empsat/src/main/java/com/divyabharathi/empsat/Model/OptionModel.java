package com.divyabharathi.empsat.Model;

public class OptionModel {
    private String optionDescription;
    private int score;

    public OptionModel(String optionDescription, int score) {
        this.optionDescription = optionDescription;
        this.score = score;
    }

    public String getOptionDescription() {
        return optionDescription;
    }

    public void setOptionDescription(String optionDescription) {
        this.optionDescription = optionDescription;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
