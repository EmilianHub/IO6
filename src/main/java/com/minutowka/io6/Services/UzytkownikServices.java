package com.minutowka.io6.Services;

import com.minutowka.io6.DTO.Uzytkownik;
import com.minutowka.io6.JPA.UzytkownikJPA;
import com.minutowka.io6.Mappers.UzytkownikMapper;
import com.minutowka.io6.Repositories.UzytkownikRepo;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UzytkownikServices {

    private final String POSITIVE = "POSITIVE";
    private final UzytkownikRepo uzytkownikRepo;
    private final UzytkownikMapper uzytkownikMapper;

    public String saveUzytkownik(Uzytkownik rej)
    {
        UzytkownikJPA uzytkownikREJ = uzytkownikMapper.toJPA(rej);
        uzytkownikRepo.save(uzytkownikREJ);

        return POSITIVE;
    }
}
