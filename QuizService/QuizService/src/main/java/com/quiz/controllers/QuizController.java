package com.quiz.controllers;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/quiz")
public class QuizController {

    QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // create a quiz
    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }

    // get all quiz
    @GetMapping
    public List<Quiz> get(){
        return quizService.getQuiz();
    }

    // get specific quiz
    @GetMapping(path = "/{id}")
    public Quiz get(@PathVariable Long id){
        return quizService.getQuiz(id);
    }

    // delete a quiz
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id){
        quizService.deleteQuiz(id);
    }

}
