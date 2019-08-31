package basic.security;

import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 * spring-boot-starter-security
 * - auto-configures strategy whether to use httpBasic or formLogin
 * - default: UserDetailService with a single user
 * - username: user, pw: printed with level INFO at startup
 *
 * by adding the spring-boot-starter-security dependency, the application is already secured
 *
 * ---------------------------------------------------------------------------------
 * Browser
 * ---------------------------------------------------------------------------------
 * login page
 *
 * ---------------------------------------------------------------------------------
 * curl
 * ---------------------------------------------------------------------------------
 * curl localhost:8080/api/todos -u user:<password>
 * or
 * curl http://user:<password>@localhost:8080/api/todos
 *
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class TodoApp {
    public static void main(String[] args) {
        SpringApplication.run(TodoApp.class, args);
    }
}
