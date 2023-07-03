package com.marcapagina.aplicacao;

import com.marcapagina.adaptadores.rest.jwt.UsuarioAutenticado;

public interface ServicoDeAutenticacao {

    UsuarioAutenticado usuarioAutenticado();
}
