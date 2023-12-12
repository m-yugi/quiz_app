package com.yugi.quiz_app.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yugi.quiz_app.Entities.questions;
import java.util.List;

@Repository
public interface questionDataDao extends MongoRepository<questions, Integer>, questionRepository {
    public List<questions> findBycategory(String category);
}
