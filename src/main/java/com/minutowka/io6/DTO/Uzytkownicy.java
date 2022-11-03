package com.minutowka.io6.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Uzytkownicy {
    private Long id;
    private String imie;
    private String nazwisko;
}
