package com.minutowka.io6.Mappers;

import com.minutowka.io6.DTO.Wplata;
import com.minutowka.io6.JPA.PozyczkaJPA;
import com.minutowka.io6.JPA.WplataJPA;
import org.springframework.stereotype.Service;

@Service
public class WplataMapper {
    public static WplataJPA toJPA(Wplata wplata, PozyczkaJPA pozyczkaJPA){
        return WplataJPA.builder()
                .created(wplata.getCreated())
                .id(wplata.getId())
                .kwotaWplaty(wplata.getKwotaWplaty())
                .pozyczka(pozyczkaJPA)
                .build();
    }

    public static Wplata toDTO(WplataJPA wplataJPA){
        return Wplata.builder()
                .created(wplataJPA.getCreated())
                .id(wplataJPA.getId())
                .kwotaWplaty(wplataJPA.getKwotaWplaty())
                .pozyczka(PozyczkaMapper.toDTO(wplataJPA.getPozyczka()))
                .build();
    }
}
