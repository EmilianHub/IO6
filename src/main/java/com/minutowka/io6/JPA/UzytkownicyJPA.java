package com.minutowka.io6.JPA;

import javax.persistence.*;

@Entity
@Table(name = "uzytkownicy")
public class UzytkownicyJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String imie;

    @Column
    private String nazwisko;

    @Column
    private String email;
}
