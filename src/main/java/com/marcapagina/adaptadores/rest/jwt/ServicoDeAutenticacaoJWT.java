package com.marcapagina.adaptadores.rest.jwt;

import com.marcapagina.aplicacao.ServicoDeAutenticacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

@Slf4j
public class ServicoDeAutenticacaoJWT implements ServicoDeAutenticacao {

    public UsuarioAutenticado usuarioAutenticado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }

        if (!(authentication instanceof JwtAuthenticationToken)) {
            log.warn("Classe do authentication não esperada: {}. {}", authentication.getClass().getName(), authentication);
            return null;
        }

        Jwt token = ((JwtAuthenticationToken) authentication).getToken();

        return new UsuarioAutenticado(token.getClaimAsString("sub"), token.getClaimAsString("preferred_username"));
    }
}
