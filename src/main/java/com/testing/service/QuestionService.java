package com.testing.service;

import com.testing.DTO.CountSuccess;
import com.testing.DTO.Data;
import com.testing.DTO.Result;
import com.testing.domain.Answer;
import com.testing.domain.Question;

import java.util.List;


public interface QuestionService {

    List<Question> getQuestions();

    List<Question> createQuestion(Question question);

    Question updateQuestion(Long id, Question question);

    Question getQuestion(Long id);

    Question addAnswer(Long id, Answer answer);

    List<Question> deleteById(Long id);

    Result resultTest(Data data);
}
