package keycloacksso.plain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * - no spring security
 * - secured paths are defined in application.properties
 *
 * --------------------------------------------------------
 * Edurion Angular Webjar
 * --------------------------------------------------------
 * - clean install edurion-ui-angular first
 * - localhost:8080
 *
 * --------------------------------------------------------
 * Keycloack
 * --------------------------------------------------------
 * Realm    : Edurion
 * Client   : edurionapp-local
 *
 * --------------------------------------------------------
 * Keycloack Admin Console
 * --------------------------------------------------------
 * - http://localhost:8180/auth/
 * - admin/admin
 */
@SpringBootApplication
// @Import(EdurionAngularAppConfig.class) // TODO: this is broken now
public class KeycloackSSOApp {

    public static void main(String[] args) {
        SpringApplication.run(KeycloackSSOApp.class, args);
    }

}
