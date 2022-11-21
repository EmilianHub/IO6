package com.minutowka.io6.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.minutowka.io6.Mappers.UzytkownikMapper;
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

    @JsonCreator
    public DaneKredytowe(@JsonProperty("uzytkownik") Long userId){
        this.uzytkownik = UzytkownikMapper.buildSimpleUzytkownik(userId);
    }
}
