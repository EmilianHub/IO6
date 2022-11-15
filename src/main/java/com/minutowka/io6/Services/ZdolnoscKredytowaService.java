package com.minutowka.io6.Services;

import com.minutowka.io6.DTO.Pozyczki;
import com.minutowka.io6.Exceptions.CustomExceptionBuilder;
import com.minutowka.io6.JPA.DaneKredytoweJPA;
import com.minutowka.io6.JPA.PozyczkiJPA;
import com.minutowka.io6.JPA.UzytkownikJPA;
import com.minutowka.io6.Mappers.PozyczkaMapper;
import com.minutowka.io6.Repositories.DaneKredytoweRepository;
import com.minutowka.io6.Repositories.PozyczkaRepo;
import com.minutowka.io6.Repositories.UzytkownikRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ZdolnoscKredytowaService {
    private final DaneKredytoweRepository daneKredytoweRepository;
    private final PozyczkaService pozyczkaService;
    private final static String POSITIVE_RESPONSE_MESSAGE = "Dane kredytowe zostały zapisane poprwanie";
    private final static String NEGATIVE_RESPONSE = "NEGATIVE";

    public String obliczZdolnoscKredytowa(Pozyczki pozyczka, Double wydatki, Double zarobki, Double raty){
        long wysokoscRatyKredytu = (long) (zarobki - wydatki - raty);
        long okresSplaty = Duration.between(pozyczka.getDataZaciagnieciaPozyczki(), pozyczka.getDataZakonczeniaPozyczki()).toDays();
        okresSplaty = Math.floorDiv(okresSplaty, 30);

        double maxWysokoscKredytu =  wysokoscRatyKredytu * okresSplaty;

        if(maxWysokoscKredytu >= pozyczka.getKwotaPozyczki()){
//            saveDaneKredytowe(wydatki, zarobki, pozyczka);
            return pozyczkaService.savePozyczka(pozyczka, okresSplaty);
        }
        return NEGATIVE_RESPONSE;
    }

    public String saveDaneKredytowe(Double wydatki, Double zarobki, Pozyczki pozyczka) {
        DaneKredytoweJPA dbDaneKredytowe = daneKredytoweRepository.findByUzytkownikJPAId(pozyczka.getUzytkownik().getId())
                .orElseThrow(() -> CustomExceptionBuilder.getCustomException(HttpStatus.BAD_REQUEST, "No entity found"));

        dbDaneKredytowe.setWydatki(wydatki);
        dbDaneKredytowe.setZarobki(zarobki);
        daneKredytoweRepository.save(dbDaneKredytowe);

        return POSITIVE_RESPONSE_MESSAGE;
    }


}
