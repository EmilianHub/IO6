package com.minutowka.io6.Services;

import com.minutowka.io6.DTO.Pozyczka;
import com.minutowka.io6.Exceptions.CustomExceptionBuilder;
import com.minutowka.io6.JPA.PozyczkaJPA;
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

    public String savePozyczka(Pozyczka pozyczka, Long okresSplaty){
        UzytkownikJPA uzytkownikJPA = uzytkownikRepo.findById(pozyczka.getUzytkownik().getId())
                .orElseThrow(() -> CustomExceptionBuilder.getCustomException(HttpStatus.BAD_REQUEST, "Uzytkownik nie istnieje"));

        Long rata = (long) obliczRate(pozyczka, okresSplaty);

        pozyczka.setRata(rata);
        pozyczka.setActive(true);

        PozyczkaJPA pozyczkaJPA = pozyczkaMapper.toJPA(pozyczka, uzytkownikJPA);

        pozyczkaRepo.save(pozyczkaJPA);
        return POSITIVE_RESPONSE;
    }

    private double obliczRate(Pozyczka pozyczka, Long okresSplaty){
        Double kwotaZrrso = pozyczka.getKwotaPozyczki() * pozyczka.getRrso();
        return Math.floorDiv(pozyczka.getKwotaPozyczki(), okresSplaty)+kwotaZrrso;
    }

    public Collection<Pozyczka> findPozyczkiWithUserId(Long id){
        Collection<PozyczkaJPA> pozyczkaJPA = pozyczkaRepo.findAllByUzytkownikId(id);

        return pozyczkaJPA.stream().map(PozyczkaMapper::toDTO).collect(Collectors.toList());
    }
}
