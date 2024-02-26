package com.api.library.services;


import com.api.library.enterprise.ValidationException;
import com.api.library.entities.Administrator;
import com.api.library.repositories.AdministratorRepository;
import com.sun.jdi.connect.VMStartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public void validateEntries(Administrator administrator){
        if (administratorRepository.findByDocumentCPF(administrator.getDocumentCPF()) != null){
            throw new ValidationException("cpf inválido");
        }
        if (administratorRepository.findByHiringCode(administrator.getHiringCode()) != null){
            throw new ValidationException("matrícula ja cadastrada");
        }
        if (administratorRepository.findByPhoneNumber(administrator.getPhoneNumber()) != null){
            throw new ValidationException("número inválido ou já cadastrado");
        }
        if (administratorRepository.findByEmail(administrator.getEmail()) != null){
            throw new ValidationException("email inválido ou ja cadastrado");
        }
    }

    public Administrator saveNewAdm (Administrator administrator){
        validateEntries(administrator);
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
            validateEntries(administrator);
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
