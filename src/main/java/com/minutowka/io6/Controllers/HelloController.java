package com.minutowka.io6.Controllers;

import com.minutowka.io6.Services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @CrossOrigin
    @GetMapping("/")
    public String sayHello(){
        return helloService.getHelloMessage();
    }
}
