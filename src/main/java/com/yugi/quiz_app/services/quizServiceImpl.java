package com.yugi.quiz_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yugi.quiz_app.Dao.quizDao;
import com.yugi.quiz_app.Entities.questions;
import com.yugi.quiz_app.Entities.quiz;
import com.yugi.quiz_app.Entities.quizResponse;

@Service
public class quizServiceImpl implements quizService {
    @Autowired
    private quizDao quizdao;

    @Autowired
    private dataAcessService questionservice;

    @Override
    public ResponseEntity<String> createQuiz(String category, String title, int size) {
        quiz newQuiz = new quiz();
        newQuiz.setCategory(category);
        newQuiz.setTitle(title);
        newQuiz.setQuestions(questionservice.findRandomQuestions(category, size));
        quizdao.save(newQuiz);
        return new ResponseEntity<>("quiz created", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<quiz> updateQuiz(quiz updated_Quiz) {
        quizdao.save(updated_Quiz);
        return new ResponseEntity<>(updated_Quiz, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteQuiz(quiz deleteQuiz) {
        quizdao.delete(deleteQuiz);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<quiz> getQuiz(String category, String title) {
        return new ResponseEntity<>(quizdao.findByTitleAndCategory(title, category), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<quiz>> getAllQuiz() {
        return new ResponseEntity<List<quiz>>(quizdao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Integer> getTheScore(List<quizResponse> response, String title) {
        int score = 0, counter = 0;
        List<questions> quizQuestions = quizdao.findByTitle(title).getQuestions();
        for (questions questions : quizQuestions) {
            if (questions.getRightAnswer().equals(response.get(counter).getResponse())) {
                score++;
            }
            counter++;
        }
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
