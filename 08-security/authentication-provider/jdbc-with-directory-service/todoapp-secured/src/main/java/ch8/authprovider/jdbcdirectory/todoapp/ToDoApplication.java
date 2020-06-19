package ch8.authprovider.jdbcdirectory.todoapp;

import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 * requests users from person-directory application REST endpoint
 *
 * IMPORTANT: person-directory/PersonDirectoryApplication must be running!
 *
 * ---------------------------------------------------------------------------------
 * Browser
 * ---------------------------------------------------------------------------------
 * - http://localhost:8080/api/todos
 *
 * logins:
 * - see person-directory/data.sql
 * - Z.B. name=matt@example.com pw=secret
 *
 * ---------------------------------------------------------------------------------
 * curl
 * ---------------------------------------------------------------------------------
 * - curl localhost:8080/api/todos -i -u matt@example.com:secret
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class ToDoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToDoApplication.class, args);
    }
}
