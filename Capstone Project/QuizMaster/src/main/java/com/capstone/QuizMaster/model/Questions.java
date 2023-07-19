package com.capstone.QuizMaster.model;

import jakarta.persistence.*;
@Entity
@Table(name = "questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "category")
    private String langCategory;
    @Column(name = "level")
    private String level;
    @Column(name = "title", length = 1200)
    private String qTitle;
    @Column(name = "optionA", length = 1200)
    private String optionA;
    @Column(name = "optionB",length = 1200)
    private String optionB;
    @Column(name = "optionC", length = 1200)
    private String optionC;
    @Column(name = "optionD",length = 1200)
    private String optionD;
    @Column(name = "answer")
    private String answer;

    public Questions() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLangCategory() {
        return langCategory;
    }

    public void setLangCategory(String langCategory) {
        this.langCategory = langCategory;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getqTitle() {
        return qTitle;
    }

    public void setqTitle(String qTitle) {
        this.qTitle = qTitle;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", langCategory='" + langCategory + '\'' +
                ", level='" + level + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", qTitle='" + qTitle + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
