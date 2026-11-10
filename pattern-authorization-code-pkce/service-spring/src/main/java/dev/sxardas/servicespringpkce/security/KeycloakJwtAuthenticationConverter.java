package dev.sxardas.servicespringpkce.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class KeycloakJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private static final String REALM_ACCESS = "realm_access";
    private static final String REALM_ROLES = "roles";

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        return new JwtAuthenticationToken(
                jwt, extract(jwt), jwt.getSubject()
        );
    }

    private Collection<GrantedAuthority> extract(Jwt jwt) {
        Map<String, Object> access = jwt.getClaimAsMap(REALM_ACCESS);

        if (access == null || !(access.get(REALM_ROLES) instanceof Collection<?> roles)) {
            return List.of();
        }

        return roles.stream()
                .map(role -> (GrantedAuthority) new SimpleGrantedAuthority(String.valueOf(role)))
                .toList();
    }

}
