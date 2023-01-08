package com.marcapagina.adaptadores.controladores.dto;

import lombok.Data;

@Data
public class LivroDTO {
    private String titulo;
    private String autor;
    private Integer qtdPaginas;
    private String foto;
}
