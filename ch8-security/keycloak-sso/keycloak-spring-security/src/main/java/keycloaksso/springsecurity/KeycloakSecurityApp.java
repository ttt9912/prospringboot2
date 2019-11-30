package keycloaksso.springsecurity;

import edurion.appconfigs.datarest.EdurionAngularAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 *
 * Realm    : Edurion
 * Client   : edurionapp1-local
 *
 * --------------------------------------------------------
 * Keycloack Admin Console
 * --------------------------------------------------------
 * - http://localhost:8180/auth/
 * - admin/admin
 */
@SpringBootApplication
@Import(EdurionAngularAppConfig.class)
public class KeycloakSecurityApp {

    public static void main(String[] args) {
        SpringApplication.run(KeycloakSecurityApp.class, args);
    }

}
