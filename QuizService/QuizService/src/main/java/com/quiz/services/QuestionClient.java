package com.quiz.services;

import com.quiz.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Question-Service")
public interface QuestionClient {

    @GetMapping(path = "/question/quiz/{quizId}")
    List<Question> getQuestionsOfQuiz(@PathVariable long quizId);

}

