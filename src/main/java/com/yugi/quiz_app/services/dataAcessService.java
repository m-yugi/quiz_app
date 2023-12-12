package com.yugi.quiz_app.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.yugi.quiz_app.Entities.questions;

public interface dataAcessService {
    public ResponseEntity<List<questions>> getAllQuestions();

    public ResponseEntity<String> addQuestion(questions quiz_question);

    public ResponseEntity<questions> updateQuestion(questions updated_Question);

    public ResponseEntity<String> deleteQuestion(int id);

    public ResponseEntity<List<questions>> findQuestionsByCategory(String category);

    public List<questions> findRandomQuestions(String category, int size);
}
