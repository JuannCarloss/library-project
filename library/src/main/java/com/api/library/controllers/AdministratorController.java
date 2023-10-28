package com.api.library.controllers;

import com.api.library.dtos.AdministratorRecordDTO;
import com.api.library.entities.Administrator;
import com.api.library.repositories.AdministratorRepository;
import com.api.library.services.AdministratorService;
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
    AdministratorService administratorService;

    @PostMapping
    public ResponseEntity<Administrator> saveNewAdm(@RequestBody @Valid AdministratorRecordDTO administratorRecordDTO){
        var adm = new Administrator();
        BeanUtils.copyProperties(administratorRecordDTO, adm);
        return ResponseEntity.status(HttpStatus.CREATED).body(administratorService.saveNewAdm(adm));
    }
}
