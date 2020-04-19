package ch8.authprovider.jdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * ---------------------------------
 * H2 Console
 * ---------------------------------
 * localhost:8080/h2-console
 *
 * ---------------------------------
 * App
 * ---------------------------------
 * localhost:8080/greeting
 *
 * ---------------------------------
 * Logins
 * ---------------------------------
 * - user:password
 * - admin:password
 */
@SpringBootApplication
@RestController
public class JdbcAuthApp {

    public static void main(String[] args) {
        SpringApplication.run(JdbcAuthApp.class, args);
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello";
    }

    @Bean
    public CommandLineRunner ctx(JdbcDaoImpl userDetailsService) {
        return args -> {
            final UserDetails user = userDetailsService.loadUserByUsername("user");
            System.out.println(user.getUsername() + " - " + user.getAuthorities());

            final UserDetails admin = userDetailsService.loadUserByUsername("admin");
            System.out.println(admin.getUsername() + " - " + admin.getAuthorities());
        };
    }

}

