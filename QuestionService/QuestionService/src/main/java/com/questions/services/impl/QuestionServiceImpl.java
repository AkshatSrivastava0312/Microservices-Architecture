package com.questions.services.impl;

import com.questions.entities.Question;
import com.questions.repositories.QuestionRepository;
import com.questions.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

   private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestion(long questionId) {
        return questionRepository.findById(questionId).orElseThrow(
                ()-> new RuntimeException("No Question Found")
        );
    }

    @Override
    public List<Question> getQuestionsOfQuiz(long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
