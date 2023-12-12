package com.yugi.quiz_app.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.yugi.quiz_app.Entities.quiz;
import com.yugi.quiz_app.Entities.quizResponse;

public interface quizService {
    public ResponseEntity<String> createQuiz(String category, String title, int size);

    public ResponseEntity<quiz> updateQuiz(quiz updated_Quiz);

    public ResponseEntity<String> deleteQuiz(quiz deleteQuiz);

    public ResponseEntity<quiz> getQuiz(String category, String title);

    public ResponseEntity<List<quiz>> getAllQuiz();

    public ResponseEntity<Integer> getTheScore(List<quizResponse> response, String title);
}
