package com.marcapagina.aplicacao.impl;

import com.marcapagina.aplicacao.RepositorioDeLivros;
import com.marcapagina.aplicacao.ServicoDeLivros;
import com.marcapagina.aplicacao.modelo.Livro;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

public class ServicoDeLivrosImpl implements ServicoDeLivros {

    private final RepositorioDeLivros repositorioDeLivros;
    private final Imagem imagem;

    public ServicoDeLivrosImpl(RepositorioDeLivros repositorioDeLivros, String diretorioImagens) {
        this.repositorioDeLivros = repositorioDeLivros;
        this.imagem = new Imagem(diretorioImagens);
    }

    @Override
    @Transactional
    public void salvarLivro(Livro livro) {
        long idLivro = repositorioDeLivros.salvarLivro(livro);
        imagem.salvarImagem(idLivro, livro.getFotoCapa());
    }

    @Override
    public void iniciarLeitura(long idLivro, String idUsuario) {
        repositorioDeLivros.iniciarLeitura(idLivro, idUsuario);
    }
}
