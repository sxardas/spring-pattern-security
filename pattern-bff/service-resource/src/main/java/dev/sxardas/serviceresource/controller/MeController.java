package dev.sxardas.serviceresource.controller;

import dev.sxardas.serviceresource.dto.MeResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/me")
public class MeController {

    @RequestMapping(method = RequestMethod.GET)
    public MeResponse me(
            @AuthenticationPrincipal Jwt jwt, Authentication authentication
    ) {
        List<String> authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return MeResponse.builder()
                .subject(jwt.getSubject())
                .authorities(authorities)
                .build();
    }

}
