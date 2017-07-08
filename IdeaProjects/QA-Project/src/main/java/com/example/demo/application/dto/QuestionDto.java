package com.example.demo.application.dto;






import com.example.demo.persistence.entity.Answer;
import com.example.demo.persistence.entity.User;

import java.util.Date;
import java.util.List;

public class QuestionDto {
    private Long id;
    private String title;
    private String text;
    private Date date;
    private UserDto questioner;
    private boolean solved;
    private List<AnswerDto> answers;

    public QuestionDto(Long id, String title, String text, Date date, UserDto questioner, boolean solved, List<AnswerDto> answers) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.questioner = questioner;
        this.solved = solved;
        this.answers = answers;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserDto getQuestioner() {
        return questioner;
    }

    public void setQuestioner(UserDto questioner) {
        this.questioner = questioner;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }
}
