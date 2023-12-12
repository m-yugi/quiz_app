package com.yugi.quiz_app.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.core.query.Criteria;

import com.yugi.quiz_app.Entities.questions;

public class questionRepositoryImpl implements questionRepository {
    @Autowired
    MongoTemplate mongo;

    @Override
    public List<questions> findRandomQuestions(String category, int size) {
        Aggregation aggregate = Aggregation.newAggregation(
                new MatchOperation(Criteria.where("category").is(category)),
                new SampleOperation(5));
        return mongo.aggregate(aggregate, questions.class, questions.class).getMappedResults();
    }

}
