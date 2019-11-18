package edurion.datajpaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * ---------------------------------------------------------------------------------
 * H2 Console
 * ---------------------------------------------------------------------------------
 * http://localhost:8080/h2-console
 * -> jdbc:h2:mem:testdb
 */
@SpringBootApplication
public class EdurionDataJpaApp {

    public static void main(String[] args) {
        SpringApplication.run(EdurionDataJpaApp.class, args);
    }
}
