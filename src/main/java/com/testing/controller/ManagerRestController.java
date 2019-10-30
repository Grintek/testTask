package com.testing.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.testing.domain.Answer;
import com.testing.domain.Question;
import com.testing.domain.View;
import com.testing.reposytory.QuestionRepository;
import com.testing.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quetions")
public class ManagerRestController {

    private final QuestionService questionService;

    @Autowired
    public ManagerRestController(QuestionService questionService, QuestionRepository qr) {
        this.questionService = questionService;
    }

    @GetMapping
    @JsonView(View.Description.class)
    public List<Question> questionList(){
        return questionService.getQuestions();
    }

    @PostMapping
    public void addQuestion(@RequestBody Question question){
        questionService.createQuestion(question);
    }

    @DeleteMapping("/{id}")
    public void removeQuestion(@PathVariable("id") Long id){
        questionService.deleteById(id);
    }

    @GetMapping("/{id}")
    @JsonView(View.Answer.class)
    public Question question(@PathVariable("id") Long id){
        return questionService.getQuestion(id);
    }
    @PutMapping("/{id}")
    public void updateQuestion(@PathVariable("id") Long id, @RequestBody Question question){

    }

    @PostMapping("/{id}/answer")
    public void addAnswer(@PathVariable("id")Long id, @RequestBody Answer answer){
        questionService.addAnswer(id, answer);
    }

}
