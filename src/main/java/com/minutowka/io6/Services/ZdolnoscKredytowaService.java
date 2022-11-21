package com.minutowka.io6.Services;

import com.minutowka.io6.DTO.Pozyczka;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class ZdolnoscKredytowaService {

    private final PozyczkaService pozyczkaService;
    private final static String NEGATIVE_RESPONSE = "NEGATIVE";

    public String obliczZdolnoscKredytowa(Pozyczka pozyczka, Double wydatki, Double zarobki, Double raty){
        long wysokoscRatyKredytu = (long) (zarobki - wydatki - raty);
        long okresSplaty = Duration.between(pozyczka.getDataZaciagnieciaPozyczki(), pozyczka.getDataZakonczeniaPozyczki()).toDays();
        okresSplaty = Math.floorDiv(okresSplaty, 30);

        double maxWysokoscKredytu =  wysokoscRatyKredytu * okresSplaty;

        if(maxWysokoscKredytu >= pozyczka.getKwotaPozyczki()){
            return pozyczkaService.savePozyczka(pozyczka, okresSplaty);
        }
        return NEGATIVE_RESPONSE;
    }
}
