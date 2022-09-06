package com.marcapagina.adaptadores.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarcaPaginaController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello world!";
    }
}
