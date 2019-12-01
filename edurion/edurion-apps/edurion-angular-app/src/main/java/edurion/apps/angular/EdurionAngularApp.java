package edurion.apps.angular;

import edurion.appconfigs.datarest.EdurionAngularAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 *
 * --------------------------------------------------------
 * Edurion Angular Webjar
 * --------------------------------------------------------
 * - clean install edurion-ui-angular first
 * - localhost:8080
 *
 * --------------------------------------------------------
 * Alternative:
 * --------------------------------------------------------
 * maven-resource-plugin - copy ui from angular module to /target
 */
@SpringBootApplication
@Import(EdurionAngularAppConfig.class)
public class EdurionAngularApp {

    public static void main(String[] args) {
        SpringApplication.run(EdurionAngularApp.class, args);
    }
}
