package nosql.mongodb;

import nosql.mongodb.data.ToDo;
import nosql.mongodb.data.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
 * ---------------------------------------------------------------------------------
 * Spring Data MongoDB
 * ---------------------------------------------------------------------------------
 * MongoDB = Document Database
 *
 * Same model and repositories can be reused
 * with @Document instead of @Entity
 *
 * ---------------------------------------------------------------------------------
 * Spring Data MongoDB Features
 * ---------------------------------------------------------------------------------
 * - MongoTemplate
 * - persistence and mapping lifecycle events
 * - MongoReader/MongoWriter (low level mapping)
 * - query, criteria, dsl
 * - MapReduce
 * - Cross storage support for JPA entities (@Entity can be used)
 *
 * ---------------------------------------------------------------------------------
 * MongoDB server
 * ---------------------------------------------------------------------------------
 * by default spring boot tries to connect to localhost:27017
 *
 * remote server can be configured spring.mongodb.* properties
 *
 *  spring.data.mongodb.host,
 *  spring.data.mongodb.port,
 *  spring.data.mongodb.username,
 *  spring.data.mongodb.password
 *
 * ---------------------------------------------------------------------------------
 * MongoDB embedded server
 * ---------------------------------------------------------------------------------
 * - maven dependency - use it with test scope or with runtime scope in dev mode
 * - Configure a MongoClient to use the mongodb server
 */
@SpringBootApplication
public class DataMongoDbApp {
    public static void main(String[] args) {
        SpringApplication.run(DataMongoDbApp.class, args);
    }

    @Bean
    CommandLineRunner init(ToDoRepository repository) {
        return args -> repository.save(new ToDo("feed dog"));
    }
}
