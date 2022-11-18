package com.minutowka.io6.Services;

import com.minutowka.io6.DTO.Pozyczka;
import com.minutowka.io6.DTO.Wplata;
import com.minutowka.io6.Exceptions.CustomExceptionBuilder;
import com.minutowka.io6.JPA.PozyczkaJPA;
import com.minutowka.io6.JPA.WplataJPA;
import com.minutowka.io6.Mappers.PozyczkaMapper;
import com.minutowka.io6.Mappers.WplataMapper;
import com.minutowka.io6.Repositories.PozyczkaRepo;
import com.minutowka.io6.Repositories.WplataRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WplatyService {
    private final WplataRepo wplataRepo;
    private final PozyczkaRepo pozyczkaRepo;

    public Wplata findWplatyWithPozyczkaId(Long id){
        Collection<Wplata> wplaty = wplataRepo.findByPozyczkaIdOrderByCreatedDesc(id).stream()
                .map(WplataMapper::toDTO)
                .toList();

        if(wplaty.isEmpty()){
            return isFirstPayBack(id);
        }

        LinkedList<Long> kwoty = obliczWysokoscWplat(wplaty);
        Wplata lastWplata = wplaty.stream().findFirst().get();
        lastWplata.setNadPlata(kwoty.get(0));
        lastWplata.setNieDoplata(kwoty.get(1));
        return lastWplata;
    }

    private LinkedList<Long> obliczWysokoscWplat(Collection<Wplata> wplaty){
        Wplata ostatniaWplata = wplaty.stream().findFirst().orElseThrow(() -> CustomExceptionBuilder.getCustomException(HttpStatus.NOT_FOUND, "Blad"));
        long between = Duration.between(ostatniaWplata.getPozyczka().getDataZaciagnieciaPozyczki(), LocalDateTime.now()).toDays() / 30;

        long przewidywanaSuma = ostatniaWplata.getPozyczka().getRata() * between;

        Double dokonanaWplata = wplaty.stream().collect(Collectors.summingDouble(value -> value.getKwotaWplaty()));

        long roznica = (long) Math.floor(przewidywanaSuma - dokonanaWplata);

        if (roznica < 0){
            return new LinkedList<>(List.of(-roznica, 0L));
        }else if(roznica>0){
            new LinkedList<>(List.of(0L,roznica));
        }

        return new LinkedList<>(List.of(0L, 0L));
    }

    private Wplata isFirstPayBack(Long id){
        Pozyczka pozyczka = PozyczkaMapper.toDTO(pozyczkaRepo.getReferenceById(id));
        return Wplata.builder()
                .nadPlata(0L)
                .nieDoplata(pozyczka.getRata())
                .pozyczka(pozyczka)
                .build();
    }

    public String splacRate(Double kwotaWplaty, Long idPozyczki) {
        PozyczkaJPA pozyczkaJPA = pozyczkaRepo.getReferenceById(idPozyczki);

        if (isPaidOff(idPozyczki)){
            pozyczkaJPA.setActive(false);
        }

        WplataJPA wplataJPA = WplataJPA.builder()
                .created(LocalDateTime.now())
                .kwotaWplaty(kwotaWplaty)
                .pozyczka(pozyczkaJPA)
                .build();

        wplataRepo.save(wplataJPA);

        return "Success";
    }

    private boolean isPaidOff(Long id){
        Collection<WplataJPA> wplataJPA = wplataRepo.findByPozyczkaIdOrderByCreatedDesc(id);

        if(!wplataJPA.isEmpty()){
            Double dokonanaWplata = wplataJPA.stream().collect(Collectors.summingDouble(value -> value.getKwotaWplaty()));
            return wplataJPA.stream().findFirst().get().getPozyczka().getKwota() - dokonanaWplata <= 0;
        }
        return false;
    }
}
