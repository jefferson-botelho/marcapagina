package com.marcapagina.config;

import com.marcapagina.adaptadores.repositorios.db.RepositorioUsuarioImpl;
import com.marcapagina.aplicacao.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class RepositoriosConfig {

    @Bean
    public RepositorioUsuario repositorioUsuario(@Qualifier("dsMarcaPagina") DataSource dsMarcaPagina) {
        return new RepositorioUsuarioImpl(dsMarcaPagina);
    }
}
