package keycloacksso.plain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 *
 * --------------------------------------------------------
 * Keycloack docker
 * --------------------------------------------------------
 * - Admin Console: http://localhost:8180/auth/
 */
@SpringBootApplication
public class KeycloackSSOApp {

    public static void main(String[] args) {
        SpringApplication.run(KeycloackSSOApp.class, args);
    }

}
