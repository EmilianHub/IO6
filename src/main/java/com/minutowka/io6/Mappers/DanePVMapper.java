package com.minutowka.io6.Mappers;

import com.minutowka.io6.DTO.DanePV;
import com.minutowka.io6.JPA.DanePVJPA;
import com.minutowka.io6.JPA.UzytkownikJPA;
import org.springframework.stereotype.Service;

@Service
public class DanePVMapper {
    public static DanePV toDTO (DanePVJPA danePVJPA){
        return DanePV.builder()
                .pesel(danePVJPA.getPesel())
                .nrDowodu(danePVJPA.getNrDowodu())
                .uzytkownik(UzytkownikMapper.toDTO(danePVJPA.getUzytkownik()))
                .build();
    }
    public static DanePVJPA toJPA (DanePV danePV, UzytkownikJPA uzytkownikJPA) {
        return DanePVJPA.builder()
                .pesel(danePV.getPesel())
                .nrDowodu(danePV.getNrDowodu())
                .uzytkownik(uzytkownikJPA)
                .build();
    }
}
