package ch13.todotestapp;

import ch13.todoclient.annotation.EnableTodoPasswordEncoder;
import ch13.todoclient.client.TodoRestClient;
import ch13.todoclient.dto.TodoDto;
import common.todo.data.rest.CommonTodoDataRestConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * # common
 * - start rest webserver (port 10000)
 *
 * # starter
 * - use starter to setup a client bean
 * - use @EnableTodoPasswordEncoder to setup a PasswordEncoder bean
 */
@Slf4j
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
@EnableTodoPasswordEncoder
public class TodoApp {

    public static void main(String[] args) {
        SpringApplication.run(TodoApp.class);
    }

    /*
     * @EnableTodoPasswordEncoder
     * - sets up a bean of type PasswordEncoder
     * - either BCrypt or Pbkd2, based on annotation argument
     */
    @Bean
    CommandLineRunner enableFeature(final PasswordEncoder passwordEncoder) {
        // without @EnableTodoPasswordEncoder, passwordEncoder will be null
        return args -> {
            log.info("PasswordEncoder bean: {}", passwordEncoder);
        };
    }

    /*
     * starter dependency (auto configuration)
     * - TodoClientAutoConfiguration auto-configures a bean of type TodoRestClient
     */
    @Bean
    CommandLineRunner starter(final TodoRestClient todoRestClient) {
        return args -> {
            TodoDto todoDto = todoRestClient.findById("8a8080a365481fb00165481fbca90000");
            log.info("TodoDto: {}", todoDto);
        };
    }

}
