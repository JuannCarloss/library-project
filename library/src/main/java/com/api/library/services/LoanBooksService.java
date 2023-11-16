package com.api.library.services;

import com.api.library.repositories.LoanBooksRepository;
import com.api.library.entities.LoanBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanBooksService {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private LoanBooksRepository repository;

    public LoanBooksService(LoanBooksRepository repository) {
        this.repository = repository;
    }

    public LoanBooks saveNewLoan(LoanBooks loan) throws Exception {
        userService.updateStatus(loan.getUser().getId());
        bookService.updateStatus(loan.getBook().getId());
        return repository.save(loan);
    }

    public List<LoanBooks> findAllLoans(){
        return repository.findAll();
    }

    public LoanBooks findLoanById(Long id){
        return repository.findById(id).orElse(null);
    }

    public void deleteLoan(Long id){
        repository.deleteById(id);
    }
}
