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
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.util.Objects.requireNonNull;

public class RepositorioDeLivrosJdbc implements RepositorioDeLivros {

    private final NamedParameterJdbcTemplate namedJt;

    public RepositorioDeLivrosJdbc(DataSource ds) {
        this.namedJt = new NamedParameterJdbcTemplate(ds);
    }

    @Override
    public void iniciarLeitura(long idLivro, String idUsuario) {
        String insert = "INSERT INTO MARCAPAGINA.REGISTRO(id_usuario, id_livro, ultima_pagina_lida, data) VALUES (:idUsuario, :idLivro, :ultimaPaginaLida, :data)";
        namedJt.update(insert, new ParametrosInsertRegistro(idUsuario, idLivro, 0, LocalDateTime.now()));
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

    public static class ParametrosInsertRegistro extends MapSqlParameterSource {
        public ParametrosInsertRegistro(String idUsuario, long idLivro, int ultimaPaginaLida, LocalDateTime data) {
            this.addValue("idUsuario", idUsuario);
            this.addValue("idLivro", idLivro);
            this.addValue("ultimaPaginaLida", ultimaPaginaLida);
            this.addValue("data", data);
        }
    }
}
