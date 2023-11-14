package com.api.library.controllers;

import com.api.library.dtos.UserRecordDTO;
import com.api.library.entities.LoanBooks;
import com.api.library.entities.User;
import com.api.library.repositories.UserRepository;
import com.api.library.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRecordDTO userRecordDTO){
        var user = new User();
        BeanUtils.copyProperties(userRecordDTO, user);
        User save = userService.saveNewUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PutMapping("/devolution/{id}")
    public ResponseEntity<LoanBooks> returnBook (@PathVariable Long id) throws Exception {
           return ResponseEntity.status(HttpStatus.OK).body(userService.returnBook(id));
    }

}
