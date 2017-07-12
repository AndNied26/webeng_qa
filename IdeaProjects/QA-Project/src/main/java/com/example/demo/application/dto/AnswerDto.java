package com.example.demo.application.dto;

import java.util.Date;

/**
 * A class for generating a DTO-object for the entity 'answer'.
 * The generated object houses all necessary attributtes of an answer-object
 * and provides getter- and setter-methodes for this attributes.
 */
public class AnswerDto {

    private long id;
    private String text;
    private String date;
    private UserDto answerer;
    private boolean accepted;

    /**
     * A constructor for an AnswerDto-object.
     *
     * @param id the id of the converted answer-object.
     * @param text the text of the converted answer-object.
     * @param date the date of the converted answer-object.
     * @param answerer the answerer of the converted answer-object.
     * @param accepted the accepted-flag of the converted answer-object.
     */
    public AnswerDto(long id, String text, Date date, UserDto answerer, boolean accepted) {
        this.id = id;
        this.text = text;
        this.date = date.toString();
        this.answerer = answerer;
        this.accepted = accepted;
    }


    /*
     * All setter- and getter-methodes needed to manage all attributes.
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date.toString();
    }

    public UserDto getAnswerer() {
        return answerer;
    }

    public void setAnswerer(UserDto answerer) {
        this.answerer = answerer;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
