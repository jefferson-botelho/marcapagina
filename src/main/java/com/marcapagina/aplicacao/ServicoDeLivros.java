package com.marcapagina.aplicacao;

import com.marcapagina.aplicacao.modelo.Livro;

public interface ServicoDeLivros {

    void salvarLivro(Livro livro);
    void iniciarLeitura(long idLivro, String idUsuario);
}
