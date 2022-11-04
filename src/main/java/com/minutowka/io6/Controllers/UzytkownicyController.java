package com.minutowka.io6.Controllers;

import com.minutowka.io6.DTO.Uzytkownik;
import com.minutowka.io6.Repositories.UzytkownikRepo;
import com.minutowka.io6.Services.UzytkownikServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/uzytkownik", method = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(value = "http://localhost:3000")
public class UzytkownicyController {
    @Autowired
   private UzytkownikServices uzytkownikServices;
    @PostMapping("/rejestracja")
    public String rejestracja(@RequestBody Uzytkownik uzytkownik)
    {

        return uzytkownikServices.saveUzytkownik(uzytkownik);
    }

}
