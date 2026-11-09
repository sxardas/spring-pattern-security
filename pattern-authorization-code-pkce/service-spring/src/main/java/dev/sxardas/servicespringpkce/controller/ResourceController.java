package dev.sxardas.servicespringpkce.controller;

import dev.sxardas.servicespringpkce.dto.MeResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResourceController {

    @RequestMapping(method = RequestMethod.GET, value = "/me")
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

    @PreAuthorize("hasAuthority('role_admin')")
    @RequestMapping(method = RequestMethod.GET, value = "/admin/hello")
    public String adminHello() {
        return "Hello admin!";
    }

    @PreAuthorize("hasAuthority('role_user')")
    @RequestMapping(method = RequestMethod.GET, value = "/user/hello")
    public String userHello() {
        return "Hello user!";
    }

}
