package com.api.library.controllers;

import com.api.library.dtos.BookRecordDTO;
import com.api.library.entities.Book;
import com.api.library.repositories.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;


    @PostMapping("/new-books")
    public ResponseEntity<Book> saveNewBook(@RequestBody @Valid BookRecordDTO bookRecordDTO){
        var book = new Book();
        BeanUtils.copyProperties(bookRecordDTO, book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookRepository.save(book));
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookRepository.findAll());
    }
}
