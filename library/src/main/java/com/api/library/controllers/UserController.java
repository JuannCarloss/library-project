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
    public ResponseEntity saveUser(@RequestBody @Valid UserRecordDTO userRecordDTO){
        var user = new User();
        BeanUtils.copyProperties(userRecordDTO, user);
        User save = userService.saveNewUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping
    public ResponseEntity findAllUsers(){
        List<User> users = userService.listAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("{id}")
    public ResponseEntity userById(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/devolution/{id}")
    public ResponseEntity returnBook(@PathVariable Long id) throws Exception {
           return ResponseEntity.ok().body(userService.returnBook(id));
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity alterUser(@PathVariable("id") Long id, @RequestBody User user){
        User update = userService.updateUser(id, user);
        return ResponseEntity.ok().body(update);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
