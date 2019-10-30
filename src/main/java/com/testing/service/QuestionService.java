package com.testing.service;

import com.testing.domain.Answer;
import com.testing.domain.Question;

import java.util.List;


public interface QuestionService {

    List<Question> getQuestions();

    Question createQuestion(Question question);

    Question updateQuestion(Long id, Question question);

    Question getQuestion(Long id);

    Question addAnswer(Long id, Answer answer);

    void deleteById(Long id);
}
