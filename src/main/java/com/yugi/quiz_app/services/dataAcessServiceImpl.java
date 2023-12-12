package com.yugi.quiz_app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yugi.quiz_app.Dao.questionDataDao;
import com.yugi.quiz_app.Entities.questions;

@Service
public class dataAcessServiceImpl implements dataAcessService {
    @Autowired
    questionDataDao questiondao;

    @Override
    public List<questions> getAllQuestions() {
        return questiondao.findAll();
    }

    @Override
    public void addQuestion(questions quiz_question) {
        questiondao.save(quiz_question);
    }

    @Override
    public void updateQuestion(questions updated_Question) {
        questiondao.save(updated_Question);
    }

    @Override
    public void deleteQuestion(int id) {
        questiondao.deleteById(id);
    }

    @Override
    public List<questions> findQuestionsByCategory(String category) {
        return questiondao.findBycategory(category);
    }

    @Override
    public List<questions> findRandomQuestions(String category, int size) {
        return questiondao.findRandomQuestions(category, size);
    }
}
