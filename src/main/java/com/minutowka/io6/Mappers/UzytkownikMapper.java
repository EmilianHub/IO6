package com.minutowka.io6.Mappers;

import com.minutowka.io6.DTO.Uzytkownik;
import com.minutowka.io6.JPA.UzytkownikJPA;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.context.annotation.ApplicationScope;
@Service
@NoArgsConstructor
public class UzytkownikMapper {
    public static UzytkownikJPA toJPA(Uzytkownik uzytkownik){
        return UzytkownikJPA.builder()
                .imie(uzytkownik.getImie())
                .nazwisko(uzytkownik.getNazwisko())
                .email(uzytkownik.getEmail())
                .haslo(uzytkownik.getHaslo())
                .login(uzytkownik.getLogin())
                .id(uzytkownik.getId())
                .build();
    }

    public static Uzytkownik toDTO(UzytkownikJPA uzytkownikJPA){
        return Uzytkownik.builder()
                .id(uzytkownikJPA.getId())
                .email(uzytkownikJPA.getEmail())
                .haslo(uzytkownikJPA.getHaslo())
                .imie(uzytkownikJPA.getImie())
                .login(uzytkownikJPA.getLogin())
                .nazwisko(uzytkownikJPA.getNazwisko())
                .build();
    }
}
