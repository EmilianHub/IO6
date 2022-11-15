package com.minutowka.io6.Mappers;

import com.minutowka.io6.DTO.Pozyczki;
import com.minutowka.io6.JPA.PozyczkiJPA;
import com.minutowka.io6.JPA.UzytkownikJPA;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class PozyczkaMapper {
    public static PozyczkiJPA toJPA(Pozyczki pozyczki, UzytkownikJPA uzytkownikJPA){
        return PozyczkiJPA.builder()
                .id(pozyczki.getId())
                .data_konca(pozyczki.getDataZakonczeniaPozyczki())
                .data_pobrania(pozyczki.getDataZaciagnieciaPozyczki())
                .kwota(pozyczki.getKwotaPozyczki())
                .rata(pozyczki.getRata())
                .rrso(pozyczki.getRrso())
                .uzytkownik(uzytkownikJPA)
                .build();
    }
}
