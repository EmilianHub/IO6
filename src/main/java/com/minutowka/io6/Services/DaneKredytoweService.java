package com.minutowka.io6.Services;

import com.minutowka.io6.DTO.DaneKredytowe;
import com.minutowka.io6.DTO.Pozyczki;
import com.minutowka.io6.JPA.DaneKredytoweJPA;
import com.minutowka.io6.JPA.UzytkownikJPA;
import com.minutowka.io6.Mappers.DaneKredytoweMapper;
import com.minutowka.io6.Repositories.DaneKredytoweRepository;
import com.minutowka.io6.Repositories.UzytkownikRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DaneKredytoweService {
    private static String POSITIVE_RESPONSE_MESSAGE = "Dane zostaly zapisane pomyslnie";
    private final DaneKredytoweRepository daneKredytoweRepository;
    private final UzytkownikRepo uzytkownikRepo;

    public String saveDaneKredytowe(DaneKredytowe daneKredytowe, Pozyczki pozyczka) {
        Optional<DaneKredytoweJPA> dbDaneKredytowe = daneKredytoweRepository.findByUzytkownikJPAId(pozyczka.getUzytkownik().getId());
        UzytkownikJPA uzytkownikJPA = uzytkownikRepo.getReferenceById(pozyczka.getUzytkownik().getId());

        if(dbDaneKredytowe.isPresent()){
            daneKredytowe.setId(dbDaneKredytowe.get().getId());
            daneKredytowe.setVersion(dbDaneKredytowe.get().getVersion());
        }

        daneKredytoweRepository.save(DaneKredytoweMapper.toJPA(daneKredytowe, uzytkownikJPA));

        return POSITIVE_RESPONSE_MESSAGE;
    }
}
