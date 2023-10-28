package com.api.library.repositories;

import com.api.library.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    void findByName(String name);
    void findByHiringCode(String hiringCode);
    void findByDocumentCPF(String documentCPF);
}
