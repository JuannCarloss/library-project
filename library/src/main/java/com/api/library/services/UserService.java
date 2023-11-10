package com.api.library.services;

import com.api.library.entities.User;
import com.api.library.enums.Availability;
import com.api.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveNewUser(User user){
        return userRepository.save(user);
    }

    public void updateStatus(Long id) throws Exception{
        Optional<User> user0 = userRepository.findById(id);
        if (user0.isPresent()) {
            var user = user0.get();
            if (user.getAvailability() == Availability.AVAILABLE){
                user.setAvailability(Availability.UNAVAILABLE);
                userRepository.save(user);
            }
        }else {
            throw new Exception("usuário não existe na base de dados");
        }
    }
}
