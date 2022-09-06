package com.example.MongoDemo.Repository;

import com.example.MongoDemo.Model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Long> {
}
