package com.marcapagina.adaptadores.controladores.dto;

import com.marcapagina.aplicacao.modelo.Livro;
import lombok.Data;

@Data
public class LivroDTO {
    private String titulo;
    private String autor;
    private Integer qtdPaginas;
    private String foto;

    public Livro paraModelo() {
        return Livro.builder()
                .titulo(titulo)
                .autor(autor)
                .qtdPaginas(qtdPaginas)
                .fotoCapa(foto)
                .build();
    }
}
