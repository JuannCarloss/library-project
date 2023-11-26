package com.api.library.services;

import com.api.library.enterprise.ValidationException;
import com.api.library.entities.Book;
import com.api.library.enums.Availability;
import com.api.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveNewBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book findBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public Book updateBook(Long id, Book changed){
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()){
            var book = optional.get();
            book.setName(changed.getName());
            book.setAutor(changed.getAutor());
            book.setPublisher(changed.getPublisher());
            return bookRepository.save(book);
        }else {
            throw new ValidationException("Livro não existe na base de dados!");
        }

    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public void updateStatus(Long id){
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            var book = optional.get();
            if (book.getAvailability() == Availability.AVAILABLE){
                book.setAvailability(Availability.UNAVAILABLE);
                bookRepository.save(book);
            }

            }else {
            throw new ValidationException("livro não existe no banco de dados");
        }

    }
}
