package ch8.defaultsecurity;

import common.todo.rest.CommonTodoRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

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
 * Form Login and HTTP Basic Authentication are enabled by default. As soon as
 * a configuration is provided, they must be configured explicitly via
 * .httpBasic() resp. .formLogin()
 *
 * ---------------------------------------------------------------------------------
 * Browser (use incognito mode!)
 * ---------------------------------------------------------------------------------
 * localhost:8080/api/todos
 *
 * ---------------------------------------------------------------------------------
 * curl (with HTTP Basic Authorization)
 * ---------------------------------------------------------------------------------
 * $ curl localhost:8080/api/todos -v -u user:<password>
 * $ curl -v http://user:<password>@localhost:8080/api/todos
 */
@SpringBootApplication
@Import(CommonTodoRestConfig.class)
public class TodoApp {
    public static void main(String[] args) {
        SpringApplication.run(TodoApp.class, args);
    }
}
