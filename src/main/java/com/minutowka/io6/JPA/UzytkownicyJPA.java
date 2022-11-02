package com.minutowka.io6.JPA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UzytkownicyJPA {

    @Id
    private Long id;

    @Column
    private String imie;

    @Column
    private String nazwisko;

    @Column
    private String email;
}
