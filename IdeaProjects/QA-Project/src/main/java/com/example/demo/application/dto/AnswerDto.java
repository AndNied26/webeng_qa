package com.example.demo.application.dto;

import com.example.demo.persistence.entity.Question;
import com.example.demo.persistence.entity.User;

import java.util.Date;

public class AnswerDto {


    private long id;
    private String text;
    private Date date;
    private UserDto answerer;
    private boolean accepted;

    public AnswerDto(long id, String text, Date date, UserDto answerer, boolean accepted) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.answerer = answerer;
        this.accepted = accepted;
    }

    public AnswerDto() {
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
