package com.api.library.repositories;

import com.api.library.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Administrator findByHiringCode(String hiringCode);
    Administrator findByDocumentCPF(String documentCPF);
    Administrator findByPhoneNumber(String phoneNumber);
    Administrator findByEmail(String email);
}
