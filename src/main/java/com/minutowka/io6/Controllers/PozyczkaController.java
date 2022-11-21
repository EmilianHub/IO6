package com.minutowka.io6.Controllers;


import com.minutowka.io6.DTO.Pozyczka;
import com.minutowka.io6.DTO.Wplata;
import com.minutowka.io6.Services.PozyczkaService;
import com.minutowka.io6.Services.WplatyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/profil", method = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(value = "http://localhost:3000/")

public class PozyczkaController {

    @Autowired
    PozyczkaService pozyczkaService;

    @Autowired
    private WplatyService wplatyService;

    @PostMapping("/{userId}")
    public Collection<Pozyczka> pokazPozyczki(@PathVariable("userId") Long id) {
        return pozyczkaService.findPozyczkiWithUserId(id);
    }

    @GetMapping("/count/{id}")
    public Long kolejna (@PathVariable("id")Long id){
        return pozyczkaService.kolejnaPozyczka(id);
    }

    @GetMapping("/singlePozyczka/{id}")
    public Wplata findPozyczkaWithId(@PathVariable("id") Long id){
        return wplatyService.findWplatyWithPozyczkaId(id);
    }

    @PostMapping("/splacRate")
    public String splacRate(@RequestParam("kwotaSplaty") Double kwotaWplaty, @RequestParam("idPozyczki") Long idPozyczki){
        return wplatyService.splacRate(kwotaWplaty, idPozyczki);
    }
}
