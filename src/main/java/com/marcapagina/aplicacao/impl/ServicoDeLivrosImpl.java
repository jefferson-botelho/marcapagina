package com.marcapagina.aplicacao.impl;

import com.marcapagina.aplicacao.RepositorioDeLivros;
import com.marcapagina.aplicacao.modelo.Livro;

public class ServicoDeLivrosImpl {

    private RepositorioDeLivros repositorioDeLivros;

    public void salvarLivro(Livro livro) {
        long idLivro = repositorioDeLivros.salvarLivro(livro);
        Imagem.salvarImagem(idLivro, livro.getFotoCapa());
    }
}
