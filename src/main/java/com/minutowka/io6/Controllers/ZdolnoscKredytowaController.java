package com.minutowka.io6.Controllers;

import com.minutowka.io6.DTO.Pozyczki;
import com.minutowka.io6.Services.ZdolnoscKredytowaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/zdolnosc-kredytowa", method = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(value = "http://localhost:3000/")
public class ZdolnoscKredytowaController {

    @Autowired
    private ZdolnoscKredytowaService zdolnoscKredytowaService;

    @PostMapping("/process")
    public String obliczRatePodczasProcesu(@RequestParam("wydatki") Double wydatki, @RequestParam("zarobki") Double zarobki,
                                           @RequestParam("raty") Double raty, @RequestBody Pozyczki pozyczka){
        return zdolnoscKredytowaService.obliczZdolnoscKredytowa(pozyczka, wydatki, zarobki, raty);
    }
}
