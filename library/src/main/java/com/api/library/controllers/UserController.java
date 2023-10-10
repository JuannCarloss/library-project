package com.api.library.controllers;

import com.api.library.dtos.UserRecordDTO;
import com.api.library.entities.User;
import com.api.library.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/new-users")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRecordDTO userRecordDTO){
        var user = new User();
        BeanUtils.copyProperties(userRecordDTO, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> listAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }
}
