package com.api.library.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "administrators")
@Getter
@Setter
public class Administrator extends Person{

    @Column(name = "codigo_contratacao", unique = true, nullable = false)
    private String hiringCode;

}
