package com.api.library.services;

import com.api.library.entities.User;
import com.api.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveNewUser(User user){
        return userRepository.save(user);
    }
}
