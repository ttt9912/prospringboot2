package ch4.client;

import ch4.client.restclient.ToDoRestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
 * non-web application
 *
 * Domain Model: should match the minimum fields of the servers model
 */
@Slf4j
@SpringBootApplication
public class TodoClientApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TodoClientApp.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

    @Bean
    public CommandLineRunner runner(ToDoRestClient client) {
        return args -> {
            client.findAll().forEach(toDo -> log.info(toDo.toString()));
        };
    }
}
