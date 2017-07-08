package com.example.demo.persistence.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String text;
    private Date date;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private List<Answer> answers;

    @ManyToOne
    private User questioner; // User ID

//    @Column(name = "isSolved")
    private boolean solved;


    public Question(String title, String text, User questioner) {
        this.title = title;
        this.text = text;
        this.date = new Date();
        this.answers = new LinkedList<>();
        this.questioner = questioner;
        this.solved = false;
    }

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public User getQuestioner() {
        return questioner;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }
}
