package com.api.library.controllers;

import com.api.library.dtos.BookRecordDTO;
import com.api.library.entities.Book;
import com.api.library.repositories.BookRepository;
import com.api.library.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping
    public ResponseEntity<Book> saveNewBook(@RequestBody @Valid BookRecordDTO bookRecordDTO){
        var book = new Book();
        BeanUtils.copyProperties(bookRecordDTO, book);
        Book save = bookService.saveNewBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

//    @GetMapping
//    public ResponseEntity<List<Book>> getAllBooks(){
//        return ResponseEntity.status(HttpStatus.OK).body();
//    }
}
