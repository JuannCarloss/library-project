package com.api.library.services;


import com.api.library.dtos.AdministratorRecordDTO;
import com.api.library.entities.Administrator;
import com.api.library.entities.Book;
import com.api.library.entities.User;
import com.api.library.repositories.AdministratorRepository;
import com.api.library.repositories.BookRepository;
import com.api.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public Administrator saveNewAdm (Administrator administrator){
        return administratorRepository.save(administrator);
    }

    public List<Administrator> findAllAdministrators(){
        return administratorRepository.findAll();
    }

    public Administrator findById(Long id){
        return administratorRepository.findById(id).orElse(null);
    }

    public Administrator updateAdministrator(Long id, Administrator changed)throws Exception{
        Optional<Administrator> optional = administratorRepository.findById(id);
        if (optional.isPresent()){
            var administrator = optional.get();
            administrator.setName(changed.getName());
            administrator.setEmail(changed.getEmail());
            administrator.setPhoneNumber(changed.getPhoneNumber());
            return administratorRepository.save(administrator);
        }else {
            throw new Exception("Administrador não existe na base de dados!");
        }
    }

    public void deleteAdministrator(Long id){
        administratorRepository.deleteById(id);
    }

}
