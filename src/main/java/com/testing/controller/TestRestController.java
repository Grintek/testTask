package com.testing.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.testing.DTO.CountSuccess;
import com.testing.DTO.Data;
import com.testing.DTO.Result;
import com.testing.domain.Question;
import com.testing.domain.View;
import com.testing.service.QuestionService;
import com.testing.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Question> testQuestion(){
        return questionService.getQuestions();
    }

    @PostMapping
    public Result resultTest(@RequestBody Data data){
        return questionService.resultTest(data);
    }
}
