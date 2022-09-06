package com.example.MongoDemo.Service;

import com.example.MongoDemo.Dto.AddBookDto;
import com.example.MongoDemo.Model.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
    void addBook(Book book);
    void deleteBook(Long id);
    List<Book> getAll();
    Book updateBook(Book book);
}
