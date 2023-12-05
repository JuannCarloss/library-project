package com.api.library.services;

import com.api.library.enterprise.ValidationException;
import com.api.library.entities.LoanBooks;
import com.api.library.entities.User;
import com.api.library.enums.Availability;
import com.api.library.repositories.LoanBooksRepository;
import com.api.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoanBooksRepository loanBooksRepository;

    public User saveNewUser(User user){

        if (userRepository.findByPhoneNumber(user.getPhoneNumber()) != null){
            throw new ValidationException("Telefone ja cadastrado na abse de dados!");
        }

        if (userRepository.findByEmail(user.getEmail()) != null){
            throw new ValidationException("Email ja cadastrado na base de dados!");
        }

        if (userRepository.findByDocumentCpf(user.getDocumentCPF()) != null){
            throw new ValidationException("CPF ja cadastrado na base de dados!");
        }

        return userRepository.save(user);
    }

    public List<User> listAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User changed){
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()){
            var user = optional.get();
            user.setName(changed.getName());
            user.setEmail(changed.getEmail());
            user.setDocumentCPF(changed.getDocumentCPF());
            user.setPhoneNumber(changed.getPhoneNumber());
            return userRepository.save(user);
        }else{
            throw new ValidationException("Usuario não existe na base de dados!");
        }
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public void updateStatus(Long id){
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            var user = optional.get();
            if (user.getAvailability() == Availability.AVAILABLE){
                user.setAvailability(Availability.UNAVAILABLE);
                userRepository.save(user);
            }

            } else {
            throw new ValidationException("usuário não existe na base de dados!");
        }
    }

    public LoanBooks returnBook(Long loanID){
        Optional<LoanBooks> optional = loanBooksRepository.findById(loanID);
            if (optional.isPresent()){
                var loan = optional.get();
                if (loan.getUser().getAvailability() == Availability.UNAVAILABLE &&
                    loan.getBook().getAvailability() == Availability.UNAVAILABLE) {
                    loan.getUser().setAvailability(Availability.AVAILABLE);
                    loan.getBook().setAvailability(Availability.AVAILABLE);
                    loan.setDevolutionDate(LocalDateTime.now());
                    return loanBooksRepository.save(loan);
                }else{
                    throw new ValidationException("Usuário não tem nenhum livro emprestado!");
                }
            }else {
                throw new ValidationException("Empréstimo não cadastrado na base de dados!");
            }
    }
}
