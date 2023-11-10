package com.api.library.services;

import com.api.library.entities.Book;
import com.api.library.enums.Availability;
import com.api.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveNewBook(Book book){
        return bookRepository.save(book);
    }

    public void updateStatus(Long id) throws Exception{
        Optional<Book> book0 = bookRepository.findById(id);
        if (book0.isPresent()) {
            var book = book0.get();
            if (book.getAvailability() == Availability.AVAILABLE){
                book.setAvailability(Availability.UNAVAILABLE);
                bookRepository.save(book);
            }
            }else {
            throw new Exception("livro não existe no banco de dados");
        }

    }
}
