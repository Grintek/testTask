package com.testing.domain;

import com.fasterxml.jackson.annotation.JsonView;
import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.ID.class)
    private Long id;
    @NotNull
    @JsonView(View.Answer.class)
    private String name;

    @Column(nullable = false)
    @JsonView(View.Answer.class)
    private Boolean correct;

    public Answer() {
    }

    public Answer(String name, Boolean correct) {
        this.name = name;
        this.correct = correct;
    }

    @ManyToOne()
    private Question question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
