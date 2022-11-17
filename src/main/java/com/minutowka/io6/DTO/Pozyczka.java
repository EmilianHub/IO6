package com.minutowka.io6.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.minutowka.io6.Mappers.UzytkownikMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class Pozyczka {
    private Long id;
    private Uzytkownik uzytkownik;
    private Long kwotaPozyczki;
    private Double rrso;
    private Long rata;
    private LocalDateTime dataZaciagnieciaPozyczki;
    private LocalDateTime dataZakonczeniaPozyczki;

    private boolean active;

    private LocalDateTime version;

    @JsonCreator
    public Pozyczka(@JsonProperty("uzytkownik") Long uzytkownik, @JsonProperty("poczatekPozyczki") String rozpoczecie,
                    @JsonProperty("zakonczeniePozyczki") String zakonczenie){
        this.dataZaciagnieciaPozyczki = convertToLocalDateTime(rozpoczecie);
        this.dataZakonczeniaPozyczki = convertToLocalDateTime(zakonczenie);
        this.uzytkownik = UzytkownikMapper.buildSimpleUzytkownik(uzytkownik);
    }

    private LocalDateTime convertToLocalDateTime(String date){
        date = date.replaceAll(" ", "T");
        return LocalDateTime.parse(date);
    }
}
