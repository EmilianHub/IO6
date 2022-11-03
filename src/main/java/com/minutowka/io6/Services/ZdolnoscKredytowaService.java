package com.minutowka.io6.Services;

import com.minutowka.io6.DTO.Pozyczki;
import com.minutowka.io6.Exceptions.CustomExceptionBuilder;
import com.minutowka.io6.JPA.DaneKredytoweJPA;
import com.minutowka.io6.Repositories.DaneKredytoweRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class ZdolnoscKredytowaService {
    private final DaneKredytoweRepository daneKredytoweRepository;

    private final static String POSITIVE_RESPONSE_MESSAGE = "Dane kredytowe zostały zapisane poprwanie";
    private final static String POSITIVE_RESPONSE = "POSITIVE";
    private final static String NEGATIVE_RESPONSE = "NEGATIVE";

    public String obliczZdolnoscKredytowa(Pozyczki pozyczki, String wydatki, String zarobki, String raty){
        double wysokoscRatyKredytu = Double.parseDouble(wydatki) - Double.parseDouble(zarobki) - Double.parseDouble(raty);
        long okresSplaty = Duration.between(pozyczki.getDataZakonczeniaPozyczki(), pozyczki.getDataZaciagnieciaPozyczki()).toDays();
        okresSplaty = Math.floorDiv(okresSplaty, 30);

        double maxWysokoscKredytu =  wysokoscRatyKredytu * okresSplaty;

        if(maxWysokoscKredytu >= pozyczki.getKwotaPozyczki()){
            return POSITIVE_RESPONSE;
        }
        return NEGATIVE_RESPONSE;
    }

    public String saveDaneKredytowe(Double wydatki, Double zarobki, Double raty) {
        DaneKredytoweJPA dbDaneKredytowe = daneKredytoweRepository.findDaneKredytoweJPAByUzytkownikId(1L)
                .orElseThrow(() -> CustomExceptionBuilder.getCustomException("No entity found"));

        dbDaneKredytowe.setWydatki(wydatki);
        dbDaneKredytowe.setZarobki(zarobki);
        daneKredytoweRepository.save(dbDaneKredytowe);

        return POSITIVE_RESPONSE_MESSAGE;
    }
}
