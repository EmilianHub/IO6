package com.minutowka.io6.Mappers;

import com.minutowka.io6.DTO.Pozyczka;
import com.minutowka.io6.JPA.PozyczkaJPA;
import com.minutowka.io6.JPA.UzytkownikJPA;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class PozyczkaMapper {
    public static PozyczkaJPA toJPA(Pozyczka pozyczka, UzytkownikJPA uzytkownikJPA){
        return PozyczkaJPA.builder()
                .id(pozyczka.getId())
                .version(pozyczka.getVersion())
                .data_konca(pozyczka.getDataZakonczeniaPozyczki())
                .data_pobrania(pozyczka.getDataZaciagnieciaPozyczki())
                .kwota(pozyczka.getKwotaPozyczki())
                .rata(pozyczka.getRata())
                .rrso(pozyczka.getRrso())
                .uzytkownik(uzytkownikJPA)
                .active(pozyczka.isActive())
                .build();
    }

    public static Pozyczka toDTO(PozyczkaJPA pozyczkaJPA){
        return Pozyczka.builder()
                .id(pozyczkaJPA.getId())
                .version(pozyczkaJPA.getVersion())
                .kwotaPozyczki(pozyczkaJPA.getKwota())
                .rata(pozyczkaJPA.getRata())
                .rrso(pozyczkaJPA.getRrso())
                .dataZaciagnieciaPozyczki(pozyczkaJPA.getData_pobrania())
                .dataZakonczeniaPozyczki(pozyczkaJPA.getData_konca())
                .uzytkownik(UzytkownikMapper.toDTO(pozyczkaJPA.getUzytkownik()))
                .active(pozyczkaJPA.isActive())
                .build();
    }
}
