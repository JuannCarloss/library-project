package com.api.library.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "loans")
public class LoanBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String user;
    private String adm;
    private String bookName;
    private String bookBarcode;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAdm() {
        return adm;
    }

    public void setAdm(String adm) {
        this.adm = adm;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookBarcode() {
        return bookBarcode;
    }

    public void setBookBarcode(String bookBarcode) {
        this.bookBarcode = bookBarcode;
    }
}
