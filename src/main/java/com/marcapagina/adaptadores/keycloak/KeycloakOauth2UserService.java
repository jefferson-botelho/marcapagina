package com.marcapagina.adaptadores.keycloak;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Configuração baseada em
 * https://github.com/thomasdarimont/spring-boot-2-keycloak-oauth-example/blob/master/src/main/java/demo/SpringBoot2App.java
 */

@RequiredArgsConstructor
public class KeycloakOauth2UserService extends OidcUserService {

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser user = super.loadUser(userRequest);
        Set<GrantedAuthority> authorities = new LinkedHashSet<>(user.getAuthorities());
        return new DefaultOidcUser(authorities, userRequest.getIdToken(), user.getUserInfo(), "preferred_username");
    }
}
