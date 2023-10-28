package com.api.library.repositories;

import com.api.library.entities.LoanBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoanBooksRepository extends JpaRepository<LoanBooks, Long> {
}
