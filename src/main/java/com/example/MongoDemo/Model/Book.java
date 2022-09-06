package com.example.MongoDemo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    @Id
    private Long id;
    private String name;
    private String language;

    public Book(String name, String language) {
        this.name = name;
        this.language = language;
    }
}
