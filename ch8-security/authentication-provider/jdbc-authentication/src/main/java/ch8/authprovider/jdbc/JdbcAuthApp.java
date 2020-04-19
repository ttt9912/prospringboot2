package ch8.authprovider.jdbc;

import common.todo.rest.CommonTodoRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 *
 * go to localhost:8080/api/todos
 *
 * Logins
 * - user:password
 * - admin:password
 */
@SpringBootApplication
@Import(CommonTodoRestConfig.class)
public class JdbcAuthApp {

    public static void main(String[] args) {
        SpringApplication.run(JdbcAuthApp.class, args);
    }

}

