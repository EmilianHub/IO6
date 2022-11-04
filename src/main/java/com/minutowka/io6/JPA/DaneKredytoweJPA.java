package com.minutowka.io6.JPA;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@Table(name = "dane_kredytowe")
@AllArgsConstructor
@NoArgsConstructor
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
    private UzytkownikJPA uzytkownikJPA;
}
