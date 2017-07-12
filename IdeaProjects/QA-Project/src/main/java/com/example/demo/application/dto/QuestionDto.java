package com.example.demo.application.dto;

import java.util.Date;
import java.util.List;

/**
 * A class for generating a DTO-object for the entity 'question'.
 * The generated object houses all necessary attributtes of an question-object
 * and provides getter- and setter-methodes for this attributes.
 */
public class QuestionDto {
    private Long id;
    private String title;
    private String text;
    private String date;
    private UserDto questioner;
    private boolean solved;
    private List<AnswerDto> answers;

    /**
     * A constructor for a QuestionDto-object.
     *
     * @param id the id of the converted question-object.
     * @param title the title of the converted question-object.
     * @param text the text of the converted question-object.
     * @param date the date of the converted question-object.
     * @param questioner the questioner of the converted question-object.
     * @param solved the solved-flag of the converted question-object.
     * @param answers the list of answers of the converted question-object.
     */
    public QuestionDto(Long id, String title, String text, Date date, UserDto questioner, boolean solved, List<AnswerDto> answers) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date.toString();
        this.questioner = questioner;
        this.solved = solved;
        this.answers = answers;
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

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date.toString();
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
