package com.yugi.quiz_app.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yugi.quiz_app.Entities.questions;
import com.yugi.quiz_app.services.dataAcessService;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("questions")
public class questonController {
    @Autowired
    private dataAcessService dataService;

    @GetMapping("/")
    public List<questions> getAllQuestions() {
        return dataService.getAllQuestions();
    }

    @PostMapping("/")
    public String addQuestion(@RequestBody questions quiz_question) {
        dataService.addQuestion(quiz_question);
        return "data saved";
    }

    @PutMapping("/")
    public questions updateQuestion(@RequestBody questions updated_Question) {
        dataService.updateQuestion(updated_Question);
        return updated_Question;
    }

    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable int id) {
        dataService.deleteQuestion(id);
        return "Question deleted";
    }

    @GetMapping("/category/{category}")
    public List<questions> findQuestionsByCategory(@PathVariable String category) {
        return dataService.findQuestionsByCategory(category);
    }

    @GetMapping("/test/{category}/{size}")
    public List<questions> findRandomQuestions(@PathVariable String category, @PathVariable int size) {
        return dataService.findRandomQuestions(category, size);
    }

}
