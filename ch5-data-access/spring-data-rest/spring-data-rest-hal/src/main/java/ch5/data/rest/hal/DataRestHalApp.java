package ch5.data.rest.hal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * ---------------------------------------------------------------------------------
 * Spring Data REST
 * ---------------------------------------------------------------------------------
 * Builds on top of the Spring Data repositories (Jpa, MongoDB, Neo4j, etc.)
 *
 * Exposes a RESTful API from the domain model classes with all the repository
 * methods mapped to controller endpoints
 *
 * Uses HATEOAS and mediatype = HAL
 *
 * Allows hooking into the handling of REST requests by handling Spring
 * ApplicationEvents
 *
 * Creates Endpoints for
 * - Entities (http://localhost:8080/api/persons)
 * - Repository Methods (http://localhost:8080/api/persons/search/findByEmailIgnoreCase?email=mark@example.com)
 *      -> see ch8-security/.../PersonRepository
 *
 * ---------------------------------------------------------------------------------
 *  Spring Boot Auto Configuration
 * ---------------------------------------------------------------------------------
 * - simple spring apps require to @Import RepositoryRestMvcConfiguration
 * - not necessary in spring boot
 *
 * ---------------------------------------------------------------------------------
 * Testing the endpoints
 * ---------------------------------------------------------------------------------
 * # as usual
 * curl http://localhost:8080/api/toDos
 * curl -i -X POST -H "Content-Type: application/json" -d '{"description":"Read the Pro Spring Boot 2nd Edition Book"}' http://localhost:8080/api/toDos
 *
 * # HAL Browser
 * add maven dependency and go to http://localhost:8080
 */
@SpringBootApplication
public class DataRestHalApp {
    public static void main(String[] args) {
        SpringApplication.run(DataRestHalApp.class, args);
    }
}
