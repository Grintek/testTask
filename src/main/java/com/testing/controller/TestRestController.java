package com.testing.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.testing.domain.Question;
import com.testing.domain.View;
import com.testing.service.QuestionService;
import com.testing.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestRestController {

    private final QuestionService questionService;

    @Autowired
    public TestRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    @JsonView(View.Answer.class)
    public List<Question> testQuestion(){
        return questionService.getQuestions();
    }
}
