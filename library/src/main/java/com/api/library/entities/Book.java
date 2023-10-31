package com.api.library.entities;

import com.api.library.enums.Availability;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "books")
@Getter
@Setter
public class Book  extends EntityID{

    @Column(name = "nome", nullable = false)
    private String name;
    @Column(name = "autor", nullable = false)
    private String autor;
    @Column(name = "editora", nullable = false)
    private String publisher;
    @Column(name = "disponibilidade", nullable = false)
    @Enumerated(EnumType.STRING)
    private Availability availability;

    public Book(){
        this.availability = Availability.AVAILABLE;
    }
}
