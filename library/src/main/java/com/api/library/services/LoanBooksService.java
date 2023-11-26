package com.api.library.services;

import com.api.library.enterprise.ValidationException;
import com.api.library.enums.Availability;
import com.api.library.repositories.LoanBooksRepository;
import com.api.library.entities.LoanBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public LoanBooks updateLoan(Long id, LoanBooks changed){
        Optional<LoanBooks> optional = repository.findById(id);
        if (optional.isPresent()){
            var loan = optional.get();
            loan.setLoanDate(changed.getLoanDate());
            loan.setBook(changed.getBook());
            loan.setDevolutionDate(changed.getDevolutionDate());
            loan.setUser(changed.getUser());
            loan.setAdm(changed.getAdm());
            return repository.save(loan);
        }else {
            throw new ValidationException("Empréstimo não existe na base de dados!");
        }
    }

    public LoanBooks saveNewLoan(LoanBooks loan){

        if (loan.getUser().getAvailability() == Availability.UNAVAILABLE){
            throw  new ValidationException("Usuário indisponível para empréstimo!");
        }

        if (loan.getBook().getAvailability() == Availability.UNAVAILABLE){
            throw  new ValidationException("Livro indisponível para empréstimo!");
        }

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
