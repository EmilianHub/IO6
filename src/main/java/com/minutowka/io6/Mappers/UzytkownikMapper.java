package com.minutowka.io6.Mappers;

import com.minutowka.io6.DTO.Uzytkownik;
import com.minutowka.io6.JPA.UzytkownikJPA;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
public class UzytkownikMapper {
    public  UzytkownikJPA toJPA(Uzytkownik uzytkownik){
        return
        UzytkownikJPA.builder()
                .imie(uzytkownik.getImie())
                .nazwisko(uzytkownik.getNazwisko())
                .email(uzytkownik.getEmail())
                .haslo(uzytkownik.getHaslo())
                .login(uzytkownik.getLogin())
                .id(uzytkownik.getId())
                .build();

    }
}
