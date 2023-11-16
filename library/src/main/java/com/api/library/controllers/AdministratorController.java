package com.api.library.controllers;

import com.api.library.dtos.AdministratorRecordDTO;
import com.api.library.entities.Administrator;
import com.api.library.entities.LoanBooks;
import com.api.library.services.AdministratorService;
import com.api.library.services.LoanBooksService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrators")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private LoanBooksService loanBooksService;


    //administrators http verbs
    @PostMapping
    public ResponseEntity saveNewAdm(@RequestBody @Valid AdministratorRecordDTO administratorRecordDTO){
        var adm = new Administrator();
        BeanUtils.copyProperties(administratorRecordDTO, adm);
        Administrator save = administratorService.saveNewAdm(adm);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }
    @GetMapping
    public ResponseEntity findAllAdministrators(){
        List<Administrator> administrators = administratorService.findAllAdministrators();
        return ResponseEntity.ok().body(administrators);
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        Administrator administrator = administratorService.findById(id);
        return ResponseEntity.ok().body(administrator);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateAdministrator(@PathVariable("id") Long id,@RequestBody Administrator changed) throws Exception {
        Administrator adm = administratorService.updateAdministrator(id, changed);
        return ResponseEntity.ok().body(adm);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAdministrators(@PathVariable("id") Long id){
        administratorService.deleteAdministrator(id);
        return ResponseEntity.noContent().build();
    }
    //---------------------------------------------



    //loans http verbs
    @PostMapping("/loans")
    public ResponseEntity saveNewLoan(@RequestBody @Valid LoanBooks loanBooks) throws Exception {
        LoanBooks save = loanBooksService.saveNewLoan(loanBooks);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping("/loans")
    public ResponseEntity findAllLoans(){
        List<LoanBooks> loans = loanBooksService.findAllLoans();
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/loans/{id}")
    public ResponseEntity findLoanById(@PathVariable("id") Long id){
        LoanBooks loan = loanBooksService.findLoanById(id);
        return ResponseEntity.ok(loan);
    }

    @DeleteMapping("/loans/delete/{id}")
    public ResponseEntity deleteLoan(@PathVariable("id")Long id){
        loanBooksService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}
