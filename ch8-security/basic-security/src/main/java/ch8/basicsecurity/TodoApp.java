package ch8.basicsecurity;

import common.todo.rest.CommonTodoRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * ---------------------------------------------------------------------------------
 * Auto Configuration
 * ---------------------------------------------------------------------------------
 * - creates UserDetailsService bean with a username of 'user' and generated password
 * - creates springSecurityFilterChain Bean of type Filter
 *   (responsible for username/password authentication)
 * - registers springSecurityFilterChain with the Servlet container for every request
 *
 * Sets up:
 * - default login
 * - form-based authentication and logout
 * - password storage with BCrypt
 * - CSRF prevention
 * - Security Headers
 * - integrate with Servlet API methods (HttpServletRequest class)
 *   (#getUserPrincipal(), #getRemoteUser(), #login(), #logout(), #isUserInRole())
 *
 * ---------------------------------------------------------------------------------
 * Browser (use incognito mode!)
 * ---------------------------------------------------------------------------------
 * login page
 *
 * ---------------------------------------------------------------------------------
 * curl (with HTTP Basic Authorization)
 * ---------------------------------------------------------------------------------
 * Basic Authorization - every request contains Authorization Header
 *      'Authorization: Basic dXNlcjoyMDFkYjgwNy1hNmY5LTRiMDQtYmE4OS1jMmE4MjE5YjgzYjU='
 *
 * - curl localhost:8080/api/todos -v -u user:<password>
 * or
 * - curl -v http://user:<password>@localhost:8080/api/todos
 */
@SpringBootApplication
@Import(CommonTodoRestConfig.class)
@RestController
public class TodoApp {
    public static void main(String[] args) {
        SpringApplication.run(TodoApp.class, args);
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello";
    }
}
