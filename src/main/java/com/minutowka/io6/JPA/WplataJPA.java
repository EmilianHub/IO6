package com.minutowka.io6.JPA;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "wplata")
public class WplataJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kwota_wplaty")
    private Double kwotaWplaty;

    @Column
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "id_poz")
    private PozyczkaJPA pozyczka;
}
