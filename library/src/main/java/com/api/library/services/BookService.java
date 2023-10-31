package com.api.library.services;

import com.api.library.entities.Book;
import com.api.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveNewBook(Book book){
        return bookRepository.save(book);
    }
}
