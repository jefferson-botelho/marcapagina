package com.marcapagina.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final long VALIDADE_TOKEN = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    public String obterUsernamePorToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date obterDataExpiracaoToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean tokenExpirado(String token) {
        final Date expiration = obterDataExpiracaoToken(token);
        return expiration.before(new Date());
    }

    public String obterToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return gerarToken(claims, userDetails.getUsername());
    }

    private String gerarToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + VALIDADE_TOKEN * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public Boolean validarToken(String token, UserDetails userDetails) {
        final String username = obterUsernamePorToken(token);
        return (username.equals(userDetails.getUsername()) && !tokenExpirado(token));
    }
}
