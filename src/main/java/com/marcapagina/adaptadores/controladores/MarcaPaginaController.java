package com.marcapagina.adaptadores.controladores;

import com.marcapagina.adaptadores.controladores.dto.LivroDTO;
import com.marcapagina.aplicacao.ServicoDeLivros;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MarcaPaginaController {

    private final ServicoDeLivros servico;

    @PostMapping("/cadastrar-livro")
    public void cadastrarLivro(@RequestBody LivroDTO livro) {
        servico.salvarLivro(livro.paraModelo());
    }
}
