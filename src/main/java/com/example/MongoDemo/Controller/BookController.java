package com.example.MongoDemo.Controller;

import com.example.MongoDemo.Dto.AddBookDto;
import com.example.MongoDemo.Dto.BookDetailsDto;
import com.example.MongoDemo.Model.Book;
import com.example.MongoDemo.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/book")
@CrossOrigin(origins = "http://localhost:27017")
@RequiredArgsConstructor
public class BookController {
    @Autowired
    private final BookService bookservice;

    @PostMapping(value = "/save", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public BookDetailsDto saveBook(@RequestBody Book book){
        bookservice.addBook(book);
        BookDetailsDto bookdto = new BookDetailsDto(book.getName(), book.getLanguage());
        return bookdto;
    }

    @DeleteMapping (value = "/delete/{id}" , produces = APPLICATION_JSON_VALUE )
    public String deleteBook(@PathVariable ("id") Long id){
        bookservice.deleteBook(id);
        return "Deleted";
    }

    @GetMapping (value = "/findall" , produces = APPLICATION_JSON_VALUE )
    public List<Book> FindAllBooks(){
        List<Book> books =bookservice.getAll();
        return books;
    }

    @PutMapping (value = "/modify" , consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Book ModifyBook(@RequestBody Book book){
        Book book_Response =bookservice.updateBook(book);
        return book_Response;
    }

    @GetMapping (value = "/greeting/{message}" , produces = APPLICATION_JSON_VALUE )
    public String sendGreeting(@PathVariable("message") String message){
        return "Hello " +message+","+"\nWelcome to the REST-Based JSON Web Service";
    }
}
