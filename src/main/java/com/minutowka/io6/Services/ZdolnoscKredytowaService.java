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

    public String obliczZdolnoscKredytowa(Pozyczki pozyczki, Double wydatki, Double zarobki, Double raty){
        double wysokoscRatyKredytu = zarobki - wydatki - raty;
        long okresSplaty = Duration.between(pozyczki.getDataZaciagnieciaPozyczki(), pozyczki.getDataZakonczeniaPozyczki()).toDays();
        okresSplaty = Math.floorDiv(okresSplaty, 30);

        double maxWysokoscKredytu =  wysokoscRatyKredytu * okresSplaty;

        if(maxWysokoscKredytu >= pozyczki.getKwotaPozyczki()){
            saveDaneKredytowe(wydatki, zarobki, pozyczki.getUzytkownik().getId());
            return POSITIVE_RESPONSE;
        }
        return NEGATIVE_RESPONSE;
    }

    public String saveDaneKredytowe(Double wydatki, Double zarobki, Long userID) {
        DaneKredytoweJPA dbDaneKredytowe = daneKredytoweRepository.findDaneKredytoweJPAByUzytkownikId(userID)
                .orElseThrow(() -> CustomExceptionBuilder.getCustomException("No entity found"));

        dbDaneKredytowe.setWydatki(wydatki);
        dbDaneKredytowe.setZarobki(zarobki);
        daneKredytoweRepository.save(dbDaneKredytowe);

        return POSITIVE_RESPONSE_MESSAGE;
    }
}
