package com.minutowka.io6.Controllers;


import com.minutowka.io6.DTO.Pozyczki;
import com.minutowka.io6.Services.PozyczkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;

@RestController
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(value = "http://localhost:3000/")

public class PozyczkaController {

    @Autowired
    PozyczkaService pozyczkaService;

    @PostMapping("/profil/{userId}")
    public Collection<Pozyczki> pokazPozyczki(@PathVariable("userId") Long id){
        return pozyczkaService.findPozyczkiWithUserId(id);
    }


}
