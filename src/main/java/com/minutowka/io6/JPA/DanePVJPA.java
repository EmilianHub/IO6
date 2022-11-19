package com.minutowka.io6.JPA;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "dane_uzyt")
@NoArgsConstructor
@AllArgsConstructor
public class DanePVJPA {

    @Column(name = "nr_dowodu")
    private String nrDowodu;
    @Id
    @Column
    private Long pesel;


    @OneToOne(cascade ={CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "id")
    private UzytkownikJPA uzytkownik;
}
