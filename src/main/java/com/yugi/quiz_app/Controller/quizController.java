package com.yugi.quiz_app.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.yugi.quiz_app.Entities.quiz;
import com.yugi.quiz_app.Entities.quizResponse;
import com.yugi.quiz_app.services.quizService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/quiz")
public class quizController {
    @Autowired
    private quizService quizservice;

    @GetMapping("/")
    public ResponseEntity<quiz> getQuiz(@RequestParam String title, @RequestParam String category) {
        return quizservice.getQuiz(category, title);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(
            @RequestParam String category,
            @RequestParam String title,
            @RequestParam int size) {
        return quizservice.createQuiz(category, title, size);
    }

    @PostMapping("/submit/{title}")
    public ResponseEntity<Integer> getTheScore(@RequestBody List<quizResponse> response, @PathVariable String title) {

        return quizservice.getTheScore(response, title);
    }

}
