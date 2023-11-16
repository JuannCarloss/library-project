package com.api.library.controllers;

import com.api.library.dtos.BookRecordDTO;
import com.api.library.entities.Book;
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
    public ResponseEntity saveNewBook(@RequestBody @Valid BookRecordDTO bookRecordDTO){
        var book = new Book();
        BeanUtils.copyProperties(bookRecordDTO, book);
        Book save = bookService.saveNewBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping
    public ResponseEntity findAllBooks(){
        List<Book> books = bookService.findAllBooks();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        Book book = bookService.findBookById(id);
        return ResponseEntity.ok().body(book);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity updateBook(@PathVariable("id") Long id,@RequestBody Book changed){
        Book book = bookService.updateBook(id, changed);
        return ResponseEntity.ok().body(book);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
