package com.yugi.quiz_app.services;

import java.util.List;

import com.yugi.quiz_app.Entities.questions;

public interface dataAcessService {
    public List<questions> getAllQuestions();

    public void addQuestion(questions quiz_question);

    public void updateQuestion(questions updated_Question);

    public void deleteQuestion(int id);

    public List<questions> findQuestionsByCategory(String category);

    public List<questions> findRandomQuestions(String category, int size);
}
