package com.minutowka.io6.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class Pozyczki {
    private Long id;
    private Uzytkownicy uzytkownik;
    private Double kwotaPozyczki;
    private Double RRSO;
    private Double rata;
    private LocalDateTime dataZaciagnieciaPozyczki;
    private LocalDateTime dataZakonczeniaPozyczki;

    @JsonCreator
    public Pozyczki(@JsonProperty("poczatekPozyczki") String rozpoczecie, @JsonProperty("zakonczeniePozyczki") String zakonczenie){
        this.dataZaciagnieciaPozyczki = LocalDateTime.parse(convertToLocalDateTime(rozpoczecie));
        this.dataZakonczeniaPozyczki = LocalDateTime.parse(convertToLocalDateTime(zakonczenie));
    }

    private String convertToLocalDateTime(String date){
        return date.replaceAll(" ", "T");
    }
}
