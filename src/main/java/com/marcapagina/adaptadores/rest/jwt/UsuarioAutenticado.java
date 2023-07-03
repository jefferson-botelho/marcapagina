package com.marcapagina.adaptadores.rest.jwt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UsuarioAutenticado {
    private final String id;
    private final String nome;
}
