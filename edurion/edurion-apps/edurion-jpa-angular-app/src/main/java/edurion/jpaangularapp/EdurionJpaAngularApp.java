package edurion.jpaangularapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * maven-resource-plugin - copy ui from angular module to /target
 */
@SpringBootApplication
public class EdurionJpaAngularApp {

    public static void main(String[] args) {
        SpringApplication.run(EdurionJpaAngularApp.class, args);
    }
}
