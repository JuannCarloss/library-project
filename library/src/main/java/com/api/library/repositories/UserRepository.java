package com.api.library.repositories;


import com.api.library.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByPhoneNumber(String phoneNumber);
    public User findByEmail(String email);
    public User findByDocumentCpf(String documentCPF);
}
