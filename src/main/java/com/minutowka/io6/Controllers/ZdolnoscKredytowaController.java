package com.minutowka.io6.Controllers;

import com.minutowka.io6.DTO.DaneKredytowe;
import com.minutowka.io6.DTO.Pozyczka;
import com.minutowka.io6.Services.DaneKredytoweService;
import com.minutowka.io6.Services.ZdolnoscKredytowaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/zdolnosc-kredytowa", method = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(value = "http://localhost:3000/")
public class ZdolnoscKredytowaController {

    @Autowired
    private ZdolnoscKredytowaService zdolnoscKredytowaService;

    @Autowired
    private DaneKredytoweService daneKredytoweService;

    @PostMapping("/process")
    public String obliczZdolnoscKredytowa(@RequestParam("wydatki") Double wydatki, @RequestParam("zarobki") Double zarobki,
                                          @RequestParam("raty") Double raty, @RequestBody Pozyczka pozyczka){
        return zdolnoscKredytowaService.obliczZdolnoscKredytowa(pozyczka, wydatki, zarobki, raty);
    }

    @PostMapping("/daneKredytowe")
    public String saveDaneKredytowe(@RequestBody DaneKredytowe daneKredytowe){
        return daneKredytoweService.saveDaneKredytowe(daneKredytowe);
    }
}
