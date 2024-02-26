package com.api.library.controllers;

import com.api.library.entities.Administrator;
import com.api.library.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrators")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping
    public ResponseEntity saveNewAdm(@RequestBody Administrator administrator){
        Administrator save = administratorService.saveNewAdm(administrator);
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
}
