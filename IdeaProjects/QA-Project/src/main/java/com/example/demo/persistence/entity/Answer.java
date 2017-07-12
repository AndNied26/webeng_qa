package com.example.demo.persistence.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

/**
 * A class for generating the entity answer.
 * The generated object houses all necessary attributtes of an answer-object
 * and provides getter- and setter-methodes for this attributes.
 */
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 2000)
    private String text;
    private Date date;

    @ManyToOne
    private User answerer;


    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;


    private boolean accepted;

    /**
     * A constructor for an Answer-object.
     *
     * @param text the text of the answer.
     * @param answerer the answerer of the answer.
     * @param question the question, which this answer belongs to.
     */
    public Answer(String text, User answerer, Question question) {
        this.text = text;
        this.date = new Date();
        this.answerer = answerer;
        this.question = question;
        this.accepted = false;
    }

    /**
     * A standard-constructor for an Answer-object.
     */
    public Answer() {

    }


    /*
    * All setter- and getter-methodes needed to manage all attributes.
    */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setAnswerer(User answerer) {
        this.answerer = answerer;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public Question getQuestion() {
        return this.question;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public User getAnswerer() {
        return answerer;
    }
}
