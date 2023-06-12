package com.marcapagina.aplicacao;

import com.marcapagina.aplicacao.modelo.Livro;

public interface RepositorioDeLivros {

    void iniciarLeitura(long idLivro, String idUsuario);
    long salvarLivro(Livro livro);
}
