package com.testing.service;

import com.testing.domain.Answer;
import com.testing.domain.Question;
import com.testing.reposytory.QuestionRepository;
import javassist.tools.rmi.RemoteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuestionService {

    List<Question> getQuestions();

    void createQuestion(Question question);

    void updateQuestion(Long id, Question question);

    Question getQuestion(Long id);

    void addAnswer(Long id, Answer answer);

    void deleteById(Long id);
}
