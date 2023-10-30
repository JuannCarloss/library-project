package com.api.library.entities;

import com.api.library.enums.Availability;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "users")
@Getter
@Setter
public class User extends Person {

    @Column(name = "disponibilidade", nullable = false)
    @Enumerated(EnumType.STRING)
    private Availability availability;

    public User(){
        this.availability = Availability.AVAILABLE;
    }

}
