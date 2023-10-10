package com.api.library.controllers;

import com.api.library.dtos.AdministratorRecordDTO;
import com.api.library.entities.Administrator;
import com.api.library.repositories.AdministratorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministratorController {

    @Autowired
    AdministratorRepository administratorRepository;

    @PostMapping("/new-adm")
    public ResponseEntity<Administrator> saveNewAdm(AdministratorRecordDTO administratorRecordDTO){
        var adm = new Administrator();
        BeanUtils.copyProperties(administratorRecordDTO, adm);
        return ResponseEntity.status(HttpStatus.CREATED).body(administratorRepository.save(adm));
    }
}
