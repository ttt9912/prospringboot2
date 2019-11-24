package keycloacksso.plain;

import edurion.appconfigs.datarest.EdurionAngularAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 *
 * --------------------------------------------------------
 * Keycloack Admin Console
 * --------------------------------------------------------
 * - http://localhost:8180/auth/
 * - admin/admin
 */
@SpringBootApplication
@Import(EdurionAngularAppConfig.class)
public class KeycloackSSOApp {

    public static void main(String[] args) {
        SpringApplication.run(KeycloackSSOApp.class, args);
    }

}
