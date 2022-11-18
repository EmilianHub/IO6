package com.minutowka.io6.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DanePV {
    private Long id;
    private String nrDowodu;
    private Long pesel;
    private Uzytkownik uzytkownik;

}
