package ch5.springjooq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 * - start mariadb docker
 * - $ mvn clean install -P jooq-codegen
 * - execute /tests
 */
@SpringBootApplication
@EnableTransactionManagement
public class JooqApplication {

    public static void main(String[] args) {
        SpringApplication.run(JooqApplication.class, args);
    }

}
