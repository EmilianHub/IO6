package com.minutowka.io6.Controllers;

import com.minutowka.io6.DTO.Uzytkownik;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CookiesController {

    @PostMapping("/set-cookies")
    public String setCookies(@RequestBody Uzytkownik uzytkownik, HttpServletResponse response){
        Cookie cookie = new Cookie("userId", uzytkownik.getId().toString());

        response.addCookie(cookie);

        return "Cookie set";
    }

    @GetMapping("/read-cookie")
    public String readCookie(@CookieValue(value = "userId", defaultValue = "0") String userID){
        return userID;
    }
}
