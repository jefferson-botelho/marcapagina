package com.marcapagina.adaptadores.repositorios.db;

import com.marcapagina.aplicacao.RepositorioDeLivros;
import com.marcapagina.aplicacao.modelo.Livro;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Statement;

import static java.util.Objects.requireNonNull;

public class RepositorioDeLivrosJdbc implements RepositorioDeLivros {

    private final JdbcTemplate jt;

    public RepositorioDeLivrosJdbc(DataSource ds) {
        this.jt = new JdbcTemplate(ds);
    }

    @Override
    @Transactional
    public long salvarLivro(Livro livro) {
        String insert = "INSERT INTO MARCAPAGINA.LIVRO(titulo, autor, qtd_paginas) VALUES (" + gerarValoresInsertLivro(livro) + ")";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jt.update(con -> con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS), keyHolder);

        return requireNonNull(keyHolder.getKey()).longValue();
    }

    private String gerarValoresInsertLivro(Livro livro) {
        return String.format(
                "'%s', '%s', %d",
                livro.getTitulo(),
                livro.getAutor(),
                livro.getQtdPaginas()
        );
    }
}
