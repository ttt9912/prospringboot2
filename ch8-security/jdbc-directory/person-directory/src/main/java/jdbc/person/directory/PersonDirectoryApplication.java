package jdbc.person.directory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * - all REST endpoints (/**) are secured
 * - user, password, roles are defined as Person object and converted to Spring Users
 *
 * ---------------------------------------------------------------------------------
 * Browser
 * ---------------------------------------------------------------------------------
 * - http://localhost:8181/persons
 * - http://localhost:8181/persons/search/findByEmailIgnoreCase?email=mark@example.com
 * - use any of the Person objects access dto
 *
 * ---------------------------------------------------------------------------------
 * curl
 * ---------------------------------------------------------------------------------
 * curl localhost:8181/persons -i -u admin@example.com:admin
 *
 */
@SpringBootApplication
public class PersonDirectoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonDirectoryApplication.class, args);
    }
}