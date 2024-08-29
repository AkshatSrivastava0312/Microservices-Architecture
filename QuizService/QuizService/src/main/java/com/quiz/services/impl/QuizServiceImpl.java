package com.quiz.services.impl;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    QuizRepository quizRepository;
    QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getQuiz() {

        List<Quiz> quizzes = quizRepository.findAll();

        return quizzes.stream().map(quiz ->
                {
                quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
                return quiz;
                }
        ).collect(Collectors.toList());

    }

    @Override
    public Quiz getQuiz(long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("No Quiz Found"));

        quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));

        return quiz;
    }

    @Override
    public void deleteQuiz(long id) {
         quizRepository.deleteById(id);
    }
}
