package com.api.library.repositories;


import com.api.library.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     User findByPhoneNumber(String phoneNumber);
     User findByEmail(String email);
     User findByDocumentCpf(String documentCPF);
}
