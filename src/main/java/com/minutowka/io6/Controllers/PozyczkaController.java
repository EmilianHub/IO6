package com.minutowka.io6.Controllers;


import com.minutowka.io6.DTO.Pozyczka;
import com.minutowka.io6.Services.PozyczkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(value = "http://localhost:3000/")

public class PozyczkaController {

    @Autowired
    PozyczkaService pozyczkaService;

    @PostMapping("/profil/{userId}")
    public Collection<Pozyczka> pokazPozyczki(@PathVariable("userId") Long id) {
        return pozyczkaService.findPozyczkiWithUserId(id);
    }

    @GetMapping("/profil/count/{id}")
    public Long kolejna (@PathVariable("id")Long id){
        return pozyczkaService.kolejnaPozyczka(id);
    }


}
