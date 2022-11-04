package com.minutowka.io6.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Uzytkownik {
    private Long id;
    private String imie;
    private String nazwisko;
    private String email;
    private String haslo;
    private String login;
}
