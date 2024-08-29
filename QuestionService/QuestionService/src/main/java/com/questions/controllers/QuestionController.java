package com.questions.controllers;

import com.questions.entities.Question;
import com.questions.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/question")
public class QuestionController {

    QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // add question
    @PostMapping
    public Question createQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    // get all questions
    @GetMapping
    public List<Question> get(){
        return questionService.getQuestion();
    }

    // get specific question
    @GetMapping(path = "/{questionId}")
    public Question get(@PathVariable long questionId){
        return questionService.getQuestion(questionId);
    }

    // get questions by quizId
    @GetMapping(path = "/quiz/{quizId}")
    public List<Question> getAllFromQuiz(@PathVariable long quizId){
        return questionService.getQuestionsOfQuiz(quizId);
    }
}
