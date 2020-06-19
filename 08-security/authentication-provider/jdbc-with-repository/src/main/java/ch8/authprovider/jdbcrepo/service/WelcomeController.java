package ch8.authprovider.jdbcrepo.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello";
    }
}
