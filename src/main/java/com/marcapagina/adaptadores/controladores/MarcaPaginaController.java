package com.marcapagina.adaptadores.controladores;

import com.marcapagina.adaptadores.controladores.dto.LivroDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class MarcaPaginaController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello world!";
    }

    @PostMapping("/cadastrar-livro")
    public void cadastrarLivro(LivroDTO livro) {

    }
}
