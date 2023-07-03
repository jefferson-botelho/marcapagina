package com.marcapagina.config;

import com.marcapagina.adaptadores.rest.jwt.ServicoDeAutenticacaoJWT;
import com.marcapagina.aplicacao.RepositorioDeLivros;
import com.marcapagina.aplicacao.ServicoDeAutenticacao;
import com.marcapagina.aplicacao.ServicoDeLivros;
import com.marcapagina.aplicacao.impl.ServicoDeLivrosImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoDeServicos {

    @Bean
    public ServicoDeLivros servicoDeLivros(RepositorioDeLivros repositorioDeLivros, @Value("${app.conf.capas.dir}") String diretorioCapas) {
        return new ServicoDeLivrosImpl(repositorioDeLivros, diretorioCapas);
    }

    @Bean
    public ServicoDeAutenticacao servicoDeAutenticacao() {
        return new ServicoDeAutenticacaoJWT();
    }
}
