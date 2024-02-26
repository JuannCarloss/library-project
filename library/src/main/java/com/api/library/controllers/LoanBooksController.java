package com.api.library.controllers;


import com.api.library.entities.LoanBooks;
import com.api.library.services.LoanBooksService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanBooksController {

    @Autowired
    private LoanBooksService loanBooksService;

    @PostMapping
    public ResponseEntity saveNewLoan(@RequestBody @Valid LoanBooks loanBooks){
        LoanBooks save = loanBooksService.saveNewLoan(loanBooks);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping
    public ResponseEntity findAllLoans(){
        List<LoanBooks> loans = loanBooksService.findAllLoans();
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/{id}")
    public ResponseEntity findLoanById(@PathVariable("id") Long id){
        LoanBooks loan = loanBooksService.findLoanById(id);
        return ResponseEntity.ok(loan);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLoan(@PathVariable("id")Long id){
        loanBooksService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}
