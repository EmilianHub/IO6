package com.minutowka.io6.Controllers;

import com.minutowka.io6.DTO.Pozyczki;
import com.minutowka.io6.Services.ZdolnoscKredytowaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/zdolnosc-kredytowa", method = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin
public class ZdolnoscKredytowaController {

    @Autowired
    private ZdolnoscKredytowaService zdolnoscKredytowaService;

    @PostMapping("/process")
    public String obliczRatePodczasProcesu(@RequestParam("wydatki") String wydatki, @RequestParam("zarobki") String zarobki,
                                           @RequestParam("raty") String raty, @RequestBody Pozyczki pozyczka){
        return zdolnoscKredytowaService.obliczZdolnoscKredytowa(pozyczka, wydatki, zarobki, raty);
    }

    @PostMapping("/single")
    public String obliczRateTylkoZForumarza(@RequestParam("wydatki") Double wydatki, @RequestParam("zarobki") Double zarobki, @RequestParam("raty") Double raty){
        return zdolnoscKredytowaService.saveDaneKredytowe(wydatki, zarobki, raty);
    }
}
