package com.minutowka.io6.Controllers;

import com.minutowka.io6.DTO.DanePV;
import com.minutowka.io6.Services.DanePVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(value = {"http://localhost:3000/"})
public class DanePVController {
    @Autowired
    DanePVService danePVService;
    @PostMapping("/UpdateDanePV")
    public DanePV updateDane(@RequestBody DanePV danePV){
        return danePVService.updateDane(danePV);
    }
}
