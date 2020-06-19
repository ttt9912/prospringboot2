package ch8.authprovider.jdbcrepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

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
public class JdbcRepoApp {

    public static void main(String[] args) {
        SpringApplication.run(JdbcRepoApp.class, args);
    }

    @Bean
    public CommandLineRunner userdetails(UserDetailsService userDetailsService) {
        return args -> {

            final UserDetails user = userDetailsService.loadUserByUsername("user");
            System.out.println(user.getUsername() + " - " + user.getAuthorities());

            final UserDetails admin = userDetailsService.loadUserByUsername("admin");
            System.out.println(admin.getUsername() + " - " + admin.getAuthorities());
        };
    }

}
