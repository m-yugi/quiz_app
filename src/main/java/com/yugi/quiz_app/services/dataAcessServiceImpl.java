package com.yugi.quiz_app.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.yugi.quiz_app.Dao.questionDataDao;
import com.yugi.quiz_app.Entities.questions;

@Service
public class dataAcessServiceImpl implements dataAcessService {
    @Autowired
    questionDataDao questiondao;

    @Override
    public ResponseEntity<List<questions>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questiondao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> addQuestion(questions quiz_question) {
        try {
            questiondao.save(quiz_question);
            return new ResponseEntity<>("data saved", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<questions> updateQuestion(questions updated_Question) {
        try {
            questiondao.save(updated_Question);
            return new ResponseEntity<>(updated_Question, HttpStatus.OK);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return new ResponseEntity<>(updated_Question, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteQuestion(int id) {
        try {
            questiondao.deleteById(id);
            return new ResponseEntity<>("data deleted", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<questions>> findQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questiondao.findBycategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<questions> findRandomQuestions(String category, int size) {
        try {
            return questiondao.findRandomQuestions(category, size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
