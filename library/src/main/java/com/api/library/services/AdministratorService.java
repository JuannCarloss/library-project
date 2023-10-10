package com.api.library.services;


import com.api.library.entities.Book;
import com.api.library.entities.User;
import com.api.library.repositories.AdministratorRepository;
import com.api.library.repositories.BookRepository;
import com.api.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdministratorRepository administratorRepository;

    @Autowired
    BookRepository bookRepository;

    public void lendBook(String userName, String admName, String bookName) throws Exception{

        var book = new Book();
        var user = new User();
        if (book.getAvailable() && user.getAvailableToGetBook()){
            userRepository.findByName(userName);
            administratorRepository.findByName(admName);
            bookRepository.findByName(bookName);
            book.setAvailable(false);
        } else if(!book.getAvailable() && user.getAvailableToGetBook()){

        }
    }

}
