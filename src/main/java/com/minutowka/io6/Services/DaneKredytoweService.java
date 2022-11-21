package com.minutowka.io6.Services;

import com.minutowka.io6.DTO.DaneKredytowe;
import com.minutowka.io6.Exceptions.CustomExceptionBuilder;
import com.minutowka.io6.JPA.DaneKredytoweJPA;
import com.minutowka.io6.JPA.UzytkownikJPA;
import com.minutowka.io6.Mappers.DaneKredytoweMapper;
import com.minutowka.io6.Repositories.DaneKredytoweRepository;
import com.minutowka.io6.Repositories.UzytkownikRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class DaneKredytoweService {

    private final Pattern NR_KONTA_SYNTAX = Pattern.compile("[/!#$%^&*()/@]");
    private static String POSITIVE_RESPONSE_MESSAGE = "Dane zostaly zapisane pomyslnie";
    private final DaneKredytoweRepository daneKredytoweRepository;
    private final UzytkownikRepo uzytkownikRepo;

    public String saveDaneKredytowe(DaneKredytowe daneKredytowe) {
        verifyNumerKontaSyntax(daneKredytowe);

        Optional<DaneKredytoweJPA> dbDaneKredytowe = daneKredytoweRepository.findByUzytkownikJPAId(daneKredytowe.getUzytkownik().getId());
        UzytkownikJPA uzytkownikJPA = uzytkownikRepo.getReferenceById(daneKredytowe.getUzytkownik().getId());

        if(dbDaneKredytowe.isPresent()){
            daneKredytowe.setId(dbDaneKredytowe.get().getId());
            daneKredytowe.setVersion(dbDaneKredytowe.get().getVersion());
        }

        daneKredytoweRepository.save(DaneKredytoweMapper.toJPA(daneKredytowe, uzytkownikJPA));

        return POSITIVE_RESPONSE_MESSAGE;
    }

    private void verifyNumerKontaSyntax(DaneKredytowe daneKredytowe){
        if(Objects.isNull(daneKredytowe)){
            throw CustomExceptionBuilder.getCustomException(HttpStatus.BAD_REQUEST, "Numer konta nie może być pusty");
        }else if(NR_KONTA_SYNTAX.matcher(daneKredytowe.getNrKonta()).find()){
            throw CustomExceptionBuilder.getCustomException(HttpStatus.BAD_REQUEST, "Numer konta zawiera nieprawidłowy format");
        }else if (daneKredytowe.getNrKonta().length() < 8){
            throw CustomExceptionBuilder.getCustomException(HttpStatus.BAD_REQUEST, "Numer konta bankowego jest za krótki");
        }
    }
}
