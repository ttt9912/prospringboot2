package ch5.data.rest.repository.eventhandler;

import ch5.data.rest.repository.eventhandler.eventhandler.TodoEventHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/*
 * Spring Data REST has several events that allow control before, during, and after a persistence action
 *
 * NOTE: Event Handlers are only invoked when you fire a HTTP Requests on exposed Spring Data REST endpoints
 *
 * ---------------------------------------------------------------------------------
 * Try it
 * ---------------------------------------------------------------------------------
 * curl -i -X POST -H "Content-Type: application/json" -d '{"description":"Read the Pro Spring Boot 2nd Edition Book"}' http://localhost:8080/api/toDos
 */
@SpringBootApplication
public class DataRestEventhandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataRestEventhandlerApplication.class, args);
    }
}
