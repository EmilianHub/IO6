package com.minutowka.io6.JPA;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pozyczki")
public class PozyczkiJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long kwota;
    @Column
    private Double rrso;
    @Column
    private Long rata;
    @Column
    private LocalDateTime data_pobrania;
    @Column
    private LocalDateTime data_konca;

    @ManyToOne
    @JoinColumn(name = "id_u")
    private UzytkownikJPA uzytkownik;
}
