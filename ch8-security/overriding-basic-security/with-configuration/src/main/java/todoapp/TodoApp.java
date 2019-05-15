package todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * override simple security programmatically by extending WebSecurityConfigureAdapter
 *
 * Secured URLs
 * - localhost:8080
 * - localhost:8080/api/toDos
 * are redirected to localhost:8080/login
 */
@SpringBootApplication
public class TodoApp {
    public static void main(String[] args) {
        SpringApplication.run(TodoApp.class, args);
    }
}
