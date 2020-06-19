package ch5.data.jpa;

import ch5.data.jpa.data.ToDo;
import ch5.data.jpa.data.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
 * ---------------------------------------------------------------------------------
 *  Spring Data JPA Features
 * ---------------------------------------------------------------------------------
 * - Mappings
 * - Repositories (a domain driven design concept)
 * - @Query
 * - Auditing
 * - QueryDsl support (typesafe jpa queries)
 *
 * ---------------------------------------------------------------------------------
 *  Spring Boot Auto Configuration
 * ---------------------------------------------------------------------------------
 * if Spring Data JPA jar is on the classpath, spring boot auto-configures
 *  - DataSource, if none is configured
 *  - JPA Provider (default: Hibernate)
 *  - repositories with @EnableJpaRepositories
 *
 * Spring Data JPA includes spring-jdbc -> JdbcTemplate etc. is available
 *
 * ---------------------------------------------------------------------------------
 *  Domain Model Annotations - javax.persistence
 * ---------------------------------------------------------------------------------
 * @Entity, @Id, @GeneratedValue, @Column, @PrePersist, @PreUpdate, etc.
 *
 * ---------------------------------------------------------------------------------
 * spring.jpa.hibernate.ddl-auto property
 * ---------------------------------------------------------------------------------
 * - create
 * - create-drop
 * - update (Updates the schema, if necessary)
 * - validate (Validates the schema, makes no changes to the database)
 * - none (Disables DDL handling)
 *
 * ---------------------------------------------------------------------------------
 * H2 Console
 * ---------------------------------------------------------------------------------
 * http://localhost:8080/h2-console
 * -> jdbc:h2:mem:testdb
 */
@SpringBootApplication
public class DataJpaApp {
    public static void main(String[] args) {
        SpringApplication.run(DataJpaApp.class, args);
    }

    @Bean
    CommandLineRunner init(ToDoRepository repository) {
        return args -> repository.save(new ToDo(null, "feed dog", null, null, false));
    }
}
