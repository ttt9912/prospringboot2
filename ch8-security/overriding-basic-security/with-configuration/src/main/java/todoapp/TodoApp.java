package todoapp;

import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 * override simple security programmatically by extending WebSecurityConfigureAdapter
 *
 * ---------------------------------------------------------------------------------
 * Browser
 * ---------------------------------------------------------------------------------
 * Secured URLs
 * - localhost:8080
 * - localhost:8080/api/todos
 * are redirected to localhost:8080/login
 *
 * ---------------------------------------------------------------------------------
 * curl
 * ---------------------------------------------------------------------------------
 * Problem: -i flag tells that we are redirected to /login
 * Solution: add .httpBasic() to ToDoSecurityConfig to be able to bypass login page
 *
 * curl localhost:8080/api/todos -i -u apress:springboot2
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class TodoApp {
    public static void main(String[] args) {
        SpringApplication.run(TodoApp.class, args);
    }
}
