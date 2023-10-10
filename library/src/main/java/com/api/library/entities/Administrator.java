package com.api.library.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "administrators")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String email;
    private String cpf;

}
