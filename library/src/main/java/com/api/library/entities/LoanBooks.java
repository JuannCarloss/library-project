package com.api.library.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "loans")
@Getter
@Setter
public class LoanBooks extends EntityID {

    @Column(name = "DataEmprestimo", nullable = false)
    private LocalDateTime loanDate;
    @Column(name = "DataDevolucao")
    private LocalDateTime devolutionDate;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "administrator_id", referencedColumnName = "id")
    private Administrator adm;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public LoanBooks(){
        this.loanDate = LocalDateTime.now();
    }

}
