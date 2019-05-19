package todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * override simple security with 'spring.security.*' properties
 *
 *
 */
@SpringBootApplication
public class TodoApp {
    public static void main(String[] args) {
        SpringApplication.run(TodoApp.class, args);
    }
}
