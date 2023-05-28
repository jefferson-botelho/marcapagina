package com.marcapagina.adaptadores.repositorios.db;

import com.marcapagina.aplicacao.RepositorioDeLivros;
import com.marcapagina.aplicacao.modelo.Livro;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Statement;

import static java.util.Objects.requireNonNull;

public class RepositorioDeLivrosJdbc implements RepositorioDeLivros {

    private final NamedParameterJdbcTemplate namedJt;

    public RepositorioDeLivrosJdbc(DataSource ds) {
        this.namedJt = new NamedParameterJdbcTemplate(ds);
    }

    @Override
    public long salvarLivro(Livro livro) {
        String insert = "INSERT INTO MARCAPAGINA.LIVRO(titulo, autor, qtd_paginas) VALUES (:titulo, :autor, :qtdPaginas)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedJt.update(insert, new ParametrosInsertLivro(livro), keyHolder);

        return requireNonNull(keyHolder.getKey()).longValue();
    }

    public static class ParametrosInsertLivro extends MapSqlParameterSource {
        public ParametrosInsertLivro(Livro livro) {
            this.addValue("titulo", livro.getTitulo());
            this.addValue("autor", livro.getAutor());
            this.addValue("qtdPaginas", livro.getQtdPaginas());
        }
    }
}
