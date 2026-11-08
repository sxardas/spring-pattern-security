package dev.sxardas.serviceweb.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello/user")
public class UserController {

    @PreAuthorize("hasAuthority('role_user')")
    @RequestMapping(method = RequestMethod.GET)
    public String helloUser() {
        return "hello user";
    }

}
