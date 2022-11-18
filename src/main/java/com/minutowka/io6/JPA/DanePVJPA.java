package com.minutowka.io6.JPA;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "dane_uzyt")
@NoArgsConstructor
public class DanePVJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nr_dowodu")
    private String nrDowodu;
    @Column
    private Long pesel;
    @OneToOne(cascade ={CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "id")
    private UzytkownikJPA uzytkownik;
}
