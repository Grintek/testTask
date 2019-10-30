package com.testing.service.impl;

import com.testing.domain.Answer;
import com.testing.domain.Question;
import com.testing.reposytory.QuestionRepository;
import com.testing.service.QuestionService;
import javassist.tools.rmi.RemoteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }

    @Override
    public void createQuestion(Question question){
        if(question.getDescription() != null){
            questionRepository.save(question);
        }
    }

    @Override
    public void updateQuestion(Long id, Question question){
        Question upQuestion = getQuestion(id);

        upQuestion.setDescription(question.getDescription());
        upQuestion.setAnswers(question.getAnswers());
        questionRepository.save(upQuestion);
    }

    @Override
    public Question getQuestion(Long id){
        return questionRepository.findById(id).orElseThrow(
                () -> new RemoteException("Question not found")
        );
    }

    @Override
    public void addAnswer(Long id, Answer answer){
        Question question = getQuestion(id);
        if(answer.getCorrect()){
            List<Answer> answers = question.getAnswers();
            answers.forEach(currentAnswer -> {currentAnswer.setCorrect(false);} );
        }
        question.addAnswer(answer);
        questionRepository.save(question);
    }

    @Override
    public void deleteById(Long id) {

    }
}
