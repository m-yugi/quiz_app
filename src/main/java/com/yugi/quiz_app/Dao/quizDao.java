package com.yugi.quiz_app.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.yugi.quiz_app.Entities.quiz;

@Repository
public interface quizDao extends MongoRepository<quiz, String> {
    public quiz findByTitleAndCategory(String title, String category);

    public quiz findByTitle(String title);
}
