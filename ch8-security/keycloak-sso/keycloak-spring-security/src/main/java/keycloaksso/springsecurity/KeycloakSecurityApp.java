package keycloaksso.springsecurity;

import edurion.appconfigs.datarest.EdurionAngularAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 * --------------------------------------------------------
 * TODO: Problem
 * --------------------------------------------------------
 * - /api/* is secured
 * - call to localhost:8080/api/edutasks will redirect to keycloak logn (good)
 * - call to localhost:8080 will load angular, which will call localhost:8080/api/edutasks
 *   but no redirect will happen, just angular page without results (bad)
 * - Angular does not follow the Location in the response header
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
