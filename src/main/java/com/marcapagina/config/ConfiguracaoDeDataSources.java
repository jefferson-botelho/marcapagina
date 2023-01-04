package com.marcapagina.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConfiguracaoDeDataSources {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dsMarcaPagina() {
        return DataSourceBuilder.create().build();
    }
}
