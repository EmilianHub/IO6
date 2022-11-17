package com.minutowka.io6.Mappers;

import com.minutowka.io6.DTO.DaneKredytowe;
import com.minutowka.io6.JPA.DaneKredytoweJPA;
import com.minutowka.io6.JPA.UzytkownikJPA;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class DaneKredytoweMapper {
    public static DaneKredytoweJPA toJPA(DaneKredytowe daneKredytowe, UzytkownikJPA uzytkownikJPA){
        return DaneKredytoweJPA.builder()
                .id(daneKredytowe.getId())
                .uzytkownikJPA(uzytkownikJPA)
                .nrKonta(daneKredytowe.getNrKonta())
                .wydatki(daneKredytowe.getWydatki())
                .zarobki(daneKredytowe.getZarobki())
                .version(daneKredytowe.getVersion())
                .build();
    }

    public static DaneKredytowe toDTO(DaneKredytoweJPA daneKredytoweJPA){
        return DaneKredytowe.builder()
                .id(daneKredytoweJPA.getId())
                .version(daneKredytoweJPA.getVersion())
                .zarobki(daneKredytoweJPA.getZarobki())
                .wydatki(daneKredytoweJPA.getWydatki())
                .nrKonta(daneKredytoweJPA.getNrKonta())
                .uzytkownik(UzytkownikMapper.toDTO(daneKredytoweJPA.getUzytkownikJPA()))
                .build();
    }
}
