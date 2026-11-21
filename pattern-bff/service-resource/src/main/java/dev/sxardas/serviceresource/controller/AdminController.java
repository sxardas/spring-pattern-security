package dev.sxardas.serviceresource.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello/admin")
public class AdminController {

    @PreAuthorize("hasAuthority('role_admin')")
    @RequestMapping(method = RequestMethod.GET)
    public String helloAdmin() {
        return "hello admin";
    }

}
