package com.yugi.quiz_app.Dao;

import java.util.List;

import com.yugi.quiz_app.Entities.questions;

public interface questionRepository {
    public List<questions> findRandomQuestions(String category, int size);
}
