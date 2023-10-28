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

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public Administrator saveNewAdm (Administrator administrator){
        return administratorRepository.save(administrator);
    }

}
