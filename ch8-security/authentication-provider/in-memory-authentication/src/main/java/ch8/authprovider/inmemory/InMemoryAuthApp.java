package ch8.authprovider.inmemory;

import common.todo.rest.CommonTodoRestConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/*
 *
 * go to localhost:8080/api/todos
 *
 * Logins
 * - user:password
 * - admin:password
 */
@SpringBootApplication
@Import(CommonTodoRestConfig.class)
public class InMemoryAuthApp {

    public static void main(String[] args) {
        SpringApplication.run(InMemoryAuthApp.class, args);
    }

    @Bean
    public CommandLineRunner ctx(InMemoryUserDetailsManager userDetailsService) {
        return args -> {
            final UserDetails user = userDetailsService.loadUserByUsername("user");
            System.out.println(user.getUsername() + " - " + user.getAuthorities());

            final UserDetails admin = userDetailsService.loadUserByUsername("admin");
            System.out.println(admin.getUsername() + " - " + admin.getAuthorities());
        };
    }
}

