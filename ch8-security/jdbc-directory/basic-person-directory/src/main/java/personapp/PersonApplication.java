package personapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * - all REST endpoints (/**) are secured
 * - users, passwords, roles are defined as Person objects and converted to Spring Users
 *
 * ---------------------------------------------------------------------------------
 * Browser
 * ---------------------------------------------------------------------------------
 * - http://localhost:8080/persons
 * - http://localhost:8080/persons/search/findByEmailIgnoreCase?email=mark@example.com
 * - use any of the Person objects access data
 *
 * ---------------------------------------------------------------------------------
 * curl
 * ---------------------------------------------------------------------------------
 * curl localhost:8080/persons -i -u admin@example.com:admin
 *
 */
@SpringBootApplication
public class PersonApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonApplication.class, args);
    }
}