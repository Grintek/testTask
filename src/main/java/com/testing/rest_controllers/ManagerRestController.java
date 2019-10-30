package com.testing.rest_controllers;

import com.testing.domain.Question;
import com.testing.repos.QuestionRepository;
import com.testing.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manager")
public class ManagerRestController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private QuestionRepository qr;

    @GetMapping
    public List<Question> questionList(){
        return managerService.getQuestion();
    }

    @PostMapping("/question")
    public void addQuestion(@RequestBody Question question){
        managerService.addQuestion(question);
    }
    @DeleteMapping("/question-{id}")
    public void removeQuestion(@PathVariable("id") Long id){
        qr.deleteById(id);
    }
    @GetMapping("/question/{id}")
    public Optional<Question> editQuestion(@PathVariable("id") Long id){
        return qr.findById(id);
    }

}
