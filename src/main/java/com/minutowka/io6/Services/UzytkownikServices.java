package com.minutowka.io6.Services;

import com.minutowka.io6.DTO.Uzytkownik;
import com.minutowka.io6.Exceptions.CustomExceptionBuilder;
import com.minutowka.io6.JPA.UzytkownikJPA;
import com.minutowka.io6.Mappers.UzytkownikMapper;
import com.minutowka.io6.Repositories.UzytkownikRepo;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UzytkownikServices {

    private final String POSITIVE = "POSITIVE";
    private final UzytkownikRepo uzytkownikRepo;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final Pattern EMAIL_SYNTAX = Pattern.compile("[/!#$%^&*()/]");

    public String saveUzytkownik(Uzytkownik rej){
        verifyLoginAndEmailPresence(rej);

        String enryptedPassword = passwordEncoder.encode(rej.getHaslo());
        rej.setHaslo(enryptedPassword);

        UzytkownikJPA uzytkownikREJ = UzytkownikMapper.toJPA(rej);
        uzytkownikRepo.save(uzytkownikREJ);

        return POSITIVE;
    }
    public Long getuzytkownik (String login,String haslo){
        Optional<UzytkownikJPA> uzytkownikJPA = uzytkownikRepo.findByLoginAndHaslo(login,haslo);
        if (uzytkownikJPA.isPresent()) {
            return uzytkownikJPA.get().getId();

        }
        else return 0l;
    }

    private void verifyLoginAndEmailPresence(Uzytkownik uzytkownik){
        if(Strings.isEmpty(uzytkownik.getEmail())){
            throw CustomExceptionBuilder.getCustomException(HttpStatus.BAD_REQUEST, "Email is empty");
        }
        if(Strings.isEmpty(uzytkownik.getLogin())){
            throw CustomExceptionBuilder.getCustomException(HttpStatus.BAD_REQUEST, "Login is empty");
        }
        verifyEmailSyntax(uzytkownik.getEmail());
    }

    private void verifyEmailSyntax(String email){
        if(EMAIL_SYNTAX.matcher(email).find()){
            throw CustomExceptionBuilder.getCustomException(HttpStatus.BAD_REQUEST, "Wrong email syntax");
        }
    }

}
