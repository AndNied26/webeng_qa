package com.example.demo.persistence.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * A class for generating the entity question.
 * The generated object houses all necessary attributtes of an question-object
 * and provides getter- and setter-methodes for this attributes.
 */
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255)
    private String title;
    @Column(length = 2000)
    private String text;
    private Date date;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private List<Answer> answers;

    @ManyToOne
    private User questioner; //User ID

    //@Column(name = "isSolved")
    private boolean solved;

    /**
     * A constructor for a Question-object.
     *
     * @param title the title of the question.
     * @param text the text of the question.
     * @param questioner the questioner of the question.
     */
    public Question(String title, String text, User questioner) {
        this.title = title;
        this.text = text;
        this.date = new Date();
        this.answers = new LinkedList<>();
        this.questioner = questioner;
        this.solved = false;
    }

    /**
     * A standard-constructor for an Answer-object.
     */
    public Question() {

    }

    /*
     * All setter- and getter-methodes needed to manage all attributes.
     */
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
