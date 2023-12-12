package com.yugi.quiz_app.services;

import java.util.ArrayList;
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
        try {
            quiz newQuiz = new quiz();
            newQuiz.setCategory(category);
            newQuiz.setTitle(title);
            newQuiz.setQuestions(questionservice.findRandomQuestions(category, size));
            quizdao.save(newQuiz);
            return new ResponseEntity<>("quiz created", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<quiz> updateQuiz(quiz updated_Quiz) {
        try {
            quizdao.save(updated_Quiz);
            return new ResponseEntity<>(updated_Quiz, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(updated_Quiz, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteQuiz(quiz deleteQuiz) {
        try {
            quizdao.delete(deleteQuiz);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<quiz> getQuiz(String category, String title) {
        try {
            return new ResponseEntity<>(quizdao.findByTitleAndCategory(title, category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new quiz(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<quiz>> getAllQuiz() {
        try {
            return new ResponseEntity<List<quiz>>(quizdao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Integer> getTheScore(List<quizResponse> response, String title) {
        int score = 0, counter = 0;
        try {
            List<questions> quizQuestions = quizdao.findByTitle(title).getQuestions();
            for (questions questions : quizQuestions) {
                if (questions.getRightAnswer().equals(response.get(counter).getResponse())) {
                    score++;
                }
                counter++;
            }
            return new ResponseEntity<>(score, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
