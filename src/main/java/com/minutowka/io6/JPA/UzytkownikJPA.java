package com.minutowka.io6.JPA;

import lombok.*;

import javax.persistence.*;
@Builder
@Table(name = "uzytkownicy")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
