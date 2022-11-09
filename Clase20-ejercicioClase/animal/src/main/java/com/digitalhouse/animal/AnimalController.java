package com.digitalhouse.animal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {

    @GetMapping("/animal")
    public String holaAnimal() {
        return "<h1>hola animal!</h1>";
    }

}
