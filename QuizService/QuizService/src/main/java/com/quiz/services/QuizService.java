package com.quiz.services;


import com.quiz.entities.Quiz;

import java.util.List;

public interface QuizService {

    Quiz addQuiz(Quiz quiz);
    List<Quiz> getQuiz();
    Quiz getQuiz(long id);
    void deleteQuiz(long id);

}
