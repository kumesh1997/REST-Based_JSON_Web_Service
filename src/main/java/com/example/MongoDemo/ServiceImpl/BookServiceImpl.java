package com.example.MongoDemo.ServiceImpl;

import com.example.MongoDemo.Exception.CustomException;
import com.example.MongoDemo.Model.Book;
import com.example.MongoDemo.Repository.BookRepository;
import com.example.MongoDemo.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private final BookRepository bookrepo;

    @Override
    public void addBook(Book book) {
        bookrepo.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookrepo.deleteById(id);
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = bookrepo.findAll();
        return books;
    }

    @Override
    public Book updateBook(Book book) {
        Book old_Book = bookrepo.findById(book.getId()).orElseThrow(() -> new CustomException("Book Was Not Found"));
        old_Book.setName(book.getName());
        old_Book.setLanguage(book.getLanguage());
        bookrepo.save(old_Book);
        return old_Book;
    }
}
