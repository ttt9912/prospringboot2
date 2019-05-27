package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/*
 * 1. go to 'localhost:9999/client' (Client App)
 * 2. redirects to 'localhost:8080' (Authorization Server)
 *
 * TODO: redirect does not work properly
 */
@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class ClientApplication {

    @RequestMapping("/home")
    public Principal home(Principal principal) {
        return principal;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
}
