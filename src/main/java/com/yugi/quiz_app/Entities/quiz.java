package com.yugi.quiz_app.Entities;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "quiz")
public class quiz {
    @Id
    private String id;
    private String title;
    private String category;
    private List<questions> questions;
}
