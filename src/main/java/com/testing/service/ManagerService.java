package com.testing.service;

import com.testing.domain.Question;
import com.testing.repos.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

@Service
public class ManagerService {

    @Autowired
    private QuestionRepository qr;

    public List<Question> getQuestion(){
        return qr.findAll();
    }

    public void addQuestion(Question question){
        if(question.getQuestion() != null){
            qr.save(question);
        }
    }
}
