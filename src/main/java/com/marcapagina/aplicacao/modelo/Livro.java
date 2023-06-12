package com.marcapagina.aplicacao.modelo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Livro {
    private long idLivro;
    private String titulo;
    private String autor;
    private Integer qtdPaginas;
    private String fotoCapa;
}
