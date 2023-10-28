package com.api.library.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class Person extends EntityID{

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "cpf", unique = true, nullable = false)
    private String documentCPF;

    @Column(name = "telefone", unique = true, nullable = false)
    private String phoneNumber;

}
