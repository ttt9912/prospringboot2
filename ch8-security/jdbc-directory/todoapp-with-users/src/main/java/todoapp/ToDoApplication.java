package todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * requests users from person-directory application REST endpoint
 *
 * IMPORTANT: person-directory/PersonDirectoryApplication must be running!
 *
 * ---------------------------------------------------------------------------------
 * Browser
 * ---------------------------------------------------------------------------------
 * - http://localhost:8080/api/toDos
 *
 * logins:
 * - see person-directory/data.sql
 * - Z.B. name=matt@example.com pw=secret
 *
 * ---------------------------------------------------------------------------------
 * curl
 * ---------------------------------------------------------------------------------
 * - curl localhost:8080/api/toDos -i -u matt@example.com:secret
 */
@SpringBootApplication
public class ToDoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToDoApplication.class, args);
    }
}
