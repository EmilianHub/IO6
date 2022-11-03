package com.minutowka.io6.JPA;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "dane_kredytowe")
public class DaneKredytoweJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nr_konta")
    private String nrKonta;

    @Column
    private Double zarobki;

    @Column
    private Double wydatki;

    @OneToOne
    @JoinColumn(name = "id_uzyt")
    private UzytkownicyJPA uzytkownik;
}
