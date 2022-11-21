package com.minutowka.io6.JPA;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Version
    private LocalDateTime version;

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
