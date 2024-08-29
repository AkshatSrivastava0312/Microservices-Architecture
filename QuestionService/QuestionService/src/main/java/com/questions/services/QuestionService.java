package com.questions.services;

import com.questions.entities.Question;

import java.util.List;

public interface QuestionService {

    Question addQuestion(Question question);
    List<Question> getQuestion();
    Question getQuestion(long questionId);
    List<Question> getQuestionsOfQuiz(long quizId);

}
