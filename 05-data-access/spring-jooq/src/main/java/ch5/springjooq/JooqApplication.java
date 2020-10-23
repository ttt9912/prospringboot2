package ch5.springjooq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * - start mariadb docker
 * - run maven plugin to generate models
 * - execute /tests
 */
@SpringBootApplication
public class JooqApplication {

    public static void main(String[] args) {
        SpringApplication.run(JooqApplication.class, args);
    }

}
