package com.bytesolutions.app.frescura.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/categorias")
public class Categorias {

    @GetMapping("/saludos")
    public String saludos(){
        return "Saludos";
    }
}
