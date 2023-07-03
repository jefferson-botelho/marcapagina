package com.marcapagina.adaptadores.controladores;

import com.marcapagina.adaptadores.controladores.dto.LivroDTO;
import com.marcapagina.adaptadores.rest.jwt.UsuarioAutenticado;
import com.marcapagina.aplicacao.ServicoDeAutenticacao;
import com.marcapagina.aplicacao.ServicoDeLivros;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MarcaPaginaController {

    private final ServicoDeLivros servico;
    private final ServicoDeAutenticacao servicoDeAutenticacao;

    @PostMapping("/cadastrar-livro")
    public void cadastrarLivro(@RequestBody LivroDTO livro) {
        servico.salvarLivro(livro.paraModelo());
    }

    @PostMapping("/iniciar-leitura")
    public void iniciarLeitura(@RequestBody long idLivro, @AuthenticationPrincipal Jwt jwt) {
        UsuarioAutenticado usuario = servicoDeAutenticacao.usuarioAutenticado();
        servico.iniciarLeitura(idLivro, usuario.getId());
    }
}
