package com.api.library.controllers;

import com.api.library.dtos.AdministratorRecordDTO;
import com.api.library.entities.Administrator;
import com.api.library.entities.LoanBooks;
import com.api.library.repositories.AdministratorRepository;
import com.api.library.services.AdministratorService;
import com.api.library.services.LoanBooksService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administrators")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private LoanBooksService loanBooksService;

    @PostMapping
    public ResponseEntity<Administrator> saveNewAdm(@RequestBody @Valid AdministratorRecordDTO administratorRecordDTO){
        var adm = new Administrator();
        BeanUtils.copyProperties(administratorRecordDTO, adm);
        Administrator save = administratorService.saveNewAdm(adm);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }
    @PostMapping("/loans")
    public ResponseEntity saveNewLoan(@RequestBody @Valid LoanBooks loanBooks) throws Exception {
        LoanBooks save = loanBooksService.saveNewLoan(loanBooks);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }
}
