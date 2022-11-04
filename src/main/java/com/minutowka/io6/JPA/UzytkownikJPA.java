package com.minutowka.io6.JPA;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
@Table(name = "uzytkownicy")
public class UzytkownikJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String imie;

    @Column
    private String nazwisko;

    @Column
    private String email;
    @Column
    private String haslo;
    @Column
    private String login;
}
