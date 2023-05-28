package com.marcapagina.config;

import com.marcapagina.aplicacao.RepositorioDeLivros;
import com.marcapagina.aplicacao.ServicoDeLivros;
import com.marcapagina.aplicacao.impl.ServicoDeLivrosImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoDeServicos {

    @Bean
    public ServicoDeLivros servicoDeLivros(RepositorioDeLivros repositorioDeLivros, @Value("${app.conf.foto.capas}") String diretorioCapas) {
        return new ServicoDeLivrosImpl(repositorioDeLivros, diretorioCapas);
    }
}
