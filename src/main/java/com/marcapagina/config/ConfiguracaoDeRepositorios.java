package com.marcapagina.config;

import com.marcapagina.adaptadores.repositorios.db.RepositorioDeLivrosJdbc;
import com.marcapagina.aplicacao.RepositorioDeLivros;
import com.marcapagina.aplicacao.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConfiguracaoDeRepositorios {

    @Bean
    public RepositorioDeLivros repositorioUsuario(@Qualifier("dsMarcaPagina") DataSource dsMarcaPagina) {
        return new RepositorioDeLivrosJdbc(dsMarcaPagina);
    }
}
