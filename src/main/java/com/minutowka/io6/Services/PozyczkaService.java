package com.minutowka.io6.Services;

import com.minutowka.io6.DTO.Pozyczki;
import com.minutowka.io6.Exceptions.CustomExceptionBuilder;
import com.minutowka.io6.JPA.PozyczkiJPA;
import com.minutowka.io6.JPA.UzytkownikJPA;
import com.minutowka.io6.Mappers.PozyczkaMapper;
import com.minutowka.io6.Repositories.PozyczkaRepo;
import com.minutowka.io6.Repositories.UzytkownikRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PozyczkaService {
    private final static String POSITIVE_RESPONSE = "POSITIVE";

    private  final UzytkownikRepo uzytkownikRepo;
    private final PozyczkaMapper pozyczkaMapper;
    private final PozyczkaRepo pozyczkaRepo;

    public String savePozyczka(Pozyczki pozyczki, Long okresSplaty){
        UzytkownikJPA uzytkownikJPA = uzytkownikRepo.findById(pozyczki.getUzytkownik().getId())
                .orElseThrow(() -> CustomExceptionBuilder.getCustomException(HttpStatus.BAD_REQUEST, "Uzytkownik nie istnieje"));

        Long rata = (long) obliczRate(pozyczki, okresSplaty);
        pozyczki.setRata(rata);
        PozyczkiJPA pozyczkiJPA = pozyczkaMapper.toJPA(pozyczki, uzytkownikJPA);

        pozyczkaRepo.save(pozyczkiJPA);
        return POSITIVE_RESPONSE;
    }

    private double obliczRate(Pozyczki pozyczki, Long okresSplaty){
        Double kwotaZrrso = pozyczki.getKwotaPozyczki() * pozyczki.getRrso();
        return Math.floorDiv(pozyczki.getKwotaPozyczki(), okresSplaty)+kwotaZrrso;
    }

    public Collection<Pozyczki> findPozyczkiWithUserId(Long id){
        Collection<PozyczkiJPA> pozyczkiJPA = pozyczkaRepo.findAllByUzytkownikId(id);

        return pozyczkiJPA.stream().map(PozyczkaMapper::toDTO).collect(Collectors.toList());
    }
}
