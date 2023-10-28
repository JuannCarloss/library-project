package com.api.library.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class EntityID {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(unique = true, nullable = false)
    private Long id;
}
