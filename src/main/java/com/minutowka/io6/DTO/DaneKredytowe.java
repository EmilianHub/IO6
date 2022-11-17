package com.minutowka.io6.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DaneKredytowe {

    private Long id;

    private LocalDateTime version;

    private String nrKonta;

    private Double zarobki;

    private Double wydatki;

    private Uzytkownik uzytkownik;
}
